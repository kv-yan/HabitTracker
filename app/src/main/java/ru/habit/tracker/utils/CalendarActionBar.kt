package ru.habit.tracker.utils

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.habit.tracker.R


@Composable
fun CalendarActionBar(
    modifier: Modifier = Modifier, onNextMonth: () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(9.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.requiredSize(size = 43.dp)
    ) {
        IconButton(
            onClick = { onNextMonth.invoke() },
            modifier = Modifier.clip(shape = RoundedCornerShape(90.dp))
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(
                    9.dp, Alignment.CenterHorizontally
                ), verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        9.dp, Alignment.CenterHorizontally
                    ),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(all = 7.2.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.navigate_next),
                        contentDescription = "Icons/navigate_before",
                        tint = Color(0xff272727),
                        modifier = Modifier.requiredSize(size = 22.dp)
                    )
                }
            }
        }
    }
}
