package ru.habit.tracker

import androidx.compose.ui.graphics.Color

fun getDayItemSettings(day: String, currentDay: String): DayItemSettings {
    if (day.isNotEmpty()) {
        return when (day.toInt()) {
            2 -> DayItemSettings(
                day = day,
                isCurrentDay = currentDay == day,
                isHaveGroup = true,
                isGroupInStart = true,
                isGroupInMiddle = false,
                isGroupInEnd = false,
                isHaveContainer = false,
                isContainerInStart = false,
                isContainerInMid = true,
                isContainerInEnd = false,
                Color(0xffE2958D)
            )

            3 -> DayItemSettings(
                day = day,
                isCurrentDay = currentDay == day,
                isHaveGroup = true,
                isGroupInStart = false,
                isGroupInMiddle = false,
                isGroupInEnd = true,
                isHaveContainer = false,
                isContainerInStart = false,
                isContainerInMid = true,
                isContainerInEnd = false,
                Color(0xffE2958D)
            )


            4 -> DayItemSettings(
                day = day,
                isCurrentDay = currentDay == day,
                isHaveGroup = true,
                isGroupInStart = true,
                isGroupInMiddle = false,
                isGroupInEnd = false,
                isHaveContainer = true,
                isContainerInStart = true,
                isContainerInMid = false,
                isContainerInEnd = false
            )


            in 5 until currentDay.toInt() -> DayItemSettings(
                day = day,
                isCurrentDay = currentDay == day,
                isHaveGroup = true,
                isGroupInStart = false,
                isGroupInMiddle = true,
                isGroupInEnd = false,
                isHaveContainer = true,
                isContainerInStart = false,
                isContainerInMid = true,
                isContainerInEnd = false
            )

            in 9 until 8 -> DayItemSettings(
                day = day,
                isCurrentDay = currentDay == day,
                isHaveGroup = true,
                isGroupInStart = false,
                isGroupInMiddle = true,
                isGroupInEnd = false,
                isHaveContainer = true,
                isContainerInStart = false,
                isContainerInMid = true,
                isContainerInEnd = false,
                Color(0xffE2958D)
            )


            currentDay.toInt() -> DayItemSettings(
                day = day,
                isHaveGroup = true,
                isGroupInStart = false,
                isGroupInMiddle = false,
                isGroupInEnd = true,
                isCurrentDay = currentDay == day,
                isHaveContainer = true,
                isContainerInStart = false,
                isContainerInMid = false,
                isContainerInEnd = true
            )

            currentDay.toInt() - 1 -> DayItemSettings(
                day = day,
                isHaveGroup = true,
                isGroupInStart = false,
                isGroupInMiddle = false,
                isGroupInEnd = false,
                isCurrentDay = currentDay == day,
                isHaveContainer = true,
                isContainerInStart = false,
                isContainerInMid = false,
                isContainerInEnd = true
            )


            else -> DayItemSettings(
                day = day,
                isCurrentDay = currentDay == day,
                isHaveGroup = false,
                isGroupInStart = false,
                isGroupInMiddle = false,
                isGroupInEnd = false,
                isHaveContainer = false,
                isContainerInStart = false,
                isContainerInMid = false,
                isContainerInEnd = false
            )
        }

    } else {
        return DayItemSettings(
            day = day,
            isCurrentDay = currentDay == day,
            isHaveGroup = false,
            isGroupInStart = false,
            isGroupInMiddle = false,
            isGroupInEnd = false,
            isHaveContainer = false,
            isContainerInStart = false,
            isContainerInMid = false,
            isContainerInEnd = false
        )

    }
}