package com.example.room.di

import android.content.Context
import androidx.room.Room
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.room.R
import com.example.room.repo.ModelRepositoryIF
import com.example.room.repo.Repository
import com.example.room.retrofit.ModelAPIService
import com.example.room.room.ModelDao
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
    @Singleton
    @Provides
    fun injectNormalRepo(dao:ModelDao,api:ModelAPIService)=Repository(dao,api) as ModelRepositoryIF

    @Singleton
    @Provides
    fun injectGlide(@ApplicationContext context: Context)= Glide.with(context)
        .setDefaultRequestOptions(
            RequestOptions().placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
        )
    
}