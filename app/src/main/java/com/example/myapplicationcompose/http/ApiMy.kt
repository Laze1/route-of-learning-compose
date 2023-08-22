package com.example.myapplicationcompose.http

import retrofit2.http.GET

interface ApiMy {

    @GET("/hello")
    suspend fun hello(): String


}