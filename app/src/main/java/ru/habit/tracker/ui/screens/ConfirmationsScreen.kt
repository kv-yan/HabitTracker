package ru.habit.tracker.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ru.habit.tracker.Screens
import ru.habit.tracker.ui.btn.AuthorisationButton
import ru.habit.tracker.ui.text.ActionBarTitleWithBoBackBtn
import ru.habit.tracker.ui.text.InfoAboutCodeMessage
import ru.habit.tracker.ui.theme.actionBarTitleColor
import ru.habit.tracker.utils.CountdownTimerWithPause

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfirmationsScreen(mainNavController: NavHostController) {
    Surface(modifier = Modifier.fillMaxSize()) {


        Column() {
            ActionBarTitleWithBoBackBtn(titleText = "Подтверждение") {
                mainNavController.popBackStack()
            }
            Spacer(modifier = Modifier.height(127.dp))

            InfoAboutCodeMessage(Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(47.dp))

            val focusRequester1 = remember { FocusRequester() }
            val focusRequester2 = remember { FocusRequester() }
            val focusRequester3 = remember { FocusRequester() }
            val focusRequester4 = remember { FocusRequester() }
            val focusRequester5 = remember { FocusRequester() }

            var text1 by remember { mutableStateOf("") }
            var text2 by remember { mutableStateOf("") }
            var text3 by remember { mutableStateOf("") }
            var text4 by remember { mutableStateOf("") }

            if (text1.isNotEmpty() && text2.isNotEmpty() && text3.isNotEmpty() && text4.isNotEmpty()) {
                mainNavController.navigate(Screens.MAIN.route)
            }


            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
            ) {
                TextField(
                    value = text1, textStyle = TextStyle.Default.copy(
                        fontSize = 24.sp, textAlign = TextAlign.Center
                    ), onValueChange = {
                        text1 = it
                        if (text1.isNotEmpty()) {

                            focusRequester2.requestFocus()
                        }
                    }, colors = TextFieldDefaults.textFieldColors(
                        textColor = actionBarTitleColor,
                        containerColor = Color.Transparent,
                        focusedLabelColor = actionBarTitleColor,
                        unfocusedLabelColor = Color.Transparent,
                        disabledLabelColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent
                    ), modifier = Modifier
                        .focusRequester(focusRequester1)
                        .size(58.dp)
                        .border(
                            width = 1.dp,
                            color = Color(0xFFD7EBE9),
                            shape = RoundedCornerShape(8.dp)
                        )
                )
                Spacer(modifier = Modifier.width(12.dp))

                TextField(
                    value = text2, colors = TextFieldDefaults.textFieldColors(
                        textColor = actionBarTitleColor,
                        containerColor = Color.Transparent,
                        focusedLabelColor = actionBarTitleColor,
                        unfocusedLabelColor = Color.Transparent,
                        disabledLabelColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent
                    ), textStyle = TextStyle.Default.copy(
                        fontSize = 24.sp, textAlign = TextAlign.Center
                    ), onValueChange = {
                        text2 = it
                        if (text2.isNotEmpty()) {

                            focusRequester3.requestFocus()
                        }

                    }, modifier = Modifier
                        .focusRequester(focusRequester2)
                        .size(58.dp)
                        .border(
                            width = 1.dp,
                            color = Color(0xFFD7EBE9),
                            shape = RoundedCornerShape(8.dp)
                        )
                )
                Spacer(modifier = Modifier.width(12.dp))

                TextField(
                    value = text3, colors = TextFieldDefaults.textFieldColors(
                        textColor = actionBarTitleColor,
                        containerColor = Color.Transparent,
                        focusedLabelColor = actionBarTitleColor,
                        unfocusedLabelColor = Color.Transparent,
                        disabledLabelColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent
                    ), textStyle = TextStyle.Default.copy(
                        fontSize = 24.sp, textAlign = TextAlign.Center
                    ), onValueChange = {
                        text3 = it
                        if (text3.isNotEmpty()) {

                            focusRequester4.requestFocus()
                        }

                    }, modifier = Modifier
                        .focusRequester(focusRequester3)
                        .size(58.dp)
                        .border(
                            width = 1.dp,
                            color = Color(0xFFD7EBE9),
                            shape = RoundedCornerShape(8.dp)
                        )
                )
                Spacer(modifier = Modifier.width(12.dp))

                TextField(
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = actionBarTitleColor,
                        containerColor = Color.Transparent,
                        focusedLabelColor = actionBarTitleColor,
                        unfocusedLabelColor = Color.Transparent,
                        disabledLabelColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent
                    ), value = text4, textStyle = TextStyle.Default.copy(
                        fontSize = 24.sp, textAlign = TextAlign.Center
                    ), onValueChange = {
                        text4 = it
                        if (text4.isNotEmpty()) {

                            focusRequester4.freeFocus()
                        }
                    }, modifier = Modifier
                        .focusRequester(focusRequester4)
                        .size(58.dp)
                        .border(
                            width = 1.dp,
                            color = Color(0xFFD7EBE9),
                            shape = RoundedCornerShape(8.dp)
                        )
                )
                Spacer(modifier = Modifier.width(12.dp))
            }
            Spacer(modifier = Modifier.height(300.dp))

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                val timerNum = remember { mutableStateOf(5) }
                val btnText =
                    if (timerNum.value <= 0) "получить код".uppercase() else "отправить повторно ${timerNum.value}".uppercase()

                CountdownTimerWithPause(timerNum, startFrom = 30)
                AuthorisationButton(
                    btnText = btnText,
                    isActiveColor = timerNum.value > 0,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
            }
        }
    }
}