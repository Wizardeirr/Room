package com.example.room.repo

import androidx.lifecycle.LiveData
import com.example.room.retrofit.ImageResponse
import com.example.room.room.Model
import com.example.room.util.Resource

interface ModelRepositoryIF {
    suspend fun insertModel(model: Model)

    suspend fun deleteModel(model: Model)

    fun getModel() : LiveData<List<Model>>

    suspend fun searchImage(imageString : String) : Resource<ImageResponse>
}