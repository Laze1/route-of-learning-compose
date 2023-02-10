package com.example.myapplicationcompose.ui.sample

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun SwitchSample() {
    SwitchSampleScreen()
}

@Composable
fun SwitchSampleScreen() {
    Column(
        modifier = Modifier.verticalScroll(ScrollState(0))
    ) {
        var check by rememberSaveable { mutableStateOf(true) }

        Switch(checked = check, onCheckedChange = { check = !check })
    }
}