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
//TODO: Implementasjon av Room DB og lagring av minst 1 Entitet  - Ved bestilling
//TODO: -> Lage iskrem objekter og velg en som entity. Sett opp adapter med strings på meny, bytt med objektene og tilhærende image. 

//TODO: Ikke hardkodet farger, tekster, og størrelser.
//TODO: Fingeravtrykk sensor (Biometri). Kamera. Webview.

//Tasks
//TODO: Sett opp Menu page
//TODO: Sett opp Bestillings flyt


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)
    }
}