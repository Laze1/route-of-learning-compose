package com.example.myapplicationcompose.ui.view

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource

@Composable
fun Image(id: Int) {
    Image(painter = painterResource(id = id), contentDescription = null)
}