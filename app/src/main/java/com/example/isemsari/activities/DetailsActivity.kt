package com.example.isemsari.activities

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.isemsari.R
import com.example.isemsari.activities.adapter.FacilityLIstyRecyclerAdapter
import com.example.isemsari.components.ISemsariButton
import com.example.isemsari.databinding.ActivityDetailsBinding
import com.example.isemsari.models.SpsonsoredListResponseModel
import com.example.isemsari.utils.AppConstants.baseUrl
import com.squareup.picasso.Picasso
import java.util.*

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    @BindingAdapter("imageUrl")
    fun loadImage(view: ImageView, url: String?) {
        Picasso.get().load(url).into(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)
        binding.listing = intent.getSerializableExtra("Model") as SpsonsoredListResponseModel

        val model: SpsonsoredListResponseModel =
            intent.getSerializableExtra("Model") as SpsonsoredListResponseModel


        Picasso.get().load(baseUrl + model.AdImages[0].ImagePathUrl)
            .into(binding.imgDetailsCard)

        Picasso.get().load(baseUrl + model.FloorPlanUrlPath)
            .into(binding.imgFloorPlan)

        binding.facilitiesRecyclerView.adapter = FacilityLIstyRecyclerAdapter(model.Facilities)

        binding.btnCall.onClickHandler({
            if (ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this, arrayOf(android.Manifest.permission.CALL_PHONE),
                    1
                )

            } else {

                val number = model.Phone.toString()
                val intent =
                    Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number))
                startActivity(intent)

            }
        })

        binding.btnShowMap.onClickHandler({
            val uri: String =
                java.lang.String.format(
                    Locale.ENGLISH,
                    "geo:%f,%f",
                    model.LocationLatitude,
                    model.LocationLongitude
                )
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
            startActivity(intent)


        })




        binding.btnMessage.onClickHandler({
            val number = model.Phone // The number on which you want to send SMS

            startActivity(Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", number, null)))


        })
    }


}
        //        val txt_title: TextView = findViewById(R.id.txt_title)
//        txt_title.text = model.Title.toString()
//        binding.txtTitle.text = model.Title.toString()


//        val txt_price: TextView = findViewById(R.id.price)
//        txt_price.text = model.Price.toString()
//        binding.price.text = model.Price.toString()

//        val imagecard: ImageView = findViewById(R.id.img_details_card)

        //        val imagefloor: ImageView = findViewById(R.id.img_floor_plan)
//        val txt_address: TextView = findViewById(R.id.txt_location_address)
//        txt_address.text = model.Address.toString()
//        binding.txtLocationAddress.text=model.Address
//        val txt_area: TextView = findViewById(R.id.txt_area_number)
//        txt_area.text = model.Area.toString()
//        binding.txtAreaNumber.text = model.Area.toString()
//        val bedroom_number: TextView = findViewById(R.id.txt_bedroom_number)
//        bedroom_number.text = model.Rooms.toString()
//        binding.txtBedroomNumber.text=model.Rooms
//        val bathroom_number: TextView = findViewById(R.id.txt_bathroom_number)
//        bathroom_number.text = model.Baths.toString()
//        binding.txtBathroomNumber.text = model.Baths
//        val txt_descreption: TextView = findViewById(R.id.txt_descreption)
//        txt_descreption.text = model.Description.toString()
//        val recyclerView: RecyclerView = findViewById(R.id.facilities_recycler_view)
//        recyclerView.adapter = FacilityLIstyRecyclerAdapter(model.Facilities!!)
        //        val button_message: ISemsariButton = findViewById<View>(R.id.btn_message) as ISemsariButton
        //        val button_map: ISemsariButton = findViewById<View>(R.id.btn_show_map) as ISemsariButton
//        button_call.onClickHandler({
//
//
//        })
//        button_map.onClickHandler
//        button_message.onClickHandler

//        if (model.Price > 1500000) {
//            binding.price.setTextColor(resources.getColor(R.color.red))
//        } else {
//            binding.price.setTextColor(resources.getColor(R.color.Green))
//
//        }
