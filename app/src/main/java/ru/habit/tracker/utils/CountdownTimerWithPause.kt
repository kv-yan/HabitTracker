package ru.habit.tracker.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay

// Kotlin
@Composable
fun CountdownTimerWithPause(num: MutableState<Int> , startFrom:Int) {
    var timeLeft by remember { mutableStateOf(startFrom) }
    var isPaused by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = timeLeft, key2 = isPaused) {
        while (timeLeft > 0 && !isPaused) {
            delay(1000L)
            timeLeft--
            num.value = timeLeft
            println("timer :; $timeLeft")
        }
    }
}