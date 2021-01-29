package com.example.onlinefurniture.dao

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface UserDAO {
    @Insert
    suspend fun (user: User)

}