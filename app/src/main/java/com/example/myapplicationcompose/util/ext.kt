package com.example.myapplicationcompose.util

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

const val YY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss"
const val YY_MM_DD_T_HH_MM_SS_Z = "yyyy-MM-dd'T'HH:mm:ss'Z'"

@SuppressLint("SimpleDateFormat")
fun Long.toTime(): String {
    val date = Date(this) // 创建一个表示给定时间戳的 Date 对象
    val sdf = SimpleDateFormat(YY_MM_DD_HH_MM_SS) // 创建一个指定格式的 SimpleDateFormat 对象
    return sdf.format(date) // 使用 SimpleDateFormat 将 Date 格式化为字符串
}

@RequiresApi(Build.VERSION_CODES.O)
fun String.toTime(): String {
    val formatter = DateTimeFormatter.ofPattern(YY_MM_DD_T_HH_MM_SS_Z)
    val dateTime = LocalDateTime.parse(this, formatter)
    return dateTime.format(DateTimeFormatter.ofPattern(YY_MM_DD_HH_MM_SS))
}