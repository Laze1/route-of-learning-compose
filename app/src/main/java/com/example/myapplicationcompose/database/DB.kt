package com.example.myapplicationcompose.database

import androidx.room.Room
import com.example.myapplicationcompose.MyApplication

object DB {
    private var instance: AppDatabase? = null

    @Synchronized
    fun getInstance(): AppDatabase {
        if (instance == null) {
            instance = Room.databaseBuilder(
                MyApplication.context,
                AppDatabase::class.java, "my-database"
            )
                .fallbackToDestructiveMigration()//数据库更新时删除数据重新创建
                .build()
        }
        return instance!!
    }
}

fun getTodoDao() = DB.getInstance().todoDao()