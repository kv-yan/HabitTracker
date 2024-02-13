package ru.habit.tracker

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val calendarItemShapeStart = RoundedCornerShape(topStart = 100.dp, bottomStart = 100.dp)
val calendarItemShapeEnd = RoundedCornerShape(topEnd = 100.dp, bottomEnd = 100.dp)
val calendarItemShapeMid = RoundedCornerShape(0.dp)

@Composable
fun DayItem(
    itemSettings: DayItemSettings,
) {


    Box(
        contentAlignment = Alignment.Center, /*modifier = Modifier.sizeIn(46.dp, 48.dp)*/
    ) {

        Surface( // TODO: for only container colors
            color = if (itemSettings.isHaveContainer) Color(0xFFEFE2FF) else Color.Transparent,
            shape = if (itemSettings.isContainerInMid) calendarItemShapeMid
            else if (itemSettings.isContainerInStart) calendarItemShapeStart
            else if (itemSettings.isContainerInEnd) calendarItemShapeEnd
            else calendarItemShapeMid,
            modifier = Modifier.padding(top = if (itemSettings.isHaveContainer) 4.dp else 0.dp)
        ) {


            Surface( // TODO: for only group colors
                shape = if (itemSettings.isGroupInMiddle) calendarItemShapeMid
                else if (itemSettings.isGroupInStart) calendarItemShapeStart else if (itemSettings.isGroupInEnd) calendarItemShapeEnd else calendarItemShapeMid,
                color = if (itemSettings.isHaveGroup) itemSettings.groupColor else Color.Transparent,
                modifier = Modifier.padding(
                    top = 4.dp,
                    bottom = 4.dp,
                    start = if (itemSettings.isHaveContainer && itemSettings.isContainerInStart) 4.dp else 0.dp,
                    end = if (itemSettings.isHaveContainer && itemSettings.isContainerInEnd) 4.dp else 0.dp
                )

            ) {


                Surface(// TODO: this layer is only for current day
                    color = if (itemSettings.isCurrentDay) Color(0xFF89CCC5) else Color.Transparent,
                    shape = CircleShape,
                    modifier = Modifier
                        .sizeIn(40.dp)
                        .padding(vertical = 4.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                    ) {

                        Text(
                            text = itemSettings.day,
                            color = Color(0xff272727),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 13.sp
                            ),
                            modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 9.dp)
                        )

                        if (itemSettings.isCurrentDay) Icon(
                            painter = painterResource(id = R.drawable.ic_current_day),
                            contentDescription = "Date",
                            modifier = Modifier.wrapContentHeight(align = Alignment.CenterVertically)
                        ) else {
                            Spacer(modifier = Modifier.height(8.dp))
                        }

                    }
                }


            }


        }
    }
}

@Preview
@Composable
fun TetPrev() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxSize()
    ) {
        val dayItemSettings = DayItemSettings(
            day = "15",
            isCurrentDay = false,
            isHaveGroup = true,
            isGroupInStart = true,
            isGroupInMiddle = false,
            isGroupInEnd = false,
            isHaveContainer = true,
            isContainerInStart = true,
            isContainerInMid = false,
            isContainerInEnd = false
        )
        DayItem(dayItemSettings)
        DayItem(
            dayItemSettings.copy(
                isCurrentDay = false,
                isHaveGroup = true,
                isGroupInStart = false,
                isGroupInMiddle = true,
                isGroupInEnd = false,
                isHaveContainer = true,
                isContainerInStart = false,
                isContainerInMid = true
            )
        )
        DayItem(
            dayItemSettings.copy(
                day = "17",
                isCurrentDay = false,
                isHaveGroup = true,
                isGroupInStart = false,
                isGroupInMiddle = false,
                isGroupInEnd = true,
                isHaveContainer = true,
                isContainerInStart = false,
                isContainerInMid = false,
                isContainerInEnd = true
            )
        )
    }

}

data class DayItemSettings(
    val day: String,
    val isCurrentDay: Boolean,
    val isHaveGroup: Boolean,
    val isGroupInStart: Boolean,
    val isGroupInMiddle: Boolean,
    val isGroupInEnd: Boolean,
    val isHaveContainer: Boolean,
    val isContainerInStart: Boolean,
    val isContainerInMid: Boolean,
    val isContainerInEnd: Boolean,
    val groupColor: Color = Color(0xFF89CCC5),
)


// Function to get DayItemSettings based on the day string
