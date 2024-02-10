package ru.habit.tracker.utils

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WeekdaysRadioGroup(options: MutableList<WeekdaysItem>) {
    val onOptionSelectedListener: (WeekdaysItem) -> Unit = {
        it.isSelected.value = !it.isSelected.value
    }


    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        options.forEach { item ->
            Row(horizontalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .size(36.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
                    .background(color = if (item.isSelected.value) Color(0xffd7ebe9) else Color.White)
                    .border(
                        border = BorderStroke(
                            1.dp, if (item.isSelected.value) Color(0xff89ccc5) else Color.White
                        ), shape = RoundedCornerShape(10.dp)
                    )
                    .clickable {
                        onOptionSelectedListener(item)
                    }) {
                Text(
                    text = item.dayName,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 14.sp
                    )
                )
            }
        }
    }
}


data class WeekdaysItem(
    var dayName: String,
    var isSelected: MutableState<Boolean>,
)

