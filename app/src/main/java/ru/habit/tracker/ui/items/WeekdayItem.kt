package ru.habit.tracker.ui.items


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun WeekdayItem(day: String) {

    Box(
        contentAlignment = Alignment.Center, /*modifier = Modifier.sizeIn(46.dp, 48.dp)*/
    ) {

        Surface( // TODO: for only container colors

        ) {


            Surface( // TODO: for only group colors
                modifier = Modifier.padding(vertical = 4.dp)
            ) {


                Surface(// TODO: this layer is only for current day
                    shape = CircleShape, modifier = Modifier
                        .sizeIn(40.dp)
                        .padding(vertical = 4.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                    ) {

                        Text(
                            text = day,
                            color = Color(0xff89ccc5),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 13.sp
                            ),
                            modifier = Modifier.wrapContentHeight(align = Alignment.CenterVertically)
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                    }
                }


            }


        }
    }

}
