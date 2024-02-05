package ru.habit.tracker.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.habit.tracker.ui.btn.AuthorisationButton
import ru.habit.tracker.ui.text.ActionBarTitleWithBoBackBtn
import ru.habit.tracker.ui.text.LoginTextFields

@Preview
@Composable
fun RecoveryPREV() {
    RecoveryScreen()
}

@Composable
fun RecoveryScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            ActionBarTitleWithBoBackBtn(titleText = "Восстановить пароль")

            Spacer(modifier = Modifier.height(53.dp))

            Text(
                text = "Укажите адрес почты или номер телефона, который вы использовали при регистрации. \nМы пришлем вам код для восстановления пароля.",
                color = Color(0xff272727),
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 22.sp
                ),
                modifier = Modifier.fillMaxWidth()
            )





            Spacer(modifier = Modifier.height(44.dp))
            LoginTextFields("Электронная почта или телефон")

            Spacer(modifier = Modifier.height(300.dp))


            AuthorisationButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                btnText = "ПОЛУЧИТЬ КОД",
                btnColor = btnPassiveColor
            )
        }
    }
}