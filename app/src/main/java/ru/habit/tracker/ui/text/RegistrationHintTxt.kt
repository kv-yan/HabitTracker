package ru.habit.tracker.ui.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

@Composable
fun RegistrationHintTxt(modifier: Modifier = Modifier) {
    Text(
        textAlign = TextAlign.Center, text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color(0xff767a79), fontSize = 10.sp
                )
            ) { append("Нажимая на кнопку «Зарегестрироваться» \nвы соглашаетесь на") }
            withStyle(
                style = SpanStyle(
                    color = Color(0xff272727), fontSize = 10.sp
                )
            ) { append(" ") }
            withStyle(
                style = SpanStyle(
                    color = Color(0xff272727), fontSize = 10.sp
                )
            ) { append("обработку персональных данных") }
        }, modifier = modifier
    )
}
