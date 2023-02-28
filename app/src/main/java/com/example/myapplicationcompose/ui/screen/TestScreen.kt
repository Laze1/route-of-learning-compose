package com.example.myapplicationcompose.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.myapplicationcompose.R

@Composable
fun TestScreen() {
    DisplaySnackBarOnClik()
}

@Composable
fun DisplaySnackBarOnClik() {

    var canShowSnackBar by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            onClick = { canShowSnackBar = !canShowSnackBar },
            elevation = ButtonDefaults.elevation(
                defaultElevation = 10.dp,
                pressedElevation = 15.dp,
                disabledElevation = 0.dp
            ),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(R.color.purple_200),
                contentColor = colorResource(R.color.white)
            )
        ) {
            Text(text = "Show Snack Bar")
        }

    }

    if (canShowSnackBar) {
        MySnackbar("Hello, Snackbar!", "Dismiss")
    }

}

@Composable
fun MySnackbar(
    message: String,
    actionLabel: String,
    duration: SnackbarDuration = SnackbarDuration.Short
) {
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(snackbarHostState) {
        snackbarHostState.showSnackbar(message, actionLabel, duration = duration)
    }
    Box(
        Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter
    ) {
        SnackbarHost(
            hostState = snackbarHostState
        )
    }
}