package com.example.fris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavDeepLinkBuilder
import kotlinx.android.synthetic.main.activity_bestilling.*


class BestillingActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bestilling)

        //Velger vipps. Tar deg med til siste side av flyten. Kjop bekreftet tilbake til startsiden.
        vipps_btn.setOnClickListener{
             loadFragment()


            /*
            val pendingIntent = NavDeepLinkBuilder(this.applicationContext)
                .setGraph(R.navigation.mobile_navigation)
                .setDestination(R.id.navigation_bekreftKjop_Fragment)
                .createPendingIntent()

            pendingIntent.send() */

        }

    }

    private fun loadFragment(){

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.navigation_bekreftKjop_Fragment, BekreftetKjop_Fragment())
        transaction.disallowAddToBackStack()
        transaction.commit()
    }

}