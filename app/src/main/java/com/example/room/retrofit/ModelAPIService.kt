package com.example.room.retrofit

import com.example.room.util.utility.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ModelAPIService {
    @GET("/api/")
    suspend fun imageSearch(
        @Query("q") searchQuery:String,
        @Query("key") apiKey : String = API_KEY
    ): Response<ImageResponse>
}