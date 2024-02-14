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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ru.habit.tracker.Screens
import ru.habit.tracker.ui.btn.AuthorisationButton
import ru.habit.tracker.ui.text.ActionBarTitleWithBoBackBtn
import ru.habit.tracker.ui.text.LoginTextFields

@Composable
fun RecoveryScreen(mainNavController: NavHostController) {

    val emailText = remember { mutableStateOf(TextFieldValue("")) }

    var isActiveBtn = (emailText.value.text.length > 4)


    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            ActionBarTitleWithBoBackBtn(titleText = "Восстановить пароль") {
                mainNavController.popBackStack()
            }

            Spacer(modifier = Modifier.height(53.dp))

            Text(
                text = "Укажите адрес почты или номер телефона, который вы использовали при регистрации. \nМы пришлем вам код для восстановления пароля.",
                color = Color(0xff272727),
                style = TextStyle(
                    fontSize = 12.sp, lineHeight = 22.sp
                ),
                modifier = Modifier.fillMaxWidth()
            )



            Spacer(modifier = Modifier.height(44.dp))
            LoginTextFields("Электронная почта или телефон",emailText)

            Spacer(modifier = Modifier.height(230.dp))


            AuthorisationButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                btnText = "ПОЛУЧИТЬ КОД",
                isActiveColor = isActiveBtn
            ) {
                mainNavController.navigate(Screens.CONFIRMATION_SCREEN.route)
            }
        }
    }
}