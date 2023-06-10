package com.example.room.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Model(
    var name : String,
    var artistName : String,
    var year : Int,
    var imageUrl : String,
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null
)