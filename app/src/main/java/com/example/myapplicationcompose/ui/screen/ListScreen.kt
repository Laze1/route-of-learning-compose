package com.example.myapplicationcompose.ui.screen

import android.annotation.SuppressLint
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ListScreen(onNavToDetail: () -> Unit,onPop:() -> Unit) {
    Scaffold(
        topBar = { TopBar("列表", onBack = onPop) },
        floatingActionButton = {
            FloatingActionButton(onClick = onNavToDetail) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    ) {

    }
}