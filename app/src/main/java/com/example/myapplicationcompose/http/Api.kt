package com.example.myapplicationcompose.http

import com.example.myapplicationcompose.base.PROJECT_NAME
import com.example.myapplicationcompose.base.USER_NAME
import com.example.myapplicationcompose.bean.GithubCommitBean
import com.example.myapplicationcompose.bean.GithubReposBean
import com.example.myapplicationcompose.bean.GithubUserInfoBean
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("users/{username}")
    suspend fun getInfo(
        @Path("username") name:String = USER_NAME
    ): GithubUserInfoBean

    @GET("users/{username}/repos")
    suspend fun getRepos(
        @Path("username") name:String = USER_NAME
    ): ArrayList<GithubReposBean>

    @GET("repos/{username}/{projectName}/commits")
    suspend fun getCommits(
        @Path("username") name:String = USER_NAME,
        @Path("projectName") projectName:String = PROJECT_NAME,
    ): ArrayList<GithubCommitBean>
}