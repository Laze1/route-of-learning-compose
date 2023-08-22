package com.example.myapplicationcompose.base

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicationcompose.http.OkHttpRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

open class BaseViewModel(application: Application):AndroidViewModel(application) {

    val apiGithub by lazy {
        OkHttpRequest.getGithubApi()
    }

    val apiMy by lazy {
        OkHttpRequest.getMyApi()
    }

    fun launch(
        block: suspend () -> Unit,
        error: suspend (Throwable) -> Unit,
        complete: suspend () -> Unit = {}
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                block()
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("HttpErr", e.message?:"")
                error(e)
            } finally {
                complete()
            }
        }
    }
}