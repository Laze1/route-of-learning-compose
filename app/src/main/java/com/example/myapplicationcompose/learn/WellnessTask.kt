package com.example.myapplicationcompose.learn

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue


/*
* 将 WellnessTask 更改为类，而不是数据类。让 WellnessTask 在构造函数中接收默认值为 false 的 initialChecked 变量，
* 然后可以使用工厂方法 mutableStateOf 来初始化 checked 变量并接受 initialChecked 作为默认值。
* */
class WellnessTask(
    val id: Int,
    val label: String,
    initialChecked: Boolean = false
) {
    var checked by mutableStateOf(initialChecked)
}