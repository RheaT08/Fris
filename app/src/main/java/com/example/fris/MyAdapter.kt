package com.example.fris

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fris.database.Dessert
import com.example.fris.ui.utforsk.DessertView
import com.example.fris.ui.utforsk.HomeFragment
import kotlinx.android.synthetic.main.dessert_cardview.view.*


class MyAdapter(var context: Context, var cardClicklistener:(Dessert) -> Unit, private var dessertDataset: List<Dessert>): RecyclerView.Adapter<MyAdapter.DessertViewHolder>() {


    //TODO: LAGE EGEN KLASSE AV DETTE, HVOR DU HAR ALT AV TEXT OG BILDER LAGRET. Som smalltalk chatbubbleview
    //Gjort -> DessertView
    inner class DessertViewHolder(val view: DessertView) : RecyclerView.ViewHolder(view)


        // Create new views (invoked by the layout manager)
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DessertViewHolder {

            val view = DessertView(parent.context)

            view.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

            return DessertViewHolder(view)
        }

        // Replace the contents of a view (invoked by the layout manager)
        override fun onBindViewHolder(viewHolder: DessertViewHolder, position: Int) {

            viewHolder.view.setDessertMenu(dessertDataset[position])

            //cardClicklistener. håndterer hvilken kort da som blir trykket på, og du sender det tilbake til Home. for eksempel dessert
            //som blir trykket på. Utifra det intenter du til neste activity fra HomeFragment.

            viewHolder.view.name_textview.setOnClickListener {
                cardClicklistener(dessertDataset[position])
                HomeFragment.valgt_iskrem = dessertDataset[position].id
            }

            viewHolder.view.dessert_Image.setOnClickListener {
                cardClicklistener(dessertDataset[position])
                HomeFragment.valgt_iskrem = dessertDataset[position].id
            }

        }


        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount() = dessertDataset.size

        fun updateData(newData: List<Dessert>) {
            dessertDataset = newData
            notifyDataSetChanged()
        }


}