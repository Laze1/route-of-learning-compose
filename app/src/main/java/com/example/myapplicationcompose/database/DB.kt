package com.example.myapplicationcompose.database

import androidx.room.Room
import com.example.myapplicationcompose.MyApplication

object DB {
    private var instance :AppDatabase? = null

    @Synchronized
    fun getInstance(): AppDatabase {
        if (instance == null){
            instance = Room.databaseBuilder(
                MyApplication.context,
                AppDatabase::class.java, "my-database"
            ).build()
        }
        return instance!!
    }
}