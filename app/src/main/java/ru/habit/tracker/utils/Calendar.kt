package ru.habit.tracker.utils

import CalendarProvider
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
private fun CalendarPrev() {
    Calendar()
}

@Composable
fun Calendar() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            shape = RoundedCornerShape(28.dp),
            shadowElevation = 3.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .padding(top = 12.dp)
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(bottom = 28.dp)
            ) {
                CalendarHeader()
                WeekdaysOfMounts()
                DaysInWeek()
            }


        }
    }

}


@Composable
private fun WeekdaysOfMounts() {
    val weekdaysItems = remember {
        mutableListOf(
            "Пн",
            "Вт",
            "Ср",
            "Чт",
            "Пт",
            "Сб",
            "Вс",
        )
    }


    Row(
        Modifier
            .fillMaxWidth()
            .padding(4.dp), horizontalArrangement = Arrangement.Center
    ) {
        weekdaysItems.forEach {
            WeekdayItem(it)
        }
    }

}

@Composable
fun WeekdayItem(day: String) {
    Box(
        contentAlignment = Alignment.Center, modifier = Modifier.size(46.dp, 48.dp)
    ) {
        Text(
            text = day, color = Color(0xff89ccc5), textAlign = TextAlign.Center, style = TextStyle(
                fontSize = 13.sp
            ), modifier = Modifier.wrapContentHeight(align = Alignment.CenterVertically)
        )
    }
}

@Composable
fun DayItem(day: String) {
    Box(
        contentAlignment = Alignment.Center, modifier = Modifier.size(46.dp, 48.dp)
    ) {
        Text(
            text = day, color = Color(0xff272727), textAlign = TextAlign.Center, style = TextStyle(
                fontSize = 13.sp
            ), modifier = Modifier.wrapContentHeight(align = Alignment.CenterVertically)
        )
    }
}

@Composable
fun DaysInWeek() {

    val calendarProvider = remember {
        CalendarProvider(2024).monthsList[1]
    }

    Column(Modifier.fillMaxWidth()) {
        calendarProvider.weeks.forEach {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                it.forEach {
                    DayItem(it)
                }
            }
        }
    }
}

