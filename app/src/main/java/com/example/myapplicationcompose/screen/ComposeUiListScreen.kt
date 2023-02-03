package com.example.myapplicationcompose.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ComposeUIListScreen(
//    navHostController: NavHostController,
    modifier: Modifier = Modifier
){
    val scrollState = rememberScrollState()
    var count by rememberSaveable { mutableStateOf(0) }
    Column(
        modifier = modifier
            .padding(15.dp)
            .verticalScroll(state = scrollState)
    ){
        Text(text = "这是一个Text控件", modifier = modifier)

        Button(
            onClick = { count++ },
        ) {
            Text(text = if (count == 0) "这是一个按钮" else "$count")
        }


    }
}