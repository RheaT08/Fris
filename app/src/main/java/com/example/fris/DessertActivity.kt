package com.example.fris

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.fris.database.Dessert
import com.example.fris.ui.utforsk.HomeFragment
import kotlinx.android.synthetic.main.activity_dessert.*

class DessertActivity : AppCompatActivity(){



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dessert)

        leggKjop_btn.setOnClickListener {
            val activityIntent = Intent(this, HandlekurvActivity::class.java)
            startActivity(activityIntent)
        }

        dessertDetails()

    }

    @SuppressLint("SetTextI18n")
    fun dessertDetails(){

        val dessert_objekt = HomeFragment.getDessert(HomeFragment.valgt_iskrem)
        dessert_pic.setImageResource(dessert_objekt.bilde)
        innhold_textview.text = "Innhold: " + dessert_objekt.innhold
        pris_textview.text = "Pris: " + dessert_objekt.pris

    }


}