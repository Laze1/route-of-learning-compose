package com.example.myapplicationcompose.ui.screen

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.myapplicationcompose.R

@Composable
fun ComposeUIListScreen(
    navController: NavController
) {
    val scrollState = rememberScrollState()
    Column {
        TopBar("列表",navController)

        Column(
            modifier = Modifier
                .padding(15.dp, 0.dp, 15.dp, 0.dp)
                .verticalScroll(state = scrollState)
        ) {

            Text(text = "这是一个Text控件", modifier = Modifier.padding(10.dp))

            var count by rememberSaveable { mutableStateOf(0) }
            Button(
                onClick = { count++ },
            ) {
                Text(text = if (count == 0) "这是一个Button" else "$count")
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { },
            ) {
                Text(text = "很长的Button")
            }

            Image(
                bitmap = ImageBitmap.imageResource(id = R.mipmap.r),
                contentDescription = null,
                modifier = Modifier
                    .padding(10.dp)
                    .clip(RoundedCornerShape(5.dp))
            )

            Image(painter = painterResource(id = R.mipmap.xiao), contentDescription = "魈")

            AsyncImage(
                model = "https://developer.android.google.cn/static/images/home/android-logo-13-twotone-1_720.png?hl=zh-cn",
                contentDescription = null
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
                modifier = Modifier.padding(top = 10.dp),
                label = {
                    Text(text = "Input")
                }
            )


        }
    }
}