package com.example.firstapp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ScaleFactor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MyView()
        }
    }
}

// @Preview   ===> @Composable  ==> circle function
@Composable
fun circle(rowScope: RowScope) {
    rowScope.apply {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .weight(1f), shape = RoundedCornerShape(
                topStart = 50.dp, topEnd = 50.dp, bottomStart = 50.dp, bottomEnd = 50.dp
            )
        ) {

        }
    }
}

@Composable
fun squar(rowScope: RowScope, color: Color) {
    rowScope.apply {

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            color = color,
            border = BorderStroke(2.dp, Color.Black)
        ) {
            Surface(
                color = Color.White,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(25.dp),
                border = BorderStroke(2.dp, Color.Black)
            ) {

                Column(modifier = Modifier.fillMaxSize()) {
                    for (i in 1..2) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(1f)
                        ) {
                            for (i in 1..2) {
                                Surface(
                                    color = color,
                                    border = BorderStroke(2.dp, Color.Black),
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .weight(1f)
                                        .padding(5.dp),
                                    shape = RoundedCornerShape(50)
                                ) {

                                }
                            }


                        }
                    }
                }
            }

        }
    }
}

@Composable
fun whitesquar(rowScope: RowScope? = null,columnScope: ColumnScope? = null, color: Color = Color.White) {
   if (rowScope != null) {
     rowScope.apply {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f), color =color, border = BorderStroke(1.dp,Color.Black)
        )
        {

        }
    }
   }else if (columnScope != null)
   {
       columnScope.apply {
           Surface(
               modifier = Modifier
                   .fillMaxSize()
                   .weight(1f), color =color, border = BorderStroke(1.dp,Color.Black)
           )
           {

           }
       }
// row and colum box together
   }
}


@Preview
@Composable
fun MyView() {
    //    Row(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(color = Color.Blue)
//    ) {
//        for (i in 1..5) {
//            circle(this)
//        }
//    }

    Column(modifier = Modifier.fillMaxSize()) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .weight(.6f)
                .background(Color.White)
        ) {}
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {

                squar(rowScope = this, color = Color.Red)
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(.6f)
                ) {

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(1f)
                        ) {
                            for (i in 1..6) {
                                whitesquar(columnScope = this)
                            }
                        }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                    ) {
                        whitesquar(columnScope = this)
                        for (i in 1..5) {
                            whitesquar(columnScope = this, color =  Color.Green)
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                    ) {
                        whitesquar(columnScope = this)
                        whitesquar(columnScope = this , color = Color.Green)
                        for (i in 1..4) {
                            whitesquar(columnScope = this)
                        }
                    }


                }
                squar(rowScope = this, color = Color.Green)
            }
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(.6f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(.3f)
                ) {


                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(.1f)
                    ) {
                        whitesquar(rowScope = this)
                        whitesquar(rowScope = this,color = Color.Red)
                        for (s in 1..4) {
                            whitesquar(rowScope = this)
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(.1f)
                    ) {
                        whitesquar(rowScope = this)
                        for (p in 1..5) {
                            whitesquar(rowScope = this,color = Color.Red)
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(.1f)
                    ) {
                        for (p in 1..6) {
                            whitesquar(rowScope = this)
                        }
                    }

                }
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(.2f)
                ) {
                    Surface(modifier = Modifier.fillMaxSize().weight(.5f), color = Color.Cyan , border = BorderStroke(3.dp , color = Color.Black)) {
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(.3f)
                ) {

                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(.1f)
                        ) {
                            for (i in 1..6) {
                                whitesquar(rowScope = this )
                            }
                        }
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(.1f)
                    ) {

                        for (i in 1..5) {
                            whitesquar(rowScope = this , color = Color.Yellow)
                        }
                        whitesquar(rowScope = this)
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(.1f)
                    ) {

                        for (i in 1..4) {
                            whitesquar(rowScope = this )
                        }
                        whitesquar(rowScope = this, color = Color.Yellow)
                        whitesquar(rowScope = this)
                    }

                }
            }
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {
                squar(rowScope = this, color = Color.Blue)
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(.6f)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(.5f)
                    ) {

                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .weight(1f)
                            ) {

                                for (i in 1..4) {
                                    whitesquar(columnScope = this)
                                }
                                whitesquar(columnScope = this , color = Color.Blue)
                                whitesquar(columnScope = this)

                            }

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(1f)
                        ) {

                            for (i in 1..5) {
                                whitesquar(columnScope = this , color = Color.Blue )
                            }
                            whitesquar(columnScope = this )
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(1f)
                        ) {
                            whitesquar(columnScope = this )
                            for (i in 1..5) {
                                whitesquar(columnScope = this )
                            }


                        }

                    }

                }
                squar(rowScope = this, color = Color.Yellow)
            }

        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .weight(.5f)
                .background(Color.White)
        ) {

        }
    }


}


