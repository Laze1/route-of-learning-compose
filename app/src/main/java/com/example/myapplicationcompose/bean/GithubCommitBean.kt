package com.example.myapplicationcompose.bean

data class GithubCommitBean(
    val commit: CommitBean,
)

data class CommitBean(
    val committer: Committer,
    val message: String,
)


data class Committer(
    val date: String,
    val email: String,
    val name: String
)
