package com.example.fris.ui.utforsk

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.example.fris.R
import com.example.fris.database.Dessert
import kotlinx.android.synthetic.main.dessert_cardview.view.*

//Knyttet til myAdapter - setter viewsene
class DessertView(context: Context) : FrameLayout(context) {


        private val view: View = LayoutInflater.from(context).inflate(R.layout.dessert_cardview, this)

        fun setDessertMenu(icecream: Dessert) {

            view.name_textview.text = icecream.dessertName

            val pic = icecream.bilde

            view.dessert_Image.setImageResource(pic)
        }


    }
