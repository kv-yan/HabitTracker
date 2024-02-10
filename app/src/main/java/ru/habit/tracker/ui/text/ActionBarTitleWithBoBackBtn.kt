package ru.habit.tracker.ui.text

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.habit.tracker.R
import ru.habit.tracker.ui.theme.actionBarTitleColor

@Composable
fun ActionBarTitleWithBoBackBtn(titleText: String, popBackStack: () -> Unit = {}) {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        IconButton(onClick = { popBackStack.invoke() }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_move_back),
                contentDescription = "arrow",
                tint = Color(0xff272727),
                modifier = Modifier.padding(start = 11.dp)
            )

        }
        Text(
            text = titleText,
            color = actionBarTitleColor,
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 24.sp, fontWeight = FontWeight.Medium
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 21.dp, top = 9.dp)
        )
    }
}

@Preview
@Composable
fun TitlePrev() {
    ActionBarTitleWithBoBackBtn(titleText = "")
}