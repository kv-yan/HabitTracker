package ru.habit.tracker.utils

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import ru.habit.tracker.CalendarProvider
import ru.habit.tracker.DayItem
import ru.habit.tracker.getDayItemSettings
import ru.habit.tracker.ui.items.WeekdayItem
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun CalendarPrev() {
    Calendar()
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Calendar() {
    val calendarProvider = remember {
        CalendarProvider(2024)
    }
    val scope = rememberCoroutineScope()
    val pageState = rememberPagerState(1, 0f) { calendarProvider.monthsList.size }
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
                CalendarHeader(currentMouth = calendarProvider.monthsList[pageState.currentPage].name,
                    onNextMonth = {
                        scope.launch {
                            pageState.animateScrollToPage(
                                pageState.currentPage + 1, 0f
                            )
                        }
                    },
                    onPreviousMonth = {
                        scope.launch {
                            pageState.animateScrollToPage(
                                pageState.currentPage - 1, 0f
                            )
                        }
                    })
                WeekdaysOfMounts()
                DaysInWeek(
                    pageState = pageState, calendarProvider.monthsList[pageState.currentPage].weeks
                )
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

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun DaysInWeek(
    pageState: PagerState, weeks: List<List<String>>,
) {

    HorizontalPager(state = pageState) {
        Column(Modifier.fillMaxWidth()) {
            weeks.forEach {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = CenterVertically
                ) {
                    it.forEach {
                        DayItem(getDayItemSettings(it, LocalDate.now().dayOfMonth.toString(), pageState.currentPage))
                    }
                }
            }
        }
    }
}
