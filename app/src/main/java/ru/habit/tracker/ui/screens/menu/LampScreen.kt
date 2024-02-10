package ru.habit.tracker.ui.screens.menu


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.habit.tracker.R
import ru.habit.tracker.ui.screens.btnActiveColor


@Composable
fun LampScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Row(
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_menu_lamp_passive),
                contentDescription = null,
                tint = btnActiveColor,
                modifier = Modifier.size(64.dp)
            )
        }
    }
}
