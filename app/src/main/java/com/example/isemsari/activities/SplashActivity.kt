package com.example.isemsari.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.window.SplashScreen
import androidx.appcompat.app.AppCompatActivity
import com.example.isemsari.R
import com.example.isemsari.components.ISemsariButton



class SplashActivity : AppCompatActivity() {
    lateinit var prefrences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)

        val button: ISemsariButton = findViewById<View>(R.id.btn_login) as ISemsariButton

        prefrences = getSharedPreferences("shared_pref", Context.MODE_PRIVATE)
        val check = prefrences.getString("username", "")
        if (check!!.isNotEmpty()) {

            button.onClickHandler {
                val intent = Intent(this, SponsoredListActivity::class.java)
                startActivity(intent)
            }
        }else {
            button.onClickHandler(
                ::onClickListener
            )
        }
    }


    fun onClickListener() {

        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)

    }


}
