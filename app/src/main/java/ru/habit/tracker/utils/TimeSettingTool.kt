package ru.habit.tracker.utils

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.habit.tracker.R

@Composable
fun TimeSettingTool(modifier: Modifier = Modifier, text: String) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .background(color = Color(0xffd7ebe9))
            .border(
                border = BorderStroke(1.dp, Color(0xff89ccc5)), shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 8.dp)
    ) {
        Icon(
            painterResource(id = R.drawable.ic_minus),
            contentDescription = "Add",
            modifier = Modifier.size(12.dp)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clip(shape = RoundedCornerShape(10.dp))
                .background(color = Color.White)
                .border(
                    border = BorderStroke(1.dp, Color(0xff89ccc5)),
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(
                    horizontal = 27.dp, vertical = 8.dp
                )
        ) {
            Text(
                text = text, color = Color.Black, textAlign = TextAlign.Center, fontSize = 13.sp
            )
        }
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add",
            modifier = Modifier.size(12.dp)
        )
    }
}
