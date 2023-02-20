package com.example.myapplicationcompose.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicationcompose.model.Todo
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class ListViewModel(application: Application) : AndroidViewModel(application) {

    private var _list by mutableStateOf<List<Todo>>(listOf())
    val list : List<Todo>
        get() = _list

    var toastContent = MutableSharedFlow<String>()


    fun fetchList() {
        _list = listOf(
            Todo(1, "212", "212", false),
            Todo(2, "2121", "2122", false)
        )
    }

    fun done(todo: Todo, check: Boolean) {
        viewModelScope.launch {
            _list = list.map {
                var newTodo = it
                if (it.id == todo.id)
                    newTodo = it.copy(done = check)
                newTodo
            }

            if (check) {
                toastContent.emit(
                    "${
                        todo.content.substring(
                            0..minOf(
                                8,
                                todo.content.length - 1
                            )
                        )
                    }..完成"
                )
            }
        }
    }

}

