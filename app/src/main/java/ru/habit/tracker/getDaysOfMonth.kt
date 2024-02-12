/*
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

fun getWeeksOfMonth(year: Int, month: Int): List<List<String>> {
    val firstDayOfMonth = LocalDate.of(year, month, 1)
    val lastDayOfMonth = firstDayOfMonth.plusMonths(1).minusDays(1)

    var currentDate = firstDayOfMonth
    val weeksList = mutableListOf<List<String>>()

    while (currentDate.isBefore(lastDayOfMonth) || currentDate.isEqual(lastDayOfMonth)) {
        val weekDays = mutableListOf<String>()

        for (dayOfWeek in DayOfWeek.values()) {
            if (currentDate.dayOfWeek == dayOfWeek) {
                weekDays.add(currentDate.dayOfMonth.toString())
                currentDate = currentDate.plusDays(1)
            } else {
                weekDays.add("") // День не принадлежит текущему месяцу
            }
        }

        weeksList.add(weekDays)
    }

    return weeksList
}

fun main() {
    val year = 2024
    val month = 2 // Февраль
    val weeksOfMonth = getWeeksOfMonth(year, month)

    println("Weeks of the month:")
    for ((index, week) in weeksOfMonth.withIndex()) {
        println("Week ${index + 1}: $week")
    }
}
*/
import android.os.Build
import androidx.annotation.RequiresApi
import java.time.DayOfWeek
import java.time.LocalDate

data class CalendarMonth(
    val name: String,
    val weeks: List<List<String>>
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

        var currentDate = firstDayOfMonth
        val weeksList = mutableListOf<List<String>>()

        while (currentDate.isBefore(lastDayOfMonth) || currentDate.isEqual(lastDayOfMonth)) {
            val weekDays = mutableListOf<String>()

            for (dayOfWeek in DayOfWeek.values()) {
                if (currentDate.dayOfWeek == dayOfWeek) {
                    if (currentDate.monthValue == month) {
                        weekDays.add(currentDate.dayOfMonth.toString())
                    } else {
                        weekDays.add("") // Пустые строки, если день не принадлежит текущему месяцу
                    }
                    currentDate = currentDate.plusDays(1)
                } else {
                    weekDays.add("") // Пустые строки для пропущенных дней недели
                }
            }

            weeksList.add(weekDays)
        }

        val monthName = currentDate.month.toString() // Получаем название месяца
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

