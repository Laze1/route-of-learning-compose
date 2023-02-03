package com.example.myapplicationcompose.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.example.myapplicationcompose.R

@Composable
fun ComposeUIListScreen(
//    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .padding(15.dp)
            .verticalScroll(state = scrollState)
    ) {
        Text(text = "这是一个Text控件", modifier = modifier)

        var count by rememberSaveable { mutableStateOf(0) }
        Button(
            onClick = { count++ },
        ) {
            Text(text = if (count == 0) "这是一个Button" else "$count")
        }

        Button(
            modifier = modifier.fillMaxWidth(),
            onClick = { },
        ) {
            Text(text = "很长的Button")
        }

        Image(
            bitmap = ImageBitmap.imageResource(id = R.mipmap.r),
            contentDescription = null,
            modifier = modifier
                .padding(10.dp)
                .clip(RoundedCornerShape(5.dp))
        )

        var inputValue by rememberSaveable { mutableStateOf("") }

        TextField(
            value = inputValue,
            onValueChange = { inputValue = it },
            modifier = Modifier.background(color = Color.White)//无用？
        )

        var inputOutlineValue by rememberSaveable { mutableStateOf("") }

        OutlinedTextField(
            value = inputOutlineValue,
            onValueChange = { inputOutlineValue = it },
            modifier = modifier.padding(top = 10.dp)
        )


    }
}