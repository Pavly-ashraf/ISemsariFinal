package com.example.isemsari.activities.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.isemsari.activities.DetailsActivity
import com.example.isemsari.R
import com.example.isemsari.models.AdStatusModel
import com.example.isemsari.models.SpsonsoredListResponseModel
import com.squareup.picasso.Picasso

class FacilityLIstyRecyclerAdapter(private val dataSet: List<AdStatusModel>) :
    RecyclerView.Adapter<FacilityLIstyRecyclerAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val txt_garden: TextView
        val img_garden: ImageView


        init {
            // Define click listener for the ViewHolder's View.

            txt_garden = view.findViewById(R.id.txt_garden)
            img_garden = view.findViewById(R.id.img_garden)

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.facility_list, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element


        Picasso.get().load("https://isemsari.com/" + dataSet[position].IconUrlPath)
            .into(viewHolder.img_garden)
        viewHolder.txt_garden.text = dataSet[position].NameEn


    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}