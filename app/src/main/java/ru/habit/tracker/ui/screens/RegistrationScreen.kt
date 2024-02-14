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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.habit.tracker.Screens
import ru.habit.tracker.ui.btn.AuthorisationButton
import ru.habit.tracker.ui.text.ActionBarTitleWithBoBackBtn
import ru.habit.tracker.ui.text.LoginTextFields
import ru.habit.tracker.ui.text.RegistrationHintTxt


@Composable
fun RegistrationScreen(mainNavController: NavHostController) {
    val scrollState = rememberScrollState()

    val nameText = remember { mutableStateOf(TextFieldValue("")) }
    val surnameText = remember { mutableStateOf(TextFieldValue("")) }
    val loginText = remember { mutableStateOf(TextFieldValue("")) }
    val emailText = remember { mutableStateOf(TextFieldValue("")) }

    var isActiveBtn =
        (nameText.value.text.isNotEmpty() && surnameText.value.text.isNotEmpty() && loginText.value.text.isNotEmpty() && emailText.value.text.isNotEmpty())

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
            ActionBarTitleWithBoBackBtn(titleText = "Регистрация", popBackStack = {
                mainNavController.popBackStack()
            })

            Spacer(modifier = Modifier.height(80.dp))
            LoginTextFields("Имя", text = nameText)

            Spacer(modifier = Modifier.height(12.dp))
            LoginTextFields("Фамилия", text = surnameText)

            Spacer(modifier = Modifier.height(12.dp))
            LoginTextFields("Логин", text = loginText)

            Spacer(modifier = Modifier.height(12.dp))
            LoginTextFields("Электронная почта", text =emailText )

            Spacer(modifier = Modifier.height(130.dp))

            RegistrationHintTxt()
            Spacer(modifier = Modifier.height(16.dp))
            AuthorisationButton(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
                btnText = "Регистрация",
                isActiveColor = isActiveBtn,
                onClick = {
                    mainNavController.navigate(Screens.NEW_PASSWORD_SCREEN.route)
                })
        }
    }
}


