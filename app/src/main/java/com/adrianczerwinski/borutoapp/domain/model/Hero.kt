package com.adrianczerwinski.borutoapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adrianczerwinski.borutoapp.util.Constants.HERO_DB_TABLE

@Entity(tableName = HERO_DB_TABLE)
data class Hero(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val image: String,
    val about: String,
    val rating: Double,
    val power: Int,
    val month: String,
    val day: String,
    val family: List<String>,
    val abilities: List<String>,
    val natureTypes: List<String>
)
