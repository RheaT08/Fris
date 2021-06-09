package com.example.fris.database

import androidx.room.*


//mellomleddet, Appdatabasen til objektene. Forteller hva databasen kan gjøre.
@Dao
interface DessertDAO {

    @Delete
    fun deleteDessert(dessertToDelete: Dessert)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDessert(userToInsert: Dessert)

    @Query("SELECT * FROM dessert_table LIMIT 1")
    fun getDessert(): Dessert?

    @Query("SELECT * FROM dessert_table")
    fun getAllDesserts(): List<Dessert>

}