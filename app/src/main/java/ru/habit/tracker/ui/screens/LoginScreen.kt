package ru.habit.tracker.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import ru.habit.tracker.ui.btn.AuthorisationButton
import ru.habit.tracker.ui.btn.ButtonRegistration
import ru.habit.tracker.ui.text.ActionBarTitle
import ru.habit.tracker.ui.text.LoginTextFields
import ru.habit.tracker.ui.text.PasswordTextFields

@Preview
@Composable
fun LoginPrev() {
    LoginScreen()
}

@Composable
fun LoginScreen() {
    val scrollState = rememberScrollState()
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState), color = Color(0xFFF8F8F8)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            ActionBarTitle("Вход")

            Spacer(modifier = Modifier.height(120.dp))
            LoginTextFields("Электронная почта или логин")

            Spacer(modifier = Modifier.height(12.dp))
            PasswordTextFields("Пароль")

            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "Забыли пароль?", Modifier.clickable { })

            Spacer(modifier = Modifier.height(307.dp))
            AuthorisationButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 44.dp),
                btnText = "ВОЙТИ",
                btnColor = btnPassiveColor
            )

            Spacer(modifier = Modifier.height(12.dp))
            ButtonRegistration(
                text = "РЕГИСТРАЦИЯ", modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 44.dp)
            )
        }
    }
}

val btnPassiveColor = Color(0xFFD7EBE9)
val btnActiveColor = Color(0xFF89CCC5)




