package com.example.myapplicationcompose.bean

data class BaseRequestBean<T>(
    val code: Int = 0,
    val data: T? = null,
    val msg: String = ""
)
