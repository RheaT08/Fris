package com.example.fris.ui.utforsk

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.fris.HandlekurvActivity
import com.example.fris.R
import kotlinx.android.synthetic.main.activity_dessert.*

class DessertActivity : AppCompatActivity(){

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dessert)

        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        leggKjop_btn.setOnClickListener {
            val activityIntent = Intent(this, HandlekurvActivity::class.java)
            startActivity(activityIntent)
        }

        dessertDetails()

    }

    @SuppressLint("SetTextI18n")
    fun dessertDetails(){

        //Ny: spør direkte databasen om iskrem med følgende id.
        //Gammelt: koden før eksamen, brukte mye av companion objekt, og itererte gjennom listemenyen etter lignende id.
        Thread{
           val icecream = homeViewModel.getIceCream(HomeFragment.valgt_iskrem)

            //val dessert_objekt = HomeFragment.getDessert(HomeFragment.valgt_iskrem)
            dessert_pic.setImageResource(icecream.bilde)
            innhold_textview.text = "Innhold: " + icecream.innhold
            pris_textview.text = "Pris: " + icecream.pris

        }.start()

    }


}