package com.example.fris

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

//PRIMÆR TEKNISKE KRAV
//Minimum 3 fragments - DONE
//SplashActivity
//Implementasjon av Room DB og lagring av minst 1 Entitet  - Ved bestilling
//TODO: Implementering av notifikasjon og sending av dette.  -> NOTIFICATION
//Bruk minst 1 Hardware -> WEBVIEW . FACEBOOK logoen på profil vil åpne et webview til facebook siden.
//TODO: Ikke hardkodet farger, tekster, og størrelser.

//Tasks
//TODO: Sett opp Menu page -> Dessert page -> Bestill -> Bestillingsbekreftelse - KOBLE DETTE
//TODO: Sett opp Bestillings flyT
//TODO: Make cardviews clickable
//Lage iskrem objekter og velg en som entity. Sett opp adapter med strings på meny, bytt med objektene og tilhærende image.


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)
    }
}