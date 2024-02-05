package ru.habit.tracker.ui.text


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.habit.tracker.ui.theme.actionBarTitleColor

@Composable
fun InfoAboutCodeMessage(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = "Введите код из смс",
            color = actionBarTitleColor,
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 16.sp, fontWeight = FontWeight.Medium
            )
        )
        Text(
            text = "Чтобы подтвердить, что это вы",
            color = actionBarTitleColor,
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 13.sp, fontWeight = FontWeight.Medium
            )
        )
    }
}
