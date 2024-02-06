package ru.habit.tracker.ui.screens.menu


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
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.habit.tracker.R
import ru.habit.tracker.ui.text.MenuTopBarTitle
import ru.habit.tracker.ui.text.SettingItemText
import ru.habit.tracker.utils.AppSwitcher


@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 14.dp)
    ) {
        MenuTopBarTitle(Modifier, "Настройки")
        Spacer(modifier = Modifier.height(15.dp))

        Surface(shape = RoundedCornerShape(28.dp), shadowElevation = 2.dp) {
            Column(
                Modifier
                    .padding(horizontal = 12.dp, vertical = 20.dp)
                    .fillMaxWidth()
            ) {

                SettingsItem(icon = R.drawable.ic_language, text = "Язык") {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier

                    ) {
                        Text(
                            text = "Русский",
                            color = Color(0xffb7b9b9),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 16.sp, fontWeight = FontWeight.Medium
                            )
                        )

                        Icon(
                            painter = painterResource(id = R.drawable.in_open_settings),
                            contentDescription = "arrow",
                            tint = Color(0xff89ccc5),
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))
                SettingsItem(icon = R.drawable.ic_notification, text = "Уведомления") {
                    AppSwitcher(defValue = true)
                }
                Spacer(modifier = Modifier.height(24.dp))

                SettingsItem(icon = R.drawable.ic_privacy, text = "Приватность") {
                    Icon(
                        painter = painterResource(id = R.drawable.in_open_settings),
                        contentDescription = "arrow",
                        tint = Color(0xff89ccc5),
                        modifier = Modifier.size(24.dp)
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))


                SettingsItem(icon = R.drawable.ic_theme, text = "Тёмная тема") {
                    AppSwitcher(defValue = false)
                }


            }
        }
    }
}

@Preview
@Composable
fun SettingsPrev() {
    SettingsScreen()
}


@Composable
fun SettingsItem(
    icon: Int,
    text: String,
    modifier: Modifier = Modifier,
    settingAdditionalEndWidget: @Composable () -> Unit = {},
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Row(modifier = Modifier.fillMaxWidth(0.5f)) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "",
                tint = Color(0xff89ccc5)
            )
            Spacer(modifier = Modifier.width(16.dp))
            SettingItemText(text = text)
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth()
        ) {
            settingAdditionalEndWidget.invoke()
        }
    }
}