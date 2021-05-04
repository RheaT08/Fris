package com.example.fris

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager

@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Setter selve splashscreenen i fullskjerm, uten noe titlebar oppe.
        //TODO: Fikse deprecation problemet senere.
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,    // This is used to hide the status bar and make
            WindowManager.LayoutParams.FLAG_FULLSCREEN     // the splash screen as a full screen activity.
        )

        Handler(Looper.getMainLooper()).postDelayed({

            //Intent - tar brukeren med til neste aktivitet/fragment utifra om de er logget inn eller ikke.
            //overfør brukeren videre fra LoginActivity til chatfragment(MainActivity)
            //sjekker om id-en allerede er i sharedPref. Ved log out, skal den være slettet.
            val activityIntent = Intent(this, MainActivity::class.java)


            startActivity(activityIntent) //viderefører brukeren
            finish()

        }, 2000)   //2 seconds on splashscreen

    }//onCreate
}//END



