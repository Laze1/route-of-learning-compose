package com.example.myapplicationcompose.ui.screen

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.runtime.Composable

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ListItemDetailScreen(onPop: () -> Unit) {
    Scaffold(
        topBar = {
            TopBar(
                title = "详情",
                onBack = onPop
            )
        },
    ) {

    }
}