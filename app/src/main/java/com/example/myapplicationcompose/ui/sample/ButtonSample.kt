package com.example.myapplicationcompose.ui.sample

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ButtonSample() {
    ButtonSampleScreen()
}

@Composable
fun ButtonSampleScreen() {
    Column {

        Button(onClick = {
            Log.i("button", "点击事件")
        }) {
            Text(text = "Button")
        }

        Button(
            modifier = Modifier.clickable { Log.i("button", "点击事件2") },
            onClick = { Log.i("button", "点击事件1") }) {
            Text(text = "Button2")
        }//modifier的onclick 和 button自带的onclick 同时存在时，只执行button自带的


        Button(
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Blue,
                containerColor = Color.Green,
            ),
            onClick = {},
        ) {
            Text(text = "Button")
        }

        TextButton(onClick = {  }) {
            Text("TextButton")
        }

        OutlinedButton(onClick = {  }) {
            Text("OutlinedButton")
        }

        IconButton(onClick = {}) {
            Text("IconButton")
        }
    }
}