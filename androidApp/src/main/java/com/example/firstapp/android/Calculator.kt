package com.example.firstapp.android

import MyColor
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Calculator : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingPreview()
        }
    }
}

val sky = mutableStateOf("")
val s by sky


@Composable
@Preview
fun GreetingPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = s,
                color = Color.White,
                fontSize = 60.sp,
                modifier = Modifier.padding(end = 25.dp, bottom = 25.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .weight(.3f)
        ) {

            button(rowScope = this, color = Color.DarkGray, text = "AC")
            button(rowScope = this, color = Color.DarkGray, text = "%")
            button(rowScope = this, color = Color.DarkGray, text = "⇦")
            button(rowScope = this, color = Color.DarkGray, text = "/")

        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .weight(.3f)
        ) {

            button(rowScope = this, color = Color.Gray, text = "7")
            button(rowScope = this, color = Color.Gray, text = "8")
            button(rowScope = this, color = Color.Gray, text = "9")
            button(rowScope = this, color = Color.DarkGray, text = "x")
        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .weight(.3f)
        ) {
            button(rowScope = this, color = Color.Gray, text = "4")
            button(rowScope = this, color = Color.Gray, text = "5")
            button(rowScope = this, color = Color.Gray, text = "6")
            button(rowScope = this, color = Color.DarkGray, text = "-")

        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .weight(.3f)
        ) {
            button(rowScope = this, color = Color.Gray, text = "1")
            button(rowScope = this, color = Color.Gray, text = "2")
            button(rowScope = this, color = Color.Gray, text = "3")
            button(rowScope = this, color = Color.DarkGray, text = "+")
        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .weight(.3f)
        ) {

            button(rowScope = this, color = Color.Gray, text = "00")
            button(rowScope = this, color = Color.Gray, text = "0")
            button(rowScope = this, color = Color.Gray, text = ".")
            button(rowScope = this, MyColor.orange, text = "=")
        }
    }
}

var firstvalue = 0.0
var secondvalue = 0.0


@Composable

fun button(rowScope: RowScope, color: Color, text: String) {
    rowScope.apply {

        Button(
            onClick = {
                Log.d("==>", "button: ")
                if (text == "AC") {
                    sky.value = ""
                    firstvalue = 0.0
                    secondvalue = 0.0

                } else if (text == "⇦") {
                    try {
                        sky.value = (sky.value.substring(0, sky.value.length - 1))
                    } catch (e: StringIndexOutOfBoundsException) {

                        Log.e("===cdmi===", "button:${e.message}")
                    }
                } else if (text == "0" || text == "00") {
                    if (sky.value == "" || sky.value.length > 1) {
                        sky.value += "0"
                    }
                } else if (text == ".") {
                    if (sky.value == "") {
                        sky.value = "0."
                    }

                    if (!sky.value.contains(".")) {
                        sky.value += "."
                    }
                } else if (text == "+" || text == "-" || text == "x" || text == "/") {
                    if (sign == "+") {
                        firstvalue += sky.value.toDouble()
                    } else if (sign == "-") {
                        firstvalue -= sky.value.toDouble()
                    } else if (sign == "x") {
                        firstvalue *= sky.value.toDouble()
                    } else if (sign == "/") {
                        firstvalue /= sky.value.toDouble()
                    } else {
                        firstvalue = sky.value.toDouble()
                    }
                    sky.value = ""
                    sign = text
                } else if (text == "=") {
                    secondvalue = sky.value.toDouble()
                    var ans = 0.0

                    if (sign == "+") {
                        ans = firstvalue + secondvalue
                    } else if (sign == "-") {
                        ans = firstvalue - secondvalue
                    } else if (sign == "x") {
                        ans = firstvalue * secondvalue
                    } else if (sign == "/") {
                        ans = firstvalue / secondvalue
                    }

                    sky.value = ans.toString()
                } else {
                    sky.value += text
                }
            },

            enabled = true,
            colors = ButtonDefaults.buttonColors(color),
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp)
                .weight(1f)
        ) {
            Text(
                text = text,
                fontStyle = FontStyle.Normal,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = if (text == "AC") {
                    30.sp
                } else if (text == "⇦") {
                    50.sp
                } else if (text == "00") {
                    30.sp
                } else {
                    35.sp
                }
            )
        }
    }
}

var sign = ""




