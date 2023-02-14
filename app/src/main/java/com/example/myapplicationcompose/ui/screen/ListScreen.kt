package com.example.myapplicationcompose.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Checkbox
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplicationcompose.model.Todo
import com.example.myapplicationcompose.viewmodel.ListViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ListScreen(
    onNavToDetail: () -> Unit, onPop: () -> Unit,
    viewModel: ListViewModel = viewModel()
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.fetchList()
    }

    Scaffold(
        topBar = { TopBar("列表", onBack = onPop) },
        floatingActionButton = {
            FloatingActionButton(onClick = onNavToDetail) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    ) {
        LazyColumn {
            items(viewModel.list) {
                TodoItem(it)
            }
        }
    }
}

@Composable
fun TodoItem(todo: Todo) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(15.dp,5.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = todo.content)
            Text(text = todo.date)
        }
        Checkbox(
            checked = todo.done, onCheckedChange = {})
    }
}