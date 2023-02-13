package com.example.myapplicationcompose.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.myapplicationcompose.learn.ShowView
import com.example.myapplicationcompose.learn.WellnessScreen
import com.example.myapplicationcompose.ui.sample.*
import com.example.myapplicationcompose.ui.screen.ComposeUIListScreen
import com.example.myapplicationcompose.ui.screen.MainContent
import com.example.myapplicationcompose.ui.screen.NavigationListScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ComposeNavigation(barShow:(Boolean) -> Unit = { }){
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(navController = navController, startDestination = MainApp.route){
        composable(MainApp.route){
            MainContent(navController)
        }
        composable(MainFragmentList.route){
            NavigationListScreen(navController)
            barShow(true)
        }
        composable(MainFragmentHome.route){
            ShowView()
            barShow(true)
        }
        composable(Wellness.route){
            WellnessScreen()
            barShow(false)
        }
        composable(ComposeUIList.route){
            ComposeUIListScreen(navController)
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
        composable(IconSample.route){
            IconSampleScreen()
            barShow(false)
        }
        composable(ImageSample.route){
            ImageSampleScreen()
            barShow(false)
        }
        composable(SwitchSample.route){
            SwitchSampleScreen()
            barShow(false)
        }
        composable(TextFieldSample.route){
            TextFieldSampleScreen()
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