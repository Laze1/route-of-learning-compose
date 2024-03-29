package com.example.myapplicationcompose.ui.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplicationcompose.navigation.MainApp
import com.example.myapplicationcompose.navigation.navList
import com.example.myapplicationcompose.navigation.navigateSingleTopTo

@Composable
fun NavigationListScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier.padding(15.dp).fillMaxWidth()) {
        items(
            items = navList,
        ) { route ->
            //去掉主页
            if (route != MainApp.route) {
                Button(
                    onClick = { navController.navigateSingleTopTo(route) }
                ) {
                    Text(text = route)
                }
            }
        }
    }
}