package com.example.myapplicationcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplicationcompose.learn.ShowView
import com.example.myapplicationcompose.learn.WellnessScreen
import com.example.myapplicationcompose.screen.ComposeUIListScreen
import com.example.myapplicationcompose.ui.screen.NavigationListScreen

@Composable
fun ComposeNavigation(navController : NavHostController,modifier: Modifier){
    NavHost(navController = navController, startDestination = MainApp.route){
        composable(MainApp.route){
            NavigationListScreen(navController, modifier = modifier)
        }
        composable(MainFragmentList.route){
            NavigationListScreen(navController, modifier = modifier)
        }
        composable(MainFragmentHome.route){
            ShowView()
        }
        composable(Wellness.route){
            WellnessScreen(modifier = modifier)
        }
        composable(ComposeUIList.route){
            ComposeUIListScreen(modifier = modifier)
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }