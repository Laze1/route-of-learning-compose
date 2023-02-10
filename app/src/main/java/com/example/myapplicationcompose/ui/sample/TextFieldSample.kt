package com.example.myapplicationcompose.ui.sample

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun TextFieldSample() {
    TextFieldSampleScreen()
}

@Composable
fun TextFieldSampleScreen() {
    Column(
        modifier = Modifier.verticalScroll(ScrollState(0))
    ) {
        var text by rememberSaveable { mutableStateOf("tree") }
        var text1 by rememberSaveable { mutableStateOf("tree") }
        var text2 by rememberSaveable { mutableStateOf("") }

        TextField(value = text, onValueChange = {
            text = it
        })

        OutlinedTextField(value = text1, onValueChange = { text1 = it })

        TextField(
            value = text2,
            label = {
                Text(text = "hello")
            },
            placeholder = {
                Text(text = "please input name!")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Call, contentDescription = null)
            },
            keyboardActions = KeyboardActions(onDone = {
                text1 = text+text2
            }),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.NumberPassword
            ),
            singleLine = true,
            onValueChange = {
                text2 = it
            })
    }
}