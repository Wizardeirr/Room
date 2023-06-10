package com.example.room.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ModelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertModel(model:Model)
    @Delete
    suspend fun deleteUsers(model: Model)
    @Query("SELECT * FROM model")
    fun getArts():LiveData<List<Model>>

}