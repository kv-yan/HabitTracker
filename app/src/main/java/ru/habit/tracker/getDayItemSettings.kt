package ru.habit.tracker

import androidx.compose.ui.graphics.Color

fun getDayItemSettings(day: String, currentDay: String): DayItemSettings {
    if (day.isNotEmpty()) {
        return when (day.toInt()) {
            17 -> DayItemSettings(
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


            in 18..22 -> DayItemSettings(
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

            23 -> DayItemSettings(
                day = day,
                isHaveGroup = true,
                isGroupInStart = false,
                isGroupInMiddle = false,
                isGroupInEnd = true,
                isCurrentDay = currentDay == day,
                isHaveContainer = true,
                isContainerInStart = false,
                isContainerInMid = false,
                isContainerInEnd = false
            )
            27 -> DayItemSettings(
                day = day,
                isCurrentDay = currentDay == day,
                isHaveGroup = true,
                isGroupInStart = true,
                isGroupInMiddle = false,
                isGroupInEnd = false,
                isHaveContainer = true,
                isContainerInStart = false,
                isContainerInMid = false,
                isContainerInEnd = false,
                groupColor = Color(0xffE2958D)
            )
            28 -> DayItemSettings(
                day = day,
                isCurrentDay = currentDay == day,
                isHaveGroup = true,
                isGroupInStart = false,
                isGroupInMiddle = false,
                isGroupInEnd = true,
                isHaveContainer = true,
                isContainerInStart = false,
                isContainerInMid = false,
                isContainerInEnd = false,
                groupColor =Color(0xffE2958D)
            )

            29 -> DayItemSettings(
                day = day,
                isCurrentDay = currentDay == day,
                isHaveGroup = false,
                isGroupInStart = false,
                isGroupInMiddle = false,
                isGroupInEnd = false,
                isHaveContainer = true,
                isContainerInStart = false,
                isContainerInMid = false,
                isContainerInEnd = true
            )

            in 17..29 -> DayItemSettings(
                day = day,
                isCurrentDay = currentDay == day,
                isHaveGroup = false,
                isGroupInStart = false,
                isGroupInMiddle = false,
                isGroupInEnd = false,
                isHaveContainer = true,
                isContainerInStart = false,
                isContainerInMid = false,
                isContainerInEnd = false
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