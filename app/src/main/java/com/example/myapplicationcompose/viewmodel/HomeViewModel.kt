package com.example.myapplicationcompose.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicationcompose.http.OkHttpRequest
import kotlinx.coroutines.launch

class HomeViewModel(application: Application):AndroidViewModel(application) {

    fun getMyInfo(){
        viewModelScope.launch {
            OkHttpRequest.getGithubApi().getInfo()
        }
    }
}