package ru.habit.tracker.utils

import CalendarProvider
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.habit.tracker.DayItem
import ru.habit.tracker.getDayItemSettings
import ru.habit.tracker.ui.items.WeekdayItem

@Preview
@Composable
private fun CalendarPrev() {
    Calendar()
}

@Composable
fun Calendar() {
    Column(
        modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
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
private fun DaysInWeek() {

    val calendarProvider = remember {
        CalendarProvider(2024).monthsList[1]
    }

    Column(Modifier.fillMaxWidth()) {
        calendarProvider.weeks.forEach {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                it.forEach {
                    DayItem(getDayItemSettings(it,"14"))
                }
            }
        }
    }
}

