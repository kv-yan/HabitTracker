package ru.habit.tracker.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ru.habit.tracker.ui.btn.AuthorisationButton
import ru.habit.tracker.ui.text.ActionBarTitle
import ru.habit.tracker.ui.text.PasswordTextFields
import ru.habit.tracker.ui.theme.actionBarTitleColor


@Composable
fun ChangePasswordScreen(mainNavController: NavHostController) {
    BackHandler {

    }

    Surface(Modifier.padding(horizontal = 16.dp)) {
        Column {
            ActionBarTitle(titleText = "Придумайте пароль", modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(135.dp))

            PasswordTextFields(hintName = "Пароль")
            Spacer(modifier = Modifier.height(12.dp))

            PasswordTextFields(hintName = "Повторите пароль")
            Spacer(modifier = Modifier.height(12.dp))

            PasswordInfoText(modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(300.dp))

            AuthorisationButton(
                btnText = "Создать пароль".uppercase(),
                btnColor = btnActiveColor,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp)
            ) {
//                mainNavController.navigate(Screens..route) // TODO: create cong screen
            }

        }
    }

}


@Composable
fun PasswordInfoText(modifier: Modifier = Modifier) {
    Text(
        text = "Пароль должен содержать от 8 до 32 символов, из них минимум одна цифра и одна буква. Допускаются только латинские буквы.",
        color = actionBarTitleColor,
        style = TextStyle(
            fontSize = 12.sp, lineHeight = 22.sp, letterSpacing = 0.5.sp
        ),
        modifier = modifier
    )
}