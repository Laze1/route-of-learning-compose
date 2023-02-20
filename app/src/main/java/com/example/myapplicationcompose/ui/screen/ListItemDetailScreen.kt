package com.example.myapplicationcompose.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplicationcompose.viewmodel.EditorViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ListItemDetailScreen(
    onPop: () -> Unit,
    viewModel: EditorViewModel = viewModel(),
    isCreate: Boolean = false
) {
    var content by rememberSaveable {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            TopBar(
                title = if (isCreate) "添加" else "详情",
                onBack = onPop,
            ){
                TextButton(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    onClick = { viewModel.save() }) {
                    Text(text = "保存")
                }
            }
        }
    ) {
        OutlinedTextField(
            value = content,
            onValueChange = { info -> content = info },
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
                .defaultMinSize(minHeight = 200.dp)
        )
    }
}