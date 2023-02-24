package com.example.myapplicationcompose.learn

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.myapplicationcompose.viewmodel.HomeViewModel


@Preview(showBackground = true)
@Composable
fun ShowView(){
    HelloScreen()
}

@Composable
fun HelloScreen(
    viewModel:HomeViewModel = viewModel()
) {
    var name by rememberSaveable { mutableStateOf("") }
    var avatarUrl by rememberSaveable { mutableStateOf("") }

    LaunchedEffect(key1 = viewModel){
        viewModel.info.collect{
            name = it.login
            avatarUrl = it.avatarUrl
        }
    }
    viewModel.getInfo()

    Column(modifier = Modifier.padding(15.dp).fillMaxWidth()) {
        AsyncImage(model = avatarUrl,
            contentDescription = "",
            modifier = Modifier.padding(15.dp)
                .size(100.dp)
                .align(Alignment.CenterHorizontally)
                .clip(CircleShape)
        )
        Text(text = name, modifier = Modifier.padding(top = 10.dp).align(Alignment.CenterHorizontally))
    }
}


