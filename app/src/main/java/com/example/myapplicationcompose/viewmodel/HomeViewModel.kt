package com.example.myapplicationcompose.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.myapplicationcompose.base.BaseViewModel
import com.example.myapplicationcompose.bean.GithubUserInfoBean
import com.example.myapplicationcompose.http.ApiRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel(application: Application) : BaseViewModel(application) {

    private var _info = MutableStateFlow(GithubUserInfoBean())
//    val info: StateFlow<GithubUserInfoBean> = _info
    val info: StateFlow<GithubUserInfoBean>
        get() = _info

    var showLoading by mutableStateOf(true)

    fun process(intent: HomeIntent) {
        when (intent) {
            HomeIntent.GetInfoIntent -> getInfo()
        }
    }

    private fun getInfo() {
        launch({
            showLoading = true
            val data = ApiRequest(apiGithub).getUser("Laze1")
            _info.value = data
        }, {
            showLoading = false
        },{
            showLoading = false
        })
    }
}

enum class HomeIntent{
    GetInfoIntent,
}

