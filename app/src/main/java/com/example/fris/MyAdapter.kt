package com.example.fris

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.fris.database.Dessert
import kotlinx.android.synthetic.main.dessert_cardview.*


class MyAdapter(var cardClicklistener:(/*hva som sendes tilbake*/) -> Unit, private var dessertDataset: List<Dessert>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    //TODO: LAGE EGEN KLASSE AV DETTE, HVOR DU HAR ALT AV TEXT OG BILDER LAGRET (SE CHATBUBBLEVIEW FRA SMALLTALK).
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

            val name: TextView = view.findViewById(R.id.name_textview)

        }

        // Create new views (invoked by the layout manager)
        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

            // Create a new view, which defines the UI of the list item
            val view = LayoutInflater.from(viewGroup.context).inflate(
                R.layout.dessert_cardview,
                viewGroup,
                false
            ) as View

            return ViewHolder(view)
        }

        // Replace the contents of a view (invoked by the layout manager)
        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

            viewHolder.name.text = dessertDataset[position].dessertName

            //cardClicklistener. håndterer hvilken kort da som blir trykket på, og du sender det tilbake til Home. for eksempel dessert
            //som blir trykket på. Utifra det intenter du til neste activity.

        }

        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount() = dessertDataset.size

        fun updateData(newData: List<Dessert>) {
            dessertDataset = newData
            notifyDataSetChanged()
        }



}