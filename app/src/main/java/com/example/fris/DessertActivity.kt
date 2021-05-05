package com.example.fris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.activity_dessert.*

class DessertActivity : AppCompatActivity() {

    /*
     private val cardView: CardView = findViewById(R.id.card_view)
        cardView.setOnClickListener {
            val activityIntent = Intent(this, DessertActivity::class.java)
            startActivity(activityIntent) //viderefører brukeren
        }
     */


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dessert)

        leggKjop_btn.setOnClickListener {
            val activityIntent = Intent(this, HandlekurvActivity::class.java)
            startActivity(activityIntent)
        }

    }


}