package ru.habit.tracker.ui.screens.menu


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.habit.tracker.ui.screens.btnActiveColor
import ru.habit.tracker.ui.text.ActionBarTitle
import ru.habit.tracker.utils.AnimatedCircularProgressIndicatorWithText
import ru.habit.tracker.utils.Calendar
import ru.habit.tracker.utils.HabitRadioGroup


@Preview
@Composable
fun CalendarPrev() {
    CalendarScreen()
}

@Composable
fun CalendarScreen() {
    val scrollState = rememberScrollState()
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(scrollState)
    ) {
        Column {
            ActionBarTitle(titleText = "Календарь")
            Spacer(modifier = Modifier.height(22.dp))

            HabitRadioGroup()
            Spacer(modifier = Modifier.height(16.dp))
            
            Calendar()
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Твой прогресс:",
                color = Color(0xff272727),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 22.sp, fontWeight = FontWeight.Bold, letterSpacing = (-0.5).sp
                ),
            )

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(end = 40.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(24.dp, alignment = Alignment.Start)
            ) {
                AnimatedCircularProgressIndicatorWithText(
                    currentValue = 8,
                    maxValue = 15,
                    progressBackgroundColor = Color.Black,
                    progressIndicatorColor = btnActiveColor,
                    completedColor = btnActiveColor,
                )
                ProgressInfo(Modifier.width(170.dp))
            }
        }
    }
}


@Composable
fun ProgressInfo(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top), modifier = modifier
    ) {
        ProgressInfoItem("Выполнена:", 8, Modifier.fillMaxWidth())
        ProgressInfoItem("Пропущена:", 2, Modifier.fillMaxWidth())
        ProgressInfoItem("Лучшая серия:", 7, Modifier.fillMaxWidth())
        ProgressInfoItem("Осталось:", 5, Modifier.fillMaxWidth())
    }
}

@Composable
private fun ProgressInfoItem(title: String, days: Int, modifier: Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween, modifier = modifier
    ) {
        Text(
            text = title,
            color = Color(0xff272727),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 16.sp, fontWeight = FontWeight.Medium
            ),
        )
        Text(
            text = days.toString(), color = Color(0xff272727),

            style = TextStyle(
                fontSize = 16.sp, fontWeight = FontWeight.Medium, textAlign = TextAlign.End
            ), modifier = Modifier.fillMaxWidth()
        )
    }
}
