package com.example.onlinefurniture.db
import androidx.room.Database

@Database(
        entities = [(User::class)],
        version = 1
)
class UserDB