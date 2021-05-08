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
//TODO: Bruk minst 1 Hardware -> WEBVIEW . FACEBOOK logoen på profil vil åpne et webview til facebook siden.



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