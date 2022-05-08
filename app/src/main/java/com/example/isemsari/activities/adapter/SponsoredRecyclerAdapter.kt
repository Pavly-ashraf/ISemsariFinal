package com.example.isemsari.activities.adapter
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.isemsari.activities.DetailsActivity
import com.example.isemsari.R
import com.example.isemsari.models.SpsonsoredListResponseModel
import com.squareup.picasso.Picasso

class SponsoredRecyclerAdapter(private val dataSet: List<SpsonsoredListResponseModel>) :
    RecyclerView.Adapter<SponsoredRecyclerAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txt_right: TextView
        val txt_bottom_card: TextView
        val txt_left: TextView
        val img_background_card: ImageView
        val card : CardView

        init {
            // Define click listener for the ViewHolder's View.
            txt_right = view.findViewById(R.id.txt_right)
            txt_bottom_card = view.findViewById(R.id.txt_bottom_card)
            txt_left = view.findViewById(R.id.txt_left)
            img_background_card = view.findViewById(R.id.img_background_card)
            card = view.findViewById(R.id.isemsari_custom_card)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.isemsari_cardview, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        viewHolder.card.setOnClickListener { v ->
            val currentObject : SpsonsoredListResponseModel = dataSet[position]
            v.context.startActivity(Intent(v.context,DetailsActivity::class.java).putExtra("Model",currentObject))

        }

        viewHolder.itemView.setOnClickListener { v ->
            val currentObject : SpsonsoredListResponseModel = dataSet[position]
            v.context.startActivity(Intent(v.context,DetailsActivity::class.java).putExtra("Model",currentObject))
        }
        viewHolder.txt_right.text = dataSet[position].Price.toString()
        viewHolder.txt_bottom_card.text = dataSet[position].Title

        if(dataSet[position].AdImages.size != 0 )
           Picasso.get().load("https://isemsari.com/" + dataSet[position].AdImages[0].ImagePathUrl).into(viewHolder.img_background_card)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}