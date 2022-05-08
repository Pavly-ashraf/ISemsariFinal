package com.example.isemsari.activities

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import com.example.isemsari.R

class DeterminateProgressActivity : AppCompatActivity() {

    private var progr = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_determinate_progress)

        updateProgressBar()
        val bt_save: Button = findViewById(R.id.btn_save)

        val btn_inc: Button = findViewById(R.id.btn_incr)
        val btn_dec: Button = findViewById(R.id.btn_decr)
        btn_inc.setOnClickListener {
            if (progr <= 90) {
                progr += 10
                updateProgressBar()
            }
        }
        bt_save.setOnClickListener {
            saveData()
        }
        btn_dec.setOnClickListener {
            if (progr >= 10) {
                progr -= 10
                updateProgressBar()
            }
        }


    }

    private fun saveData() {
val insertedText : EditText = findViewById(R.id.ed_text)
        val sharedPref :SharedPreferences = getSharedPreferences("sharedprefs", Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = sharedPref.edit()
        editor.apply(


        )


    }

    private fun updateProgressBar() {
        val prog: ProgressBar = findViewById(R.id.progress_bar)
        prog.progress = progr
        val text_progress: TextView = findViewById(R.id.txt_progress)
        text_progress.text = "$progr%"

    }

}