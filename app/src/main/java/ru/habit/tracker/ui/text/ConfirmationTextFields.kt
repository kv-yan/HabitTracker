package ru.habit.tracker.ui.text


import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun ConfirmatioTextField() {

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfirmationTextFields(
    text: MutableState<TextFieldValue>,
    focusRequester: FocusRequester,
    action: (String) -> Unit,
) {

    /*
        TextField(
            value = text.value,
            textStyle = TextStyle.Default.copy(fontSize = 24.sp, textAlign = TextAlign.Center),
            onValueChange = {
                action(it.text)
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor = actionBarTitleColor,
                containerColor = Color.Transparent,
                focusedLabelColor = actionBarTitleColor,
                unfocusedLabelColor = Color.Transparent,
                disabledLabelColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .size(58.dp)
                .background(Color.White)
                .focusRequester(focusRequester)
                .border(
                    width = 1.dp, color = Color(0xFFD7EBE9), shape = RoundedCornerShape(8.dp)
                )
        )
    */
    TextField(
        value = text.value, textStyle = TextStyle(color = Color.Black), onValueChange = {
            action(it.text)
        }, modifier = Modifier
            .focusRequester(focusRequester)
            .width(40.dp)
    )

}




