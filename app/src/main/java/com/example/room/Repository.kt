package com.example.room

import androidx.lifecycle.LiveData
import com.example.room.room.Model
import com.example.room.room.ModelDao

class Repository(private val input:ModelDao) {

    suspend fun insertUsers(model:Model){
        input.insertUsers(model)
    }
    suspend fun deleteUsers(model: Model){
        input.deleteUsers(model)
    }
    suspend fun getAllUsers():List<Model> =input.getUsers()


}