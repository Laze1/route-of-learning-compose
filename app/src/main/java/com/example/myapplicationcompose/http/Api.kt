package com.example.myapplicationcompose.http

import com.example.myapplicationcompose.bean.GithubReposBean
import com.example.myapplicationcompose.bean.GithubUserInfoBean
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("users/{username}")
    suspend fun getInfo(
        @Path("username") name:String = "Laze1"
    ): GithubUserInfoBean

    @GET("users/{username}/repos")
    suspend fun getRepos(
        @Path("username") name:String = "Laze1"
    ): ArrayList<GithubReposBean>
}