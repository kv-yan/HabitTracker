package ru.habit.tracker.utils

import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import ru.habit.tracker.ui.screens.btnActiveColor

@Composable
fun AppSwitcher(modifier: Modifier = Modifier, defValue: Boolean) {
    val checkedState = remember { mutableStateOf(defValue) }
    Switch(
        checked = checkedState.value,
        onCheckedChange = { checkedState.value = it },
        modifier = modifier,
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.White,
            checkedBorderColor = btnActiveColor,
            checkedTrackColor = btnActiveColor,
            uncheckedThumbColor = Color(0xFFF7DFDD),
            uncheckedBorderColor = Color(0xFFF7DFDD),
            uncheckedTrackColor = Color.White,
        )
    )
}
