package com.example.isemsari.activities

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.isemsari.R
import com.example.isemsari.components.ISemsariButton
import com.example.isemsari.models.LoginResponseModel
import com.example.isemsari.models.UserModel
import com.example.isemsari.services.LoginService
import com.example.isemsari.utils.AppConstants.loginUrl
import kotlinx.coroutines.delay
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {
    lateinit var username: EditText
    lateinit var password: EditText
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val back = findViewById<ImageView>(R.id.ic_back_arrow)
        back.setOnClickListener(backToMainActivity)

        username = findViewById(R.id.edUserName)
        password = findViewById(R.id.edPassword)


        val button: ISemsariButton = findViewById<View>(R.id.btn_log) as ISemsariButton
        button.onClickHandler({
            login()

//            val intent = Intent(this@LoginActivity, SponsoredListActivity::class.java)
//            startActivity(intent)
        })
    }

    private val backToMainActivity = View.OnClickListener {
//        val intent = Intent(this, SplashActivity::class.java)
//        startActivity(intent)
        super.onBackPressed();
    }


    private fun login() {
        val retrofit = Retrofit.Builder().baseUrl( loginUrl)
            .addConverterFactory(GsonConverterFactory.create()).build()
        val loginService = retrofit.create(LoginService::class.java)
        val call = loginService.login(UserModel(username.text.toString(), password.text.toString()))
        call.enqueue(object : Callback<LoginResponseModel> {

            override fun onResponse(
                call: Call<LoginResponseModel>,
                response: Response<LoginResponseModel>
            ) {
                if (response.isSuccessful && response.code() == 200) {
                    sharedPreferences = getSharedPreferences("shared_pref", Context.MODE_PRIVATE)
                    val editor: SharedPreferences.Editor = sharedPreferences.edit()
                    editor.putString("username", username.toString())
                    editor.putString("password", password.toString())
                    editor.putString("token",response.body()!!.token)
                    editor.apply()
                    val intent = Intent(this@LoginActivity, SponsoredListActivity::class.java)
                    startActivity(intent)
                } else {
//
                    val view = View.inflate(this@LoginActivity, R.layout.login_dialog, null)
                    val builder = AlertDialog.Builder(this@LoginActivity)
                    builder.setView(view)
                    val dialog = builder.create()
                    dialog.show()
                    dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)


                }

            }

            override fun onFailure(call: Call<LoginResponseModel>, t: Throwable?) {
                Toast.makeText(this@LoginActivity, "Failed", Toast.LENGTH_SHORT).show()
                // Log error here since request failed
            }
        })
    }
}