package ru.habit.tracker.ui.screens.menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import ru.habit.tracker.ui.text.LoginTextFields
import ru.habit.tracker.utils.CustomRadioGroup

@Composable
fun AddNewHabitScreen() {
    Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFF8F8F8)) {
        Column(Modifier.padding(horizontal = 16.dp)) {
            ActionBar()
            Spacer(modifier = Modifier.height(11.dp))

            LoginTextFields(hintName = "привычкa".capitalize())
            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "Я смогу привыкнуть за:",
                color = Color(0xff272727),
                textAlign = TextAlign.Center,
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium)
            )
            Spacer(modifier = Modifier.height(16.dp))

            CustomRadioGroup()

        }
    }
}

@Preview
@Composable
fun AddHabitScreenPrev() {
    AddNewHabitScreen()
}

@Composable
private fun ActionBar() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 9.dp)
    ) {
        Text(
            text = "Создать новую привычку",
            color = Color(0xff272727),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 22.sp, fontWeight = FontWeight.Bold, letterSpacing = (-0.5).sp
            )
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_remove_field_text),
            contentDescription = "email_icons",
            tint = Color(0xff272727)
        )
    }

}