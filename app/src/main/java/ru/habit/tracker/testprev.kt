import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.habit.tracker.R
import ru.habit.tracker.ui.HabitItem

@Composable
fun MainColumnItem(modifier: Modifier = Modifier, habitItem: HabitItem) {
    Surface(modifier.padding(end = 16.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = Color.White,
                shadowElevation = 1.dp,
                modifier = Modifier
                    .weight(weight = 1f)
                    .clip(shape = RoundedCornerShape(16.dp))
                    .padding(
                        horizontal = 16.dp, vertical = 8.dp
                    )
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth(0.9f)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = habitItem.icon),
                            contentDescription = "image small",
                            modifier = Modifier/*
                                .requiredWidth(width = 42.dp)
                                .requiredHeight(height = 48.dp)*/
                        )
                        Text(
                            text = habitItem.taskName,
                            color = Color(0xff272727),
                            style = TextStyle(
                                fontSize = 13.sp, fontWeight = FontWeight.Medium
                            ),
                            modifier = Modifier
                                .requiredWidth(width = 161.dp)
                                .wrapContentHeight(align = Alignment.CenterVertically)
                        )
                    }
                }
            }

            Surface(
                shape = RoundedCornerShape(16.dp),
                color = if (habitItem.isCompleted.value) Color(0xffd7ebe9) else Color.White,
                shadowElevation = 1.dp
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        16.dp, Alignment.CenterHorizontally
                    ), verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(
                            20.dp
                        )

                ) {
                    Icon(
                        painter = painterResource(id = if (habitItem.isCompleted.value) R.drawable.ic_checked else R.drawable.ic_not_checked),
                        contentDescription = "var1",
                        tint = Color(0xff272727),
                        modifier = Modifier.size(24.dp)

                    )
                }

            }
        }
    }
}