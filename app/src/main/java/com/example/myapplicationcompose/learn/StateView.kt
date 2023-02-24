package com.example.myapplicationcompose.learn

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.myapplicationcompose.viewmodel.HomeIntent
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
    val info by viewModel.info.collectAsState()
//
//    var name by rememberSaveable { mutableStateOf("") }
//    var avatarUrl by rememberSaveable { mutableStateOf("") }
//
//    LaunchedEffect(key1 = viewModel){
//        viewModel.info.collect{
//            name = it.login
//            avatarUrl = it.avatarUrl
//        }
//    }
    LaunchedEffect(key1 = viewModel, block = {
        viewModel.process(HomeIntent.GetInfoIntent)
    })


    Column(modifier = Modifier
        .padding(15.dp)
        .fillMaxWidth()) {
        AsyncImage(model = info.avatarUrl,
            contentDescription = "",
            modifier = Modifier
                .padding(15.dp)
                .size(100.dp)
                .align(Alignment.CenterHorizontally)
                .clip(CircleShape)
        )
        Text(text = info.login, modifier = Modifier
            .padding(top = 10.dp)
            .align(Alignment.CenterHorizontally))
    }

    if (viewModel.showLoading){
        Box(modifier = Modifier.fillMaxSize()){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}


