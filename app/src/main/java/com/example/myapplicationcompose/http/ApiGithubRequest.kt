package com.example.myapplicationcompose.http

import com.example.myapplicationcompose.bean.GithubCommitBean
import com.example.myapplicationcompose.bean.GithubReposBean
import com.example.myapplicationcompose.bean.GithubUserInfoBean


class ApiGithubRequest(private val service: ApiGithub) {

    suspend fun getUser(username: String): GithubUserInfoBean {
        return service.getInfo(username)
    }

    suspend fun getRepos(username: String): ArrayList<GithubReposBean> {
        return service.getRepos(username)
    }

    suspend fun getCommits(username: String,pName:String): ArrayList<GithubCommitBean> {
        return service.getCommits(username,pName)
    }

}