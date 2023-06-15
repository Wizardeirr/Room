package com.example.room.repo

import androidx.lifecycle.LiveData
import com.example.room.retrofit.ImageResponse
import com.example.room.retrofit.ModelAPIService
import com.example.room.room.Model
import com.example.room.room.ModelDao
import com.example.room.util.Resource
import javax.inject.Inject

class Repository @Inject constructor(
    private val modeldao:ModelDao,
    private val retrofitAPI:ModelAPIService

    ):ModelRepositoryIF {
    override suspend fun insertModel(model: Model) {
        modeldao.insertModel(model)
    }

    override suspend fun deleteModel(model: Model) {
        modeldao.deleteUsers(model)
    }

    override fun getModel(): LiveData<List<Model>> {
        return modeldao.getArts()
    }

    override suspend fun searchImage(imageString: String): Resource<ImageResponse> {
        return try {
            val response=retrofitAPI.imageSearch(imageString)
            if (response.isSuccessful){
                response.body()?.let {
                    return@let Resource.success(it)
                }?:Resource.error("Error",null)
            }else{
                Resource.error("null",null)
            }


        }catch (e:Exception){

            Resource.error("Error",null)
        }
    }


}