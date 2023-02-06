package com.example.myapplicationcompose.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.myapplicationcompose.navigation.ComposeNavigation
import com.example.myapplicationcompose.navigation.MainFragmentList
import com.example.myapplicationcompose.navigation.bottomNavigationList
import com.example.myapplicationcompose.navigation.navigateSingleTopTo
import com.example.myapplicationcompose.ui.theme.MyApplicationComposeTheme
import com.example.myapplicationcompose.viewmodel.MainViewModel

@Preview
@Composable
fun MainContent(
    mViewModel: MainViewModel = viewModel()
) {
    val navController = rememberNavController()

    var barShow by rememberSaveable { mutableStateOf(true) }

    MyApplicationComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Scaffold(
                modifier = Modifier.background(color = Color.Black),
                topBar = {},
                bottomBar = {
                    if (barShow) {
                        BottomBar { navController.navigateSingleTopTo(it) }
                    }
                },
                drawerContent = {},
            ) { paddingValues ->
                ComposeNavigation(navController, modifier = Modifier.padding(paddingValues)){
                    barShow = it
                }
            }
        }
    }
}

@Composable
fun BottomBar(onclick: (String) -> Unit) {
    BottomNavigation {
        bottomNavigationList.forEach {
            BottomNavigationItem(
                selected = it.route == MainFragmentList.route,
                icon = { it.icon },
                label = { Text(text = it.label) },
                onClick = { onclick(it.route) })
        }
    }
}