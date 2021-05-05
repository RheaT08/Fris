package com.example.fris

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter(private var dessertDataset: List<String>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {


        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

            val name: TextView = view.findViewById(R.id.name_textview)

            init {
                // Define click listener for the ViewHolder's View.
            }
        }

        // Create new views (invoked by the layout manager)
        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

            // Create a new view, which defines the UI of the list item
            val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.dessert_cardview, viewGroup, false) as View

            return ViewHolder(view)
        }

        // Replace the contents of a view (invoked by the layout manager)
        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

            viewHolder.name.text = dessertDataset[position]
        }

        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount() = dessertDataset.size

        fun updateData(newData: List<String>) {
            dessertDataset = newData
            notifyDataSetChanged()
        }



}