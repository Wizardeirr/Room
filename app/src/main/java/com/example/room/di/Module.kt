package com.example.room.di

import android.content.Context
import androidx.room.Room
import com.example.room.room.ModelDao
import com.example.room.room.ModelDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn
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
    fun injectRetrofitAPI(){
        Retrofit.Builder().addCallAdapterFactory(GsonConverterFactory.create()).baseUrl()
    }

}