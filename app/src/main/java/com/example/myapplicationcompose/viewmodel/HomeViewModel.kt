package com.example.myapplicationcompose.viewmodel

import android.app.Application
import com.example.myapplicationcompose.base.BaseViewModel
import com.example.myapplicationcompose.bean.GithubUserInfoBean
import com.example.myapplicationcompose.http.ApiRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel(application: Application) : BaseViewModel(application) {

    private var _info = MutableStateFlow(GithubUserInfoBean())
    val info: StateFlow<GithubUserInfoBean> = _info

    fun getInfo() {
        launch({
            val data = ApiRequest(apiGithub).getUser("Laze1")
            _info.value = data
        }, {

        })
    }
}

