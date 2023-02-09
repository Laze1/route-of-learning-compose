package com.example.myapplicationcompose.ui.sample.text

import android.util.Log
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplicationcompose.R
import com.example.myapplicationcompose.ui.screen.TopBar

@Preview
@Composable
fun TextSamplePreview() {
    TextSample()
}

@Composable
fun TextUiListScreen(navController: NavController) {
    Column {
        TopBar("Text示例", navController)
        TextSample()
    }
}

@Composable
fun TextSample() {
    Column(
        modifier = Modifier.padding(15.dp).verticalScroll(ScrollState(0),true)
    ) {
        Text(text = "这是一个TextView")
        Text(text = stringResource(id = R.string.app_name))
        Text(text = "TextView-Color", color = Color.Blue)
        Text(text = "TextView-Color", color = Color(55, 66, 88))
        Text(text = "TextView-font", fontSize = 18.sp)
        Text(text = "Text-weight", fontWeight = FontWeight.Black)
        Text(text = "Text-weight", fontWeight = FontWeight.Bold)
        Text(text = "Text-weight", fontWeight = FontWeight.Light)
        Text(text = "Text-Family", fontFamily = FontFamily.Serif)//字体
        Text(text = "Text-Spacing", letterSpacing = 10.sp)//间距
        Text(text = "Text-Decoration", textDecoration = TextDecoration.Underline)
        Text(text = "Text-Decoration", textDecoration = TextDecoration.LineThrough)
        Text(
            text = "Text-Decoration",
            textDecoration = TextDecoration.combine(
                listOf(
                    TextDecoration.Underline,
                    TextDecoration.LineThrough
                )
            )
        )
        Text(
            text = "Text-Decoration",
            textDecoration = TextDecoration.combine(
                listOf(
                    TextDecoration.Underline,
                    TextDecoration.LineThrough
                )
            )
        )
        Text(text = "Text-maxLine", Modifier.width(20.dp))
        Text(text = "Text-Modifier", Modifier.width(100.dp))
        Text(text = "Text-align", Modifier.width(100.dp), textAlign = TextAlign.End)
        Text(text = "Text-maxLine-x3", Modifier.width(30.dp), maxLines = 3)
        Text(
            text = "Text-maxLine-x3",
            Modifier.width(30.dp),
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
        Text(text = "Text-fontStyle", fontStyle = FontStyle.Italic)
        Text(
            text = "Text-style", style = TextStyle(
                color = Color.Green,
                fontSize = 20.sp,
                letterSpacing = 5.sp,
                textDecoration = TextDecoration.Underline
            )
        )//可以设置很多
        SelectionContainer {//长按复制
            Text(text = "长按可以复制的text")
        }
        ClickableText(text = AnnotatedString("可以点击的文本"), onClick = {
            Log.d("TextSample", "点击文本位置：$it")
        })
        ClickableText(
            text = AnnotatedString("可以点击的文本", spanStyle = SpanStyle(Color.Blue)),
            onClick = {
                Log.d("TextSample", "点击文本位置：$it")
            })
        val t1 = "我有"
        val t2 = "18082"
        val t3 = "个牛顿"
        ClickableText(text = buildAnnotatedString {
            append(t1)
            withStyle(
                style = SpanStyle(
                    color = Color.Green,
                    textDecoration = TextDecoration.Underline
                )
            ){
                append(t2)
            }
            append(t3)
        }, onClick = {
            if (it in t1.length + 1 .. (t1+t2).length) {
                Log.d("TextSample", "点击了数字$t2")
            }
        })

        val build = buildAnnotatedString {
            append("我们要去")
            pushStringAnnotation("madao","这是马岛")
            withStyle(
                style = SpanStyle(
                    color = Color.Green,
                    textDecoration = TextDecoration.Underline
                )
            ){
                append("马岛")
            }
            pop()
            append("看看怎么样，那儿曾发生过")
            pushStringAnnotation("madaozz","这个是马岛战争")
            append("马岛战争")
            pop()
            append("！")
        }
        ClickableText(text = build, style = TextStyle(fontSize = 20.sp), onClick = {
            build.getStringAnnotations("madao",it,it).firstOrNull()?.let {annotated ->
                Log.d("TextSample", annotated.item)
            }
            build.getStringAnnotations("madaozz",it,it).firstOrNull()?.let {annotated ->
                Log.d("TextSample", annotated.item)
            }
            if (it in t1.length + 1 .. (t1+t2).length) {
                Log.d("TextSample", "点击了数字$t2")
            }
        })

    }
}

