package com.example.room.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Model::class), version = 1)
abstract class ModelDataBase:RoomDatabase() {

    abstract fun dao():ModelDao

    companion object{
        @Volatile private var instance:ModelDataBase?=null
        private val LOCK=Any()

        operator fun invoke(context: Context)=instance?: synchronized(LOCK){
            instance?: makeDataBase(context).also {
                return it
            }
        }



        private fun makeDataBase(context:Context){
            Room.databaseBuilder(context.applicationContext,ModelDataBase::class.java,"name").build()
        }
    }
}