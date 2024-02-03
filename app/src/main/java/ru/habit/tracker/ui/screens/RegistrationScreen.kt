package ru.habit.tracker.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.habit.tracker.ui.btn.AuthorisationButton
import ru.habit.tracker.ui.text.ActionBarTitleWithBoBackBtn
import ru.habit.tracker.ui.text.LoginTextFields
import ru.habit.tracker.ui.text.RegistrationHintTxt

@Preview
@Composable
fun RegistrationPrev() {
    RegistrationScreen()
}

@Composable
fun RegistrationScreen() {
    val scrollState = rememberScrollState()
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            ActionBarTitleWithBoBackBtn(titleText = "Регистрация")

            Spacer(modifier = Modifier.height(120.dp))
            LoginTextFields("Имя")

            Spacer(modifier = Modifier.height(12.dp))
            LoginTextFields("Фамилия")

            Spacer(modifier = Modifier.height(12.dp))
            LoginTextFields("Логин")

            Spacer(modifier = Modifier.height(12.dp))
            LoginTextFields("Электронная почта")

            Spacer(modifier = Modifier.height(190.dp))

            RegistrationHintTxt()
            Spacer(modifier = Modifier.height(16.dp))
            AuthorisationButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                btnText = "Регистрация",
                btnColor = btnPassiveColor
            )
        }
    }
}


