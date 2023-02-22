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
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplicationcompose.model.Todo
import com.example.myapplicationcompose.util.toTime
import com.example.myapplicationcompose.viewmodel.ListViewModel
import java.util.*

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ListScreen(
    onNavToDetail: () -> Unit, onPop: () -> Unit,
    viewModel: ListViewModel = viewModel()
) {
    OnLifecycleEvent { owner, event ->
        // do stuff on event
        when (event) {
            Lifecycle.Event.ON_RESUME -> { viewModel.fetchList() }
            else                      -> {  }
        }
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
            Text(text = todo.date.toTime())
        }
        Checkbox(
            checked = todo.done, onCheckedChange = {
                onCheckedChange(it)
            })
    }
}

@Composable
fun OnLifecycleEvent(onEvent: (owner: LifecycleOwner, event: Lifecycle.Event) -> Unit) {
    val eventHandler = rememberUpdatedState(onEvent)
    val lifecycleOwner = rememberUpdatedState(LocalLifecycleOwner.current)

    DisposableEffect(lifecycleOwner.value) {
        val lifecycle = lifecycleOwner.value.lifecycle
        val observer = LifecycleEventObserver { owner, event ->
            eventHandler.value(owner, event)
        }

        lifecycle.addObserver(observer)
        onDispose {
            lifecycle.removeObserver(observer)
        }
    }
}