package com.example.fris.ui.utforsk

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fris.FrisApplication
import com.example.fris.R
import com.example.fris.database.AppDatabase
import com.example.fris.database.Dessert

class HomeViewModel : ViewModel() {


    private val dessertDAO =
        AppDatabase.getDatabase(FrisApplication.application.applicationContext).dessertDao()


    //Lagrer dessertene som er i menyen lokalt i databasen
    fun saveToMenu(dessert : Dessert){
        Thread {
                dessertDAO.insertDessert(dessert)
        }.start()
    }


    fun getMenu(): List<Dessert> {
        return AppDatabase.getDatabase(FrisApplication.application.applicationContext).dessertDao().getAllDesserts()
    }

    fun getIceCream(icecreamId: String) : Dessert{

        return AppDatabase.getDatabase(FrisApplication.application.applicationContext).dessertDao().chosenDessert(icecreamId)

    }


    //Manuelt lager Dessert-objektene. Dette hadde vært API-metoden dersom det var et API å bruke.
    fun menu(): MutableList<Dessert> {

        //Oppretter dessert-objektene manuelt her
        val des1 = Dessert(
            "1",
            "Sjokolade Rolled ice-cream",
            "@strings/icecream_description",
            "Kokos, Kakao", "69 kr", R.drawable.image_10

        )

        val des2 = Dessert(
            "2",
            "Vanilje Rolled ice-cream",
            "@strings/icecream_description",
            "Kokos, Vanilje", "69 kr", R.drawable.image_8
        )

        val des3 = Dessert(
            "3",
            "Skogsbær Rolled ice-cream",
            "@strings/icecream_description",
            "Kokos, blåbær, bringebær, bjørnebøær", "69 kr",
            R.drawable.image_7
        )

        val des4 = Dessert(
            "4",
            "Jordbær Rolled ice-cream",
            "@strings/icecream_description",
            "Kokos, jordbær", "69 kr",
            R.drawable.image_9
        )

        return mutableListOf(des1, des2, des3, des4)
    }


}

