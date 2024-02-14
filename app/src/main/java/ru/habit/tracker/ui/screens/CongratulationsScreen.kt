package ru.habit.tracker.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ru.habit.tracker.Screens
import ru.habit.tracker.ui.btn.AuthorisationButton
import ru.habit.tracker.ui.theme.actionBarTitleColor


@Composable
fun CongratulationsScreen(mainNavController: NavHostController) {
    BackHandler {

    }

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

            Spacer(modifier = Modifier.height(161.dp))
            Text(
                text = "Пароль сохранён",
                color = actionBarTitleColor,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 16.sp, fontWeight = FontWeight.Medium
                ),
            )

            Column(Modifier.fillMaxHeight()) {
                Spacer(modifier = Modifier.height(300.dp))
                AuthorisationButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    btnText = "войти".uppercase(),
                    isActiveColor = true
                ) {
                    mainNavController.navigate(Screens.MAIN.route)
                }
            }
        }
    }
}


