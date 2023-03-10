package com.example.myapplicationcompose.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicationcompose.database.getTodoDao
import com.example.myapplicationcompose.model.Todo
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class ListViewModel(application: Application) : AndroidViewModel(application) {

    private var _list by mutableStateOf<List<Todo>>(listOf())
    val list: List<Todo>
        get() = _list

    val toastContent = MutableSharedFlow<String>()

    fun fetchList() {
        viewModelScope.launch {
            _list = getTodoDao().getAll()
        }
    }

    fun done(todo: Todo, check: Boolean) {
        viewModelScope.launch {
            _list = list.map {
                var newTodo = it
                if (it.id == todo.id) {
                    newTodo = it.copy(done = check)
                    getTodoDao().update(newTodo)
                }
                newTodo
            }.sortedByDescending { it.date }.sortedBy { it.done }

            if (check) {
                toastContent.emit(
                    "${
                        todo.content.substring(0..minOf(8, todo.content.length - 1))
                    }..完成"
                )
            }
        }
    }

}