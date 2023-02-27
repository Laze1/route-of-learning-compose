package com.example.myapplicationcompose.learn

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Star
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
    val repos by viewModel.repos.collectAsState()

    LaunchedEffect(key1 = viewModel, block = {
        viewModel.process(HomeIntent.GET_INFO)
        viewModel.process(HomeIntent.GET_REPOS)
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

        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 10.dp)
        ) {
            Icon(imageVector = Icons.Default.Group, contentDescription = null, modifier = Modifier.align(Alignment.CenterVertically))
            Text(text = "${info.followers} Followers", modifier = Modifier
                .padding(end = 10.dp, start = 5.dp)
                .align(Alignment.CenterVertically))
            Icon(imageVector = Icons.Default.Star, contentDescription = null,modifier = Modifier
                .padding(start = 10.dp, end = 5.dp)
                .align(Alignment.CenterVertically))
            Text(text = "${info.publicRepos} Repos", modifier = Modifier.align(Alignment.CenterVertically))
        }
        
        Divider(thickness = 1.dp, modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp))

        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(repos){
                Text(text = it.name)
            }
        }

    }

    if (viewModel.showLoading){
        Box(modifier = Modifier.fillMaxSize()){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}


