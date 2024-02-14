package ru.habit.tracker.ui.text

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.habit.tracker.R
import ru.habit.tracker.ui.screens.btnActiveColor
import ru.habit.tracker.ui.theme.actionBarTitleColor


@Preview
@Composable
fun PrevTextField() {
    Surface(modifier = Modifier.fillMaxSize()) {
        LoginTextFields(hintName = "")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginTextFields(
    hintName: String,
    text: MutableState<TextFieldValue> =  mutableStateOf(TextFieldValue(""))

) {
    TextField(value = text.value, textStyle = TextStyle.Default.copy(fontSize = 14.sp), trailingIcon = {
        if (text.value.text.isEmpty()) null else {
            Icon(painter = painterResource(id = R.drawable.ic_remove_field_text),
                contentDescription = null,
                tint = btnActiveColor,
                modifier = Modifier.clickable {
                    text.value = text.value.copy(text = "")
                })
        }
    }, onValueChange = {
        text.value = it
    }, placeholder = {
        Text(
            text = hintName,
            color = Color(0xFFD7EBE9),
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 8.dp)
        )
    }, colors = TextFieldDefaults.textFieldColors(
        textColor = actionBarTitleColor,
        containerColor = Color.Transparent,
        focusedLabelColor = Color.Transparent,
        unfocusedLabelColor = Color.Transparent,
        disabledLabelColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        focusedIndicatorColor = Color.Transparent
    ), modifier = Modifier
        .fillMaxWidth()
        .background(Color.White)
        .border(
            width = 1.dp, color = Color(0xFFD7EBE9), shape = RoundedCornerShape(8.dp)
        )
    )
}