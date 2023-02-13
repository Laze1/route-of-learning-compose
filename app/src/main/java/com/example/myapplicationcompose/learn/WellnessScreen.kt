package com.example.myapplicationcompose.learn

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WellnessScreen(
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = Modifier) {
        WaterCounter()
        val list = wellnessViewModel.tasks
        WellnessTasksList(
            list = list,
            onCheckedTask = { task, checked ->
                wellnessViewModel.changeTaskChecked(task, checked)
            },
            onCloseTask = {task -> wellnessViewModel.remove(task)}
        )
    }
}