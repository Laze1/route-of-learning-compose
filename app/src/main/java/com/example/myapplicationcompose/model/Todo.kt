package com.example.myapplicationcompose.model

data class Todo(
    val id:Int,
    val content:String,
    val date:String,
    var done:Boolean,
)