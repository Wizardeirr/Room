package com.example.room.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ModelDao {

    @Insert
    suspend fun insertUsers(vararg model:Model)
    @Delete
    suspend fun deleteUsers(model: Model)
    @Query("SELECT * FROM model")
    suspend fun getUsers():List<Model>

}