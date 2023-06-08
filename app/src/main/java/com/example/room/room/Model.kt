package com.example.room.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Model(
    @PrimaryKey
    val uuid:Int=0,
    val isim:String,
    val soyisim:String
)