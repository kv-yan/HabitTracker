package ru.habit.tracker.utils


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.habit.tracker.R


@Composable
fun CalendarHeader(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .heightIn(max = 45.dp)
            .padding(
                top = 16.dp, bottom = 12.dp
            )
    ) {
        CalendarActionBar()
        Column(
            verticalArrangement = Arrangement.spacedBy(9.dp, Alignment.Top)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(
                    7.2.dp, Alignment.CenterHorizontally
                ), modifier = Modifier
                    .clip(shape = RoundedCornerShape(90.dp))
                    .padding(
                        start = 7.2.dp, end = 3.6.dp
                    )
            ) {
                Text(
                    text = "Январь 2024",
                    color = Color(0xff272727),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 13.sp
                    ),
                )
                Image(
                    painter = painterResource(id = R.drawable.icon),
                    contentDescription = "icon",
                    colorFilter = ColorFilter.tint(Color(0xff272727)),
                    modifier = Modifier.requiredSize(size = 16.dp)
                )
            }
        }
        IconButton(onClick = { }) {
            Column(
                verticalArrangement = Arrangement.spacedBy(
                    9.dp, Alignment.CenterVertically
                ),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.requiredSize(size = 43.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        9.dp, Alignment.CenterHorizontally
                    ),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clip(shape = RoundedCornerShape(90.1.dp))
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(
                            9.dp, Alignment.CenterHorizontally
                        ),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(all = 7.2.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.navigate_before),
                            contentDescription = "Icons/navigate_next",
                            tint = Color(0xff272727),
                            modifier = Modifier.requiredSize(size = 22.dp)
                        )
                    }
                }
            }
        }
    }
}
