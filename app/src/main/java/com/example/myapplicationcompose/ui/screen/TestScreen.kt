package com.example.myapplicationcompose.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TestScreen() {
    showThem()
}

var stringValues0 = arrayOf("1", "2")
var oneValue0 = "1"

@Preview
@Composable
fun showThem() {

    var stringValue by remember { mutableStateOf(stringValues0) }
    var oneValue by remember { mutableStateOf(oneValue0) }

    Column {
        Text(text = oneValue)
        Row {
            for (k in stringValue.indices) {
                Text(text = stringValue[k])
            }
        }
        Button(onClick = {
            stringValue[0] = "3"
            stringValue = stringValues0.copyOf()
        }) {

        }
        Button(onClick = { stringValue[0] = "333" }) {

        }
    }

}
