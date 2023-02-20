package com.example.myapplicationcompose.ui.screen

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.platform.LocalContext
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

    val context = LocalContext.current

    LaunchedEffect(key1 = viewModel.toastContent) {
        Log.d("TAG", "ListScreen: ")
        viewModel.toastContent.collect {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }
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
                TodoItem(it, onNavToDetail) { isCheck ->
                    viewModel.done(it, isCheck)
                }
            }
        }
    }
}

@Composable
fun TodoItem(todo: Todo, click: () -> Unit, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp, 5.dp)
            .clickable { click() },
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column {
            Text(text = todo.content)
            Text(text = todo.date)
        }
        Checkbox(
            checked = todo.done, onCheckedChange = {
                onCheckedChange(it)
            })
    }
}