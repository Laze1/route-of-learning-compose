package com.example.myapplicationcompose.ui.screen

import androidx.compose.animation.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

@Composable
fun AnimationScreen() {
    val scrollState = rememberScrollState()
    Column {
        TopBar("列表")
        Column(
            modifier = Modifier
                .padding(15.dp, 0.dp, 15.dp, 0.dp)
                .fillMaxWidth()
                .verticalScroll(state = scrollState)
        ) {
            val density = LocalDensity.current
            //AnimatedVisibility 可组合项可为内容的出现和消失添加动画效果。
            var editable by rememberSaveable { mutableStateOf(true) }
            AnimatedVisibility(visible = editable,
                enter = slideInVertically {
                    // Slide in from 40 dp from the top.
                    with(density) { -40.dp.roundToPx() }
                } + expandVertically(
                    // Expand from the top.
                    expandFrom = Alignment.Top
                ) + fadeIn(
                    // Fade in with the initial alpha of 0.3f.
                    initialAlpha = 0.3f
                ),
                exit = slideOutVertically() + shrinkVertically() + fadeOut()) {
                Text(text = "This is Text1")
            }

            AnimatedVisibility(
                visible = !editable,
                enter = slideInVertically {
                    // Slide in from 40 dp from the top.
                    with(density) { 40.dp.roundToPx() }
                } + expandVertically(
                    // Expand from the top.
                    expandFrom = Alignment.Bottom
                ) + slideIn(
                    initialOffset = { IntOffset(100, 0) }
                ),
                exit = slideOutHorizontally() + shrinkHorizontally() + slideOutHorizontally(),
                modifier = Modifier.align(Alignment.End)) {
                Text(text = "This is Text2")
            }

            Button(
                onClick = { editable = !editable },
            ) {
                Text(text = "AnimatedVisibility")
            }



        }
    }
}
