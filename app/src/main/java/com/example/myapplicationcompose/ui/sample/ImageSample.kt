package com.example.myapplicationcompose.ui.sample

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.example.myapplicationcompose.R
import com.example.myapplicationcompose.ui.view.Image

@Preview
@Composable
fun ImageSample() {
    ImageSampleScreen()
}

@Composable
fun ImageSampleScreen() {
    Column(
        modifier = Modifier.verticalScroll(ScrollState(0))
    ) {
        Image(
            painter = painterResource(id = R.drawable.haidengjie),
            contentDescription = null
        )
        val imageBitmap = ImageBitmap.imageResource(R.drawable.haidengjie)
        Image(
            bitmap = imageBitmap,
            contentDescription = null
        )
        AsyncImage(
            model = "https://developer.android.google.cn/static/images/jetpack/compose/graphics-sourceimage.jpg?hl=zh-cn",
            contentDescription = null
        )
        Image(
            painter = painterResource(id = R.drawable.back),
            contentDescription = null
        )
        val imageVector = ImageVector.vectorResource(id = R.drawable.back)
        Image(imageVector = imageVector, contentDescription = null)

        Image(id = R.mipmap.xiao)
    }
}