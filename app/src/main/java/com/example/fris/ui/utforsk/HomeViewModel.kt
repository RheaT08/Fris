package com.example.fris.ui.utforsk

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.fris.FrisApplication
import com.example.fris.database.AppDatabase
import com.example.fris.database.Dessert

class HomeViewModel : ViewModel() {

    //Save menu here

    private val dessertDAO =
        AppDatabase.getDatabase(FrisApplication.application.applicationContext).dessertDao()

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

/*
    //Lagrer dessertene som er i menyen lokalt i databasen
    fun saveToMenu(dessert : Dessert){
        dessertDAO.insertDessert(dessert)
    }


    fun getMenu(recyclerView: RecyclerView){

        Thread {
            val theMenu = AppDatabase.getDatabase(FrisApplication.application.applicationContext).dessertDao().getAllDesserts()
        }.start()

    }  */

}

