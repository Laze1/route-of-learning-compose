package com.example.myapplicationcompose.bean

import com.google.gson.annotations.SerializedName

 class GithubUserInfoBean(
     @SerializedName("avatar_url")
     val avatarUrl: String = "",
     val login: String = "",
)