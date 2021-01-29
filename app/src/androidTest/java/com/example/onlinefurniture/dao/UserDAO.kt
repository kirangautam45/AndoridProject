package com.example.onlinefurniture.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

@Dao
interface UserDAO {
    @Insert
    suspend fun registerUser(user: User)
    @Update
    suspend fun UpdateUser(user: User)
    @Delete
    suspend fun  DeleteUser(user: User)
}

annotation class update

class User(fname: String, lname: String, username: String, password: String) {

}

annotation class Dao
