package com.example.isemsari.components
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import com.example.isemsari.R

class ISemsariButton(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {
    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.isemsari_button, this, true)
        val ta: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.
        ISemsariButton)
        val backcolor = ta.getColor(
            R.styleable.ISemsariButton_backcolor,
            ResourcesCompat.getColor(resources, R.color.mainColor, null)
        )
        val textcolor = ta.getColor(
            R.styleable.ISemsariButton_textcolor,
            ResourcesCompat.getColor(resources, R.color.mainColor, null)
        )
        val text = ta.getString(R.styleable.ISemsariButton_text)
        val drright = ta.getDrawable(R.styleable.ISemsariButton_drright)
        val drleft = ta.getDrawable(R.styleable.ISemsariButton_drleft)

        val button: Button = findViewById<View>(R.id.isemsari_custom_button) as Button
        val image: ImageView = findViewById<View>(R.id.drright) as ImageView
        val imageleft: ImageView = findViewById<View>(R.id.drLeft) as ImageView
        button.setBackgroundColor(backcolor)
        button.setTextColor(textcolor)
        button.text = text
        if (drright != null) {
            image.setImageDrawable(drright)
        }
        if (drleft != null) {
            imageleft.setImageDrawable(drleft)
        }

    }

    fun onClickHandler(function: () -> (Unit)) {
        val button: Button = findViewById<View>(R.id.isemsari_custom_button) as Button
        button.setOnClickListener(View.OnClickListener {
            function()
        })

    }

}