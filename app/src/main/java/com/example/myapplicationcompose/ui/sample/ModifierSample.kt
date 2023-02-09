package com.example.myapplicationcompose.ui.sample

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@Preview
@Composable
fun ModifierSample() {
    var text by rememberSaveable { mutableStateOf("这是一个很长很长的文本，用来展示Modifier的各种属性") }
    Text(
        text = text,
        modifier = Modifier
            .clickable {
                Log.i("click", "点击到我了范围-1")
                text = "点击到我了范围-1"
            }
            .background(Color.Gray)
            .padding(25.dp)
            .background(Color.Blue)
            .padding(20.dp)
            .background(Color.Red)
            .padding(15.dp)
            .clickable {
                Log.i("click", "点击到我了范围-2")
                text = "这是一个很长很长的文本，用来展示Modifier的各种属性"
            }
    )//顺序很重要
}