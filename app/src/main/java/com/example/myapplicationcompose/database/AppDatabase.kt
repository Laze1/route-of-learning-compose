package com.example.myapplicationcompose.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplicationcompose.model.Todo
import com.example.myapplicationcompose.model.TodoDao

@Database(entities = [Todo::class], version = 3)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}
