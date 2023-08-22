package com.example.myapplicationcompose.ui.screen

import androidx.compose.animation.*
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationcompose.R

@OptIn(ExperimentalAnimationApi::class)
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
                Image(
                    bitmap = ImageBitmap.imageResource(id = R.mipmap.r),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(10.dp)
                        .clip(RoundedCornerShape(5.dp))
                )
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
                Image(
                    bitmap = ImageBitmap.imageResource(id = R.mipmap.xiao),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(10.dp)
                        .clip(RoundedCornerShape(5.dp))
                )
            }

            Button(
                onClick = { editable = !editable },
            ) {
                Text(text = "AnimatedVisibility")
            }

            //animate*AsState
            //用于为单个值添加动画效果。您只需提供结束值（或目标值），该 API 就会从当前值开始向指定值播放动画。
            var enabled by rememberSaveable { mutableStateOf(true) }
            val alpha: Float by animateFloatAsState(if (enabled) 1f else 0.2f)
            Box(
                Modifier
                    .fillMaxSize()
                    .graphicsLayer(alpha = alpha)
            ) {
                Image(
                    bitmap = ImageBitmap.imageResource(id = R.mipmap.xiao),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(10.dp)
                        .clip(RoundedCornerShape(5.dp))
                )
            }

            Button(onClick = { enabled = !enabled }) {
                Text(text = "animate*AsState")
            }

            var count by rememberSaveable { mutableStateOf(0) }

            Box(
                Modifier
                    .size(100.dp)
                    .padding(10.dp)
                    .background(Color.Gray)
            ) {
                AnimatedContent(
                    targetState = count,
                    transitionSpec = {
                        // Compare the incoming number with the previous number.
                        if (targetState > initialState) {
                            // If the target number is larger, it slides up and fades in
                            // while the initial (smaller) number slides up and fades out.
                            slideInVertically { height -> height + 10 } + fadeIn() with
                                    slideOutVertically { height -> -height } + fadeOut()
                        } else {
                            // If the target number is smaller, it slides down and fades in
                            // while the initial number slides down and fades out.
                            slideInVertically { height -> -height - 10 } + fadeIn() with
                                    slideOutVertically { height -> height } + fadeOut()
                        }.using(
                            // Disable clipping since the faded slide-in/out should
                            // be displayed out of bounds.
                            SizeTransform(clip = false)
                        )
                    },
                    modifier = Modifier.align(Alignment.Center)
                ) { targetCount ->
                    Text(text = "$targetCount", fontSize = 25.sp)
                }
            }

            Button(onClick = { if (System.currentTimeMillis() % 2 == 0L) count++ else count-- }) {
                Text("Add")
            }

        }
    }
}
