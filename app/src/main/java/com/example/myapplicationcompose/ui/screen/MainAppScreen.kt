package com.example.myapplicationcompose.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.myapplicationcompose.navigation.ComposeNavigation
import com.example.myapplicationcompose.navigation.MainFragmentList
import com.example.myapplicationcompose.navigation.bottomNavigationList
import com.example.myapplicationcompose.navigation.navigateSingleTopTo
import com.example.myapplicationcompose.ui.theme.MyApplicationComposeTheme

@Preview
@Composable
fun MainContent() {
    val navController = rememberNavController()
    MyApplicationComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Scaffold(
                modifier = Modifier.background(color = Color.Black),
                bottomBar = {
                    BottomNavigation {
                        bottomNavigationList.forEach {
                            BottomNavigationItem(
                                selected = it.route == MainFragmentList.route,
                                icon = { it.icon },
                                label = { Text(text = it.label) },
                                onClick = { navController.navigateSingleTopTo(it.route) })
                        }
                    }
                }) {
                ComposeNavigation(navController,modifier = Modifier.padding(it))
            }
        }
    }
}