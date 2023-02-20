package com.example.myapplicationcompose.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.example.myapplicationcompose.model.Todo

class EditorViewModel(application: Application) : AndroidViewModel(application) {

    var todo by mutableStateOf(Todo(0,"","",false))

    fun save(){

    }
}