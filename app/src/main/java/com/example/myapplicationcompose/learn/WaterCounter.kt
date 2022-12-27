package com.example.myapplicationcompose.learn

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        var count by rememberSaveable { mutableStateOf(0) }
        StatelessCounter(
            count = count,
            onAddCount = { count++ }
        ) { count = 0 }
    }
}

@Composable
fun StatelessCounter(
    count: Int,
    onAddCount: () -> Unit,
    onClearCount: () -> Unit
){
    if (count > 0) {
        var showTask by rememberSaveable { mutableStateOf(true) }
        if (showTask) {
            WellnessTaskItem(
                taskName = "Have you taken your 15 minute walk today?",
                onClose = { showTask = false }
            )
        }
        Text(text = "You've had $count glasses.")
    }
    Row(Modifier.padding(8.dp)) {
        Button(
            onClick = { onAddCount() },
            enabled = count < 10
        ) {
            Text(text = "Add one")
        }
        //当count=0时，上方(count>0)内会重组，导致showTask记忆丢失,再次使用则为初始状态
        Button(
            onClick = { onClearCount() },
            Modifier.padding(start = 8.dp)
        ) {
            Text(text = "clear count")
        }
    }
}