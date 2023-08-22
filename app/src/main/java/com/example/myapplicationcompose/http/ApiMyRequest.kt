package com.example.myapplicationcompose.http

class ApiMyRequest(private val apiMy: ApiMy) {

    suspend fun hello() = apiMy.hello()

}