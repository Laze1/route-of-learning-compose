package com.example.myapplicationcompose.http

import com.example.myapplicationcompose.bean.GithubUserInfoBean


class ApiRequest(private val service: Api) {


    suspend fun getUser(username: String): GithubUserInfoBean {
        return service.getInfo(username)
    }

}