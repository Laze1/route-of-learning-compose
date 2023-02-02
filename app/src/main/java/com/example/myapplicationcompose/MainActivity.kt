package com.example.myapplicationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplicationcompose.ui.theme.MyApplicationComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigation()
        }
    }
}

@Composable
fun ComposeNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main"){
        composable("main"){
            MyApp(navController = navController)
        }
        composable("test"){
            TestScreen()
        }
    }
}

@Composable
fun MyApp(navController: NavController){
    MyApplicationComposeTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Button(onClick = {navController.navigate("test")}) {
                Text(text = "button")
            }
        }
    }
}

@Composable
fun TestScreen(){
    Text(text = "test1111")
}
