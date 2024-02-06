package ru.habit.tracker.ui.text

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MenuTopBarTitle(modifier: Modifier = Modifier, title: String) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(222.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(
            horizontal = 20.dp, vertical = 9.dp
        )
    ) {
        Text(
            text = title,
            color = Color(0xff272727),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 28.sp, fontWeight = FontWeight.Bold, letterSpacing = (-0.5).sp
            )
        )
    }
}
