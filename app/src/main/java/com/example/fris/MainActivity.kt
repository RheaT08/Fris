package com.example.fris

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView


//PRIMÆR TEKNISKE KRAV
//Minimum 3 fragments - DONE
//SplashActivity
//Implementasjon av Room DB og lagring av minst 1 Entitet  - Ved bestilling
//TODO: Implementering av notifikasjon og sending av dette.  -> NOTIFICATION
//TODO: Bruk minst 1 Hardware -> WEBVIEW . FACEBOOK logoen på profil vil åpne et webview til facebook siden.
//Ikke hardkodet farger, tekster, og størrelser.

//Tasks
// Sett opp Menu page -> Dessert page -> Bestill -> Bestillingsbekreftelse - KOBLE DETTE
//TODO: Sett opp Bestillings flyt
//TODO: Få tilbake dessert-objekt fra myadapter, og sende dens id til Dessertactivity.
//Make cardviews clickable or text and image
//Lage iskrem objekter og velg en som entity. Sett opp adapter med strings på meny, bytt med objektene og tilhærende image.


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)

        // Define ActionBar object. Fargen på Actionbar endres her.
        val actionBar: ActionBar? = supportActionBar
        val colorDrawable = ColorDrawable(Color.parseColor("#97D1D9"))
        // Set BackgroundDrawable
        actionBar?.setBackgroundDrawable(colorDrawable)

    }
}