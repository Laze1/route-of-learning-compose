package com.example.myapplicationcompose.learn

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun ShowView(){
    HelloScreen()
}

@Composable
fun HelloScreen() {
    var name by rememberSaveable { mutableStateOf("") }

    HelloContent(name = name, onNameChange = { name = it })
}

@Composable
fun HelloContent(name:String, onNameChange:(String)->Unit) {
    //三种方法等价，只是不同的语法糖
//    var name by remember { mutableStateOf("") }
//    val name = remember { mutableStateOf("") }
//    val (name, setName) = remember { mutableStateOf("") }
    Column(modifier = Modifier.padding(16.dp)) {
        if (name.isNotEmpty()) {
            Text(
                text = "Hello! $name",
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.h5
            )
        }
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text("Name") }
        )
    }
}

