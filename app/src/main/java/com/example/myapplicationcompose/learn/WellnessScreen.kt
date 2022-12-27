package com.example.myapplicationcompose.learn

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        WaterCounter()
        val list = remember {
            getWellnessTasks().toMutableStateList()
        }
        WellnessTasksList(list = list, onCloseTask = {task -> list.remove(task)})
    }
}