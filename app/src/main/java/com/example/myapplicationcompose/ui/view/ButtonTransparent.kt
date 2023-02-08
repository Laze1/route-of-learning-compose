package com.example.myapplicationcompose.ui.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun ButtonTransparent(
    modifier: Modifier = Modifier,
    onclick: () -> Unit = {},
    content: @Composable RowScope.() -> Unit
) {
    OutlinedButton(
        modifier = modifier.defaultMinSize(1.dp,1.dp),
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        border = BorderStroke(0.dp, Color.Transparent),
        onClick = onclick,
        content = content
    )
}
