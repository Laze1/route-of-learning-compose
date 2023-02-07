package com.example.myapplicationcompose.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
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
                topBar = {
                    if (barShow) {
                        TopBar()
                    }
                },
                bottomBar = {
                    if (barShow) {
                        BottomBar { navController.navigateSingleTopTo(it) }
                    }
                },
                drawerContent = if (barShow) {
                    { DrawerContent() }
                } else null,
            ) { paddingValues ->
                ComposeNavigation(navController, modifier = Modifier.padding(paddingValues)) {
                    barShow = it
                }
            }
        }
    }
}

@Composable
private fun DrawerContent() {
    AsyncImage(
        model = "https://img1.baidu.com/it/u=3353028008,1916857228&fm=253&fmt=auto&app=138&f=JPG?w=800&h=500",
        contentDescription = null
    )
    Text(text = "这是一个侧边栏", modifier = Modifier.padding(15.dp))
}

@Composable
private fun TopBar() {
    TopAppBar(
        modifier = Modifier.padding(0.dp),
        backgroundColor = androidx.compose.material3.MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colors.onBackground,
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Text(
                text = "首页",
                fontSize = androidx.compose.material3.MaterialTheme.typography.titleMedium.fontSize
            )
        }
    }
}

@Composable
fun BottomBar(onclick: (String) -> Unit) {
    BottomNavigation(
        backgroundColor = androidx.compose.material3.MaterialTheme.colorScheme.primaryContainer
    ) {
        bottomNavigationList.forEach {
            BottomNavigationItem(
                selected = it.route == MainFragmentList.route,
                icon = {
                    Icon(
                        imageVector = it.icon ?: Icons.Filled.Done,
                        contentDescription = it.label
                    )
                },
                label = { Text(text = it.label) },
                onClick = { onclick(it.route) })
        }
    }
}
