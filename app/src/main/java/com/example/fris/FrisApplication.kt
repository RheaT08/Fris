package com.example.fris


import android.app.Application

class FrisApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        application = this
    }

    companion object {
        lateinit var application: FrisApplication
    }
}