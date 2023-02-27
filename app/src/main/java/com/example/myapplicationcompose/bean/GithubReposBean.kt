package com.example.myapplicationcompose.bean

import com.google.gson.annotations.SerializedName

data class GithubReposBean(
     val name: String = "",
     @SerializedName("html_url")
     val htmlUrl:String = ""
)