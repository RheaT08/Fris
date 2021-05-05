package com.example.fris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_handlekurv.*

class HandlekurvActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handlekurv)

        betal_btn.setOnClickListener {
            val activityIntent = Intent(this, BestillingActivity::class.java)
            startActivity(activityIntent)
        }

    }

}