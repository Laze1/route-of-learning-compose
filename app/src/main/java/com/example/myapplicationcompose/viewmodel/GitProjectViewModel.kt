package com.example.myapplicationcompose.viewmodel

import android.app.Application
import com.example.myapplicationcompose.base.BaseViewModel
import com.example.myapplicationcompose.base.USER_NAME
import com.example.myapplicationcompose.bean.GithubCommitBean
import com.example.myapplicationcompose.http.ApiGithubRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GitProjectViewModel(application: Application) : BaseViewModel(application) {

    private var _commit = MutableStateFlow(ArrayList<GithubCommitBean>())
    val commit: StateFlow<ArrayList<GithubCommitBean>>
        get() = _commit

    fun getCommits(pName:String){
        launch({
            val data = ApiGithubRequest(apiGithub).getCommits(USER_NAME, pName)
            _commit.value = data
        }, {

        },{

        })
    }
}