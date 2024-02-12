package ru.habit.tracker.utils


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp


@Composable
fun HabitRadioGroup() {
    val scrollState = rememberScrollState()
    val options = listOf(
        "Все",
        "Утренний бег",
        "Нет вредной еде",
        "Отдых от смартфона",
        "Учиться новому",
    )
    var selectedOption by remember {
        mutableStateOf("")
    }
    val onSelectionChange = { text: String ->
        selectedOption = text
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
        modifier = Modifier.horizontalScroll(scrollState)
    ) {
        options.forEach { text ->
            Surface(shape = RoundedCornerShape(10.dp), shadowElevation = 2.dp) {
                Row(horizontalArrangement = Arrangement.spacedBy(
                    10.dp, Alignment.CenterHorizontally
                ),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(color = if (selectedOption == text) Color(0xffd7ebe9) else Color.White)
                        .border(
                            border = BorderStroke(
                                1.dp, if (selectedOption == text) Color(0xff89ccc5) else Color.White
                            ), shape = RoundedCornerShape(10.dp)
                        )
                        .clickable {
                            onSelectionChange(text)
                        }) {
                    Text(
                        text = text,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        lineHeight = 1.57.em,
                        style = TextStyle(
                            fontSize = 14.sp
                        ),
                        modifier = Modifier.padding(
                            horizontal = 24.dp, vertical = 3.dp
                        )
                    )
                }

            }
        }
    }
}
