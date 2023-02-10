package com.example.myapplicationcompose.ui.sample

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplicationcompose.R

@Preview
@Composable
fun IconSample() {
    IconSampleScreen()
}

@Composable
fun IconSampleScreen() {
    Column {
        Icon(imageVector = Icons.Default.Translate, contentDescription = null)
        Icon(painter = painterResource(id = R.drawable.back), contentDescription = null)
        Icon(bitmap = ImageBitmap(100,100), tint = Color.Green, contentDescription = null)

    }
}