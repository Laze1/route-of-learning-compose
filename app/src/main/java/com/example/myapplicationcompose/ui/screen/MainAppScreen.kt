package com.example.myapplicationcompose.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.myapplicationcompose.R
import com.example.myapplicationcompose.learn.ShowView
import com.example.myapplicationcompose.navigation.MainFragmentHome
import com.example.myapplicationcompose.navigation.MainFragmentList
import com.example.myapplicationcompose.navigation.bottomNavigationList
import com.example.myapplicationcompose.navigation.navigateSingleTopTo
import com.example.myapplicationcompose.ui.view.ButtonTransparent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainContent(
    navController: NavController
) {
    val nav = rememberNavController()
    Scaffold(
        topBar = { TopBar("首页") },
        bottomBar = { BottomBar { nav.navigateSingleTopTo(it) } },
        drawerContent = { DrawerContent() },
    ) { paddingValues ->
        NavHost(navController = nav, startDestination = MainFragmentList.route) {
            composable(MainFragmentList.route) {
                NavigationListScreen(navController, modifier = Modifier.padding(paddingValues))
            }
            composable(MainFragmentHome.route) {
                ShowView()
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
fun TopBar(
    title: String = "标题",
    navController: NavController? = null,
    showMore: Boolean = false,
    onMoreClick: () -> Unit = {}
) {
    TopAppBar(
        modifier = Modifier.padding(0.dp),
        backgroundColor = androidx.compose.material3.MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colors.onBackground,
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                fontSize = androidx.compose.material3.MaterialTheme.typography.titleMedium.fontSize,
                modifier = Modifier.align(Alignment.Center),
            )
            navController?.let {
                ButtonTransparent(
                    Modifier.align(Alignment.CenterStart),
                    { it.popBackStack() }
                ) {
                    Icon(painter = painterResource(id = R.drawable.back), contentDescription = null)
                }
            }
            if (showMore) {
                ButtonTransparent(
                    Modifier.align(Alignment.CenterEnd),
                    onMoreClick
                ) {
                    Icon(painter = painterResource(id = R.drawable.more), contentDescription = null)
                }
            }
        }
    }
}

@Composable
fun TopBar(
    title: String = "标题",
    showMore: Boolean = false,
    onMoreClick: () -> Unit = {},
    onBack:() -> Unit,
) {
    TopAppBar(
        modifier = Modifier.padding(0.dp),
        backgroundColor = androidx.compose.material3.MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colors.onBackground,
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                fontSize = androidx.compose.material3.MaterialTheme.typography.titleMedium.fontSize,
                modifier = Modifier.align(Alignment.Center),
            )
            ButtonTransparent(
                Modifier.align(Alignment.CenterStart),
                { onBack() }
            ) {
                Icon(painter = painterResource(id = R.drawable.back), contentDescription = null)
            }
            if (showMore) {
                ButtonTransparent(
                    Modifier.align(Alignment.CenterEnd),
                    onMoreClick
                ) {
                    Icon(painter = painterResource(id = R.drawable.more), contentDescription = null)
                }
            }
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
