package com.example.room.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Model::class], version = 1)
abstract class ModelDataBase:RoomDatabase() {
    abstract fun dao():ModelDao

}