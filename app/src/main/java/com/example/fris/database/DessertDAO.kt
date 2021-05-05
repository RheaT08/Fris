package com.example.fris.database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


//mellomleddet, Appdatabasen til objektene. Forteller hva databasen kan gjøre.
interface DessertDAO {

    @Delete
    fun deleteDessert(dessertToDelete: Dessert)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDessert(userToInsert: Dessert)

    @Query("SELECT * FROM dessert_table LIMIT 1")
    fun getDessert(): Dessert?

}