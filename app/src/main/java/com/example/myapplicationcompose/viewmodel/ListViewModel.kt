package com.example.myapplicationcompose.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.example.myapplicationcompose.model.Todo

class ListViewModel(application: Application) : AndroidViewModel(application) {

    var list by mutableStateOf<List<Todo>>(listOf())

    fun fetchList(){
        list = listOf(
            Todo(1,"212","212",false),
            Todo(2,"212","212",false)
        )
    }

}

