package ru.habit.tracker.ui.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import ru.habit.tracker.R
import ru.habit.tracker.ui.theme.actionBarTitleColor

@Composable
fun ActionBarTitle(titleText: String) {
    Text(
        text = titleText,
        color = actionBarTitleColor,
        fontSize = 24.sp,
        fontFamily = FontFamily(Font(R.font.raleway_medium)),
    )
}