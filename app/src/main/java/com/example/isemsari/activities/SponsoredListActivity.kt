package com.example.isemsari.activities

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.isemsari.R
import com.example.isemsari.SponsoredViewModel
import com.example.isemsari.activities.adapter.SponsoredRecyclerAdapter
import com.example.isemsari.components.ISemsariButton
import com.example.isemsari.components.ISemsariCardView
import com.example.isemsari.databinding.ActivitySponsoredListingCardBinding
import com.example.isemsari.models.SpsonsoredListResponseModel
import com.example.isemsari.repository.Result
import com.example.isemsari.services.ListingService
import com.example.isemsari.utils.AppConstants.baseUrl
import com.google.android.material.bottomnavigation.BottomNavigationView
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SponsoredListActivity : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView

    //    lateinit var recyclerView: RecyclerView
//    lateinit var progress: ProgressBar
    lateinit var binding: ActivitySponsoredListingCardBinding

    private val viewModel = SponsoredViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


//
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sponsored_listing_card)
        viewModel.getHomeListCoroutines("1", "4") //call api
        viewModel.liveData.observe(this){
            when(it){
                is Result.Error -> Toast.makeText(this, it.errorMessage, Toast.LENGTH_SHORT).show()
                is Result.Loading -> Log.d("TAG", "onCreate: LOADING")
                is Result.Success ->   binding.listviewSponsored.adapter = it.data?.let { it1 ->
                    SponsoredRecyclerAdapter(
                        it1
                    )
                }
            }
        }

//        progress = findViewById(R.id.progress_sponsored)
//        val back = findViewById<ImageView>(R.id.ic_back_arrow)
        binding.icBackArrow.setOnClickListener(backToMainActivity)


//        recyclerView = findViewById(R.id.listview_sponsored)




    }


    private fun getData() {
//        val logger: HttpLoggingInterceptor =
//            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
//        val headerInterceptor = object : Interceptor {
//            override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
//                var request = chain.request()
//                request = request.newBuilder().addHeader("Content-Type", "application/json")
//                    .build()
//                val response = chain.proceed(request)
//                return response
//            }
//1
//        }
//        val okHttp: OkHttpClient.Builder = OkHttpClient.Builder().addInterceptor(
//            headerInterceptor
//        ).addInterceptor(logger)
        val retrofit = Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create()).build()
        val sponsoredService = retrofit.create(ListingService::class.java)
        val call = sponsoredService.getHomeList("1", "4")
        call.enqueue(object : Callback<List<SpsonsoredListResponseModel>> {
            override fun onResponse(
                call: Call<List<SpsonsoredListResponseModel>>,
                response: Response<List<SpsonsoredListResponseModel>>
            ) {
                if (response.isSuccessful && response.code() == 200) {
                    binding.progressSponsored.visibility = View.GONE
                    binding.listviewSponsored.adapter = SponsoredRecyclerAdapter(response.body()!!)
                } else {
                    Toast.makeText(
                        this@SponsoredListActivity,
                        "faile ${response.message()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }

            override fun onFailure(
                call: Call<List<SpsonsoredListResponseModel>>,
                t: Throwable?
            ) {
                Toast.makeText(this@SponsoredListActivity, "Failed", Toast.LENGTH_SHORT).show()
                // Log error here since request failed
            }
        })
    }

    private val backToMainActivity = View.OnClickListener {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

}