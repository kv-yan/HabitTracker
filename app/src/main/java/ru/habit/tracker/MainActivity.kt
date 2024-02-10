package ru.habit.tracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.habit.tracker.ui.navigation.MainNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            HabitTrackerTheme {
            // A surface container using the 'background' color from the theme
            MainNavHost()
//            }
        }
    }
}

