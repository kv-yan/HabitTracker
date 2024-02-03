package ru.habit.tracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.habit.tracker.ui.screens.LoginScreen
import ru.habit.tracker.ui.theme.HabitTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            HabitTrackerTheme {
                // A surface container using the 'background' color from the theme
                LoginScreen()
//            }
        }
    }
}

