package com.example.myapplicationcompose.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicationcompose.database.getTodoDao
import com.example.myapplicationcompose.model.Todo
import kotlinx.coroutines.launch
import java.util.*

class EditorViewModel(application: Application) : AndroidViewModel(application) {

    var todo by mutableStateOf(Todo(null,"",0,false))
    var id :Int? = null
    fun getInfo(id1:Int){
        viewModelScope.launch {
            val qTodo = getTodoDao().findById(id1)
            qTodo?.let {
                todo = qTodo
                id = id1
            }
        }
    }

    fun save(onSuccess:()->Unit){
        viewModelScope.launch {
            id?.let {
                getTodoDao().update(todo)
            }?: kotlin.run {
                todo.date = Date().time
                getTodoDao().insertAll(todo)
            }
            onSuccess()
        }
    }

    fun onValueChanged(it:String){
        todo= todo.copy(content = it)
    }
}