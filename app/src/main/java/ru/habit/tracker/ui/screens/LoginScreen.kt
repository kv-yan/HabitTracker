package ru.habit.tracker.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.habit.tracker.Screens
import ru.habit.tracker.ui.btn.AuthorisationButton
import ru.habit.tracker.ui.btn.ButtonRegistration
import ru.habit.tracker.ui.text.ActionBarTitle
import ru.habit.tracker.ui.text.LoginTextFields
import ru.habit.tracker.ui.text.PasswordTextFields

@Composable
fun LoginScreen(mainNavController: NavHostController) {
    var emailText = remember { mutableStateOf(TextFieldValue("")) }
    var passwordText = remember { mutableStateOf(TextFieldValue("")) }

    var isActiveBtn = (emailText.value.text.isNotEmpty() && passwordText.value.text.isNotEmpty())
    val scrollState = rememberScrollState()
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
            .verticalScroll(scrollState),
        color = Color(0xFFF8F8F8)
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
            LoginTextFields("Электронная почта или логин", text = emailText)

            Spacer(modifier = Modifier.height(12.dp))
            PasswordTextFields("Пароль", text = passwordText)

            Spacer(modifier = Modifier.height(12.dp))
            Text(text = "Забыли пароль?", Modifier.clickable {
                mainNavController.navigate(Screens.RECOVERY.route)
            })

            Spacer(modifier = Modifier.height(200.dp))
            AuthorisationButton(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 44.dp),
                btnText = "ВОЙТИ",
                isActiveBtn,
                onClick = {
                    mainNavController.navigate(Screens.MAIN.route)
                })

            Spacer(modifier = Modifier.height(12.dp))
            ButtonRegistration(text = "РЕГИСТРАЦИЯ",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 44.dp),
                onClick = {
                    mainNavController.navigate(Screens.REGISTRATION.route)
                })
        }
    }
}

val btnPassiveColor = Color(0xFFD7EBE9)
val btnActiveColor = Color(0xFF89CCC5)




