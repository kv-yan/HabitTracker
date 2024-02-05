package ru.habit.tracker.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.habit.tracker.ui.BottomActionBar
import ru.habit.tracker.ui.theme.actionBarTitleColor


@Preview
@Composable
fun MainContainerScreenPREV() {
    MainContainerScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContainerScreen() {
    Scaffold(bottomBar = {
        BottomActionBar()
    }) {

        it
    }
}

