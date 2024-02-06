package ru.habit.tracker.ui.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.text.TextStyle

import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.sp

import ru.habit.tracker.ui.theme.actionBarTitleColor


@Composable
fun SettingItemText(modifier: Modifier = Modifier, text: String) {
    Text(
        text = text, color = actionBarTitleColor, style = TextStyle(
            fontSize = 16.sp, fontWeight = FontWeight.Medium
        ), modifier = modifier
    )
}