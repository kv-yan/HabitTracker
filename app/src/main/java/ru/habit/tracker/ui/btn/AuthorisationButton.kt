package ru.habit.tracker.ui.btn

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

@Composable
fun AuthorisationButton(
    modifier: Modifier = Modifier,
    btnText: String,
    btnColor: Color,
    onClick: () -> Unit = {},
) {
    Button(
        onClick = { onClick.invoke() },
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = btnColor),
        modifier = modifier.requiredHeight(height = 52.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .requiredWidth(width = 240.dp)
                .requiredHeight(height = 52.dp)
        ) {
            Text(
                text = btnText,
                color = Color.White,
                textAlign = TextAlign.Center,
                lineHeight = 1.57.em,
                style = TextStyle(
                    fontSize = 14.sp, letterSpacing = 0.5.sp
                )
            )
        }
    }
}
