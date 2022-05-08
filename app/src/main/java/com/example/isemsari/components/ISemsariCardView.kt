package com.example.isemsari.components

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.isemsari.R
import com.example.isemsari.R.id.isemsari_custom_card

class ISemsariCardView(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {
    init {
        var inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.isemsari_cardview, this, true)
        val ta: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.ISemsariCardView)
        val backgroundimg = ta.getDrawable(R.styleable.ISemsariCardView_backgroundimg)
        val text_left = ta.getString(R.styleable.ISemsariCardView_text_left)
        val text_right = ta.getString(R.styleable.ISemsariCardView_text_right)
        val text_bottom = ta.getString(R.styleable.ISemsariCardView_text_bottom_card)
        val imgbtn = ta.getDrawable(R.styleable.ISemsariCardView_imgbtn)

        val card: CardView = findViewById<View>(isemsari_custom_card) as CardView
        val backimage: ImageView = findViewById<View>(R.id.img_background_card) as ImageView
        val imagebtn: ImageButton = findViewById<View>(R.id.img_btn_card) as ImageButton
        val txt_lef: TextView = findViewById<View>(R.id.txt_left) as TextView
        val txt_ri: TextView = findViewById<View>(R.id.txt_right) as TextView
        val txt_bot: TextView = findViewById<View>(R.id.txt_bottom_card) as TextView
        backimage.setImageDrawable(backgroundimg)
        txt_ri.text = text_right
        txt_lef.text = text_left
        txt_bot.text = text_bottom
        imagebtn.setImageDrawable(imgbtn)

    }
    fun onClickHandler(function: () -> (Unit)) {
        val card: CardView = findViewById<View>(R.id.isemsari_custom_card) as CardView
        card.setOnClickListener(View.OnClickListener {
            function()
        })

    }



}