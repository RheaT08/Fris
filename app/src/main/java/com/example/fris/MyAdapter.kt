package com.example.fris

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fris.database.Dessert
import com.example.fris.ui.utforsk.HomeFragment


class MyAdapter(var context: Context, var cardClicklistener:(Dessert) -> Unit, private var dessertDataset: List<Dessert>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    //TODO: LAGE EGEN KLASSE AV DETTE, HVOR DU HAR ALT AV TEXT OG BILDER LAGRET (SE CHATBUBBLEVIEW FRA SMALLTALK).
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

            val name: TextView = view.findViewById(R.id.name_textview)
            val image: ImageView = view.findViewById(R.id.dessert_Image)
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
            val pic = dessertDataset[position].bilde

            viewHolder.image.setImageResource(pic)

            viewHolder.name.setOnClickListener {
                cardClicklistener(dessertDataset[position])
                HomeFragment.valgt_iskrem = dessertDataset[position].id
            }

            viewHolder.image.setOnClickListener {
                cardClicklistener(dessertDataset[position])
                HomeFragment.valgt_iskrem = dessertDataset[position].id
            }

            //cardClicklistener. håndterer hvilken kort da som blir trykket på, og du sender det tilbake til Home. for eksempel dessert
            //som blir trykket på. Utifra det intenter du til neste activity fra HomeFragment.
        }



        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount() = dessertDataset.size

        fun updateData(newData: List<Dessert>) {
            dessertDataset = newData
            notifyDataSetChanged()
        }



}