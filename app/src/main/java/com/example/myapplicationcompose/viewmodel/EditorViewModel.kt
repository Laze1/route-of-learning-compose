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
import java.util.*

class EditorViewModel(application: Application) : AndroidViewModel(application) {

    var todo by mutableStateOf(Todo(null,"",0,false))

    fun save(onSuccess:()->Unit){
        viewModelScope.launch {
            todo.date = Date().time
            DB.getInstance().todoDao().insertAll(todo)
            onSuccess()
        }
    }

    fun onValueChanged(it:String){
        todo= todo.copy(content = it)
    }
}