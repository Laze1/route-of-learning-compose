package com.example.myapplicationcompose.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplicationcompose.navigation.navList

@Composable
fun NavigationListScreen(
    navController: NavController,
    modifier: Modifier = Modifier
){
    LazyColumn(modifier = modifier.padding(15.dp)){
        items(
            items = navList,
        ){ route ->
            Button(
                onClick = { navController.navigate(route) }
            ) {
                Text(text = route)
            }
        }
    }
}