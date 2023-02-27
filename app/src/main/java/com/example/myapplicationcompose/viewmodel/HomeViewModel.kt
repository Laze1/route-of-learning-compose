package com.example.myapplicationcompose.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.myapplicationcompose.base.BaseViewModel
import com.example.myapplicationcompose.base.USER_NAME
import com.example.myapplicationcompose.bean.GithubReposBean
import com.example.myapplicationcompose.bean.GithubUserInfoBean
import com.example.myapplicationcompose.http.ApiRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel(application: Application) : BaseViewModel(application) {

    private var _info = MutableStateFlow(GithubUserInfoBean())
    val info: StateFlow<GithubUserInfoBean>
        get() = _info

    private var _repos = MutableStateFlow(ArrayList<GithubReposBean>())
    val repos: StateFlow<ArrayList<GithubReposBean>>
        get() = _repos



    var showLoading by mutableStateOf(true)

    fun process(intent: HomeIntent) {
        when (intent) {
            HomeIntent.GET_INFO -> getInfo()
            HomeIntent.GET_REPOS -> getRepos()
        }
    }

    private fun getRepos(){
        launch({
            showLoading = true
            val data = ApiRequest(apiGithub).getRepos(USER_NAME)
            _repos.value = data
        }, {
            showLoading = false
        },{
            showLoading = false
        })
    }

    private fun getInfo() {
        launch({
            showLoading = true
            val data = ApiRequest(apiGithub).getUser(USER_NAME)
            _info.value = data
        }, {
            showLoading = false
        },{
            showLoading = false
        })
    }
}

enum class HomeIntent{
    GET_INFO,GET_REPOS
}

