package com.example.myapplicationcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplicationcompose.MyApp
import com.example.myapplicationcompose.learn.WellnessScreen
import com.example.myapplicationcompose.screen.ComposeUIListScreen

@Composable
fun ComposeNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MainApp.route){
        composable(MainApp.route){
            MyApp(navController = navController)
        }
        composable(Wellness.route){
            WellnessScreen()
        }
        composable(ComposeUIList.route){
            ComposeUIListScreen()
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