package ru.habit.tracker

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.DayOfWeek
import java.time.LocalDate
import java.util.Locale
data class CalendarMonth(
    val name: String,
    val weeks: List<List<String>>,
)

class CalendarProvider(@RequiresApi(Build.VERSION_CODES.O) val year: Int) {
    val monthsList: List<CalendarMonth>

    init {
        monthsList = (1..12).map { getCalendarMonth(year, it) }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getCalendarMonth(year: Int, month: Int): CalendarMonth {
        val firstDayOfMonth = LocalDate.of(year, month, 1)
        val lastDayOfMonth = firstDayOfMonth.plusMonths(1).minusDays(1)

        var currentDate = firstDayOfMonth.minusDays(1)

        val weeksList = mutableListOf<List<String>>()

        while (currentDate.isBefore(lastDayOfMonth) || currentDate.isEqual(lastDayOfMonth)) {
            val weekDays = mutableListOf<String>()

            for (dayOfWeek in DayOfWeek.values()) {
                if (currentDate.dayOfWeek == dayOfWeek) {
                    if (currentDate.monthValue == month) {
                        weekDays.add(currentDate.dayOfMonth.toString())
                    } else {
                        weekDays.add("") // Empty strings for days not belonging to the current month
                    }
                    currentDate = currentDate.plusDays(1)
                } else {
                    weekDays.add("") // Empty strings for skipped days of the week
                }
            }

            weeksList.add(weekDays)
        }

        val monthName =
            firstDayOfMonth.month.getDisplayName(java.time.format.TextStyle.FULL, Locale("ru"))
        return CalendarMonth(monthName, weeksList)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getCurrentMonth(): Int {
        val currentDate = LocalDate.now()
        return currentDate.monthValue
    }
}

fun main() {
    val year = 2024
    val calendarProvider = CalendarProvider(year)

    println(calendarProvider.monthsList)
}
