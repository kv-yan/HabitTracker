package ru.habit.tracker.ui

import androidx.compose.runtime.MutableState

data class HabitItem(
    val taskName: String,
    val isCompleted: MutableState<Boolean>,
    val icon: Int,
)
