package com.example.myapplicationcompose.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.myapplicationcompose.learn.ShowView
import com.example.myapplicationcompose.learn.WellnessScreen
import com.example.myapplicationcompose.ui.sample.*
import com.example.myapplicationcompose.ui.screen.*
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ComposeNavigation() {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(navController = navController, startDestination = MainApp.route) {
        composable(MainApp.route) {
            MainContent(navController)
        }
        composable(MainFragmentList.route) {
            NavigationListScreen(navController)
        }
        composable(MainFragmentHome.route) {
            ShowView()
        }
        composable(Wellness.route) {
            WellnessScreen()
        }
        composable(ComposeUIList.route) {
            ComposeUIListScreen(navController)
        }
        composable(TextUIList.route) {
            TextUiListScreen(navController)
        }
        composable(ModifierSample.route) {
            ModifierSample()
        }
        composable(ButtonSample.route) {
            ButtonSampleScreen()
        }
        composable(IconSample.route) {
            IconSampleScreen()
        }
        composable(ImageSample.route) {
            ImageSampleScreen()
        }
        composable(SwitchSample.route) {
            SwitchSampleScreen()
        }
        composable(TextFieldSample.route) {
            TextFieldSampleScreen()
        }
        composable(TestScreen.route) {
            TestScreen()
        }
        composable(ListScreen.route) {
            ListScreen({ navController.navigate("${ListItemDetail.route}/$it") },
                { navController.popBackStack() })
        }
        composable("${ListItemDetail.route}/{${ListItemDetail.PARAMS_ID}}", arguments = listOf(
            navArgument(ListItemDetail.PARAMS_ID) {
                type = NavType.IntType
            }
        )) {
            val argument = requireNotNull(it.arguments)
            val id = argument.getInt(ListItemDetail.PARAMS_ID)
            ListItemDetailScreen(id, { navController.popBackStack() })
        }
        composable(AnimationScreen.route) {
            AnimationScreen()
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