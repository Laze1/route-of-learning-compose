package com.example.myapplicationcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplicationcompose.learn.ShowView
import com.example.myapplicationcompose.learn.WellnessScreen
import com.example.myapplicationcompose.ui.sample.ButtonSampleScreen
import com.example.myapplicationcompose.ui.sample.ModifierSample
import com.example.myapplicationcompose.ui.sample.TextUiListScreen
import com.example.myapplicationcompose.ui.screen.ComposeUIListScreen
import com.example.myapplicationcompose.ui.screen.NavigationListScreen

@Composable
fun ComposeNavigation(navController : NavHostController, modifier: Modifier, barShow:(Boolean) -> Unit){
    NavHost(navController = navController, startDestination = MainFragmentList.route){
//        composable(MainApp.route){ NavigationListScreen(navController, modifier = modifier) }
        composable(MainFragmentList.route){
            NavigationListScreen(navController, modifier = modifier)
            barShow(true)
        }
        composable(MainFragmentHome.route){
            ShowView()
            barShow(true)
        }
        composable(Wellness.route){
            WellnessScreen(modifier = modifier)
            barShow(false)
        }
        composable(ComposeUIList.route){
            ComposeUIListScreen(navController, modifier)
            barShow(false)
        }
        composable(TextUIList.route){
            TextUiListScreen(navController)
            barShow(false)
        }
        composable(ModifierSample.route){
            ModifierSample()
            barShow(false)
        }
        composable(ButtonSample.route){
            ButtonSampleScreen()
            barShow(false)
        }
    }
}

fun NavController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }