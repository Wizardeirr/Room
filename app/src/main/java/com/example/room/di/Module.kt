package com.example.room.di

import android.content.Context
import androidx.room.Room
import com.example.room.retrofit.ModelAPIService
import com.example.room.room.ModelDataBase
import com.example.room.util.utility.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Singleton
    @Provides
    fun injectRoomDataBase(@ApplicationContext context: Context)= Room.databaseBuilder(context,ModelDataBase::class.java,
    "name").build()

    @Singleton
    @Provides
    fun injectDao(database:ModelDataBase)=database.dao()

    @Singleton
    @Provides
    fun injectRetrofitAPI():ModelAPIService{
        return Retrofit.Builder().
        addConverterFactory(GsonConverterFactory.create()).
                baseUrl(BASE_URL).build().create()
    }
    
}