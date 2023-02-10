package com.example.myapplicationcompose.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List

object MainApp : RallyDestination() {
    override val route = "MainApp"
}

object MainFragmentList : RallyDestination() {
    override val route = "MainFragmentList"
    override val icon = Icons.Filled.List
    override val label = "列表"
}

object MainFragmentHome : RallyDestination() {
    override val route = "MainFragmentHome"
    override val icon = Icons.Filled.Home
    override val label = "主页"
}

object Wellness : RallyDestination() {
    override val route = "Wellness"
}

object ComposeUIList : RallyDestination() {
    override val route = "ComposeUIList"
}

object TextUIList : RallyDestination() {
    override val route = "TextUIList"
}

object ModifierSample : RallyDestination() {
    override val route = "ModifierSample"
}

object ButtonSample : RallyDestination() {
    override val route = "ButtonSample"
}

object IconSample : RallyDestination() {
    override val route = "IconSample"
}

object ImageSample : RallyDestination() {
    override val route = "ImageSample"
}

