package com.example.myapplicationcompose.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicationcompose.database.DB
import com.example.myapplicationcompose.model.Todo
import kotlinx.coroutines.launch

class EditorViewModel(application: Application) : AndroidViewModel(application) {

    var todo by mutableStateOf(Todo(null,"","",false))

    fun save(){
        viewModelScope.launch {
            todo.content
            DB.getInstance().todoDao().insertAll(todo)
        }
    }

    fun onValueChanged(it:String){
        todo.content = it
    }
}