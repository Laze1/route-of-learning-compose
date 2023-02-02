package com.example.myapplicationcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplicationcompose.MyApp
import com.example.myapplicationcompose.learn.WellnessScreen

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
    }
}