package com.example.room.repo

import androidx.lifecycle.LiveData
import com.example.room.room.Model
import com.example.room.room.ModelDao
import javax.inject.Inject

class Repository@Inject constructor(private val input:ModelDao) {

    suspend fun insertUsers(model:Model){
        input.insertModel(model)
    }
    suspend fun deleteUsers(model: Model){
        input.deleteUsers(model)
    }
    fun getAllUsers():LiveData<List<Model>> =input.getArts()
}