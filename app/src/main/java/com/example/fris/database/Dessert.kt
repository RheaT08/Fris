package com.example.fris.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dessert_table")
data class Dessert(
        @PrimaryKey val id : String,
        val dessertName: String,
        val description: String,
        val innhold: String,
        val pris: String,
        val bilde: String
)
