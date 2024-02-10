package ru.habit.tracker.ui.screens.menu

import ru.habit.tracker.utils.MainColumnItem
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import ru.habit.tracker.R
import ru.habit.tracker.ui.HabitItem
import ru.habit.tracker.ui.screens.btnActiveColor
import ru.habit.tracker.ui.text.ActionBarTitle
import ru.habit.tracker.utils.AnimatedCircularProgressIndicator


@Composable
fun HomeScreen() {
    SetActionBarColor(btnActiveColor)

    val habitItems = remember {
        mutableListOf(
            HabitItem("Утренний бег", mutableStateOf(true), R.drawable.ic_icon_1),
            HabitItem("Нет вредной еде", mutableStateOf(false), R.drawable.ic_icon_2),
            HabitItem("Отдых от смартфона", mutableStateOf(false), R.drawable.ic_icon_3),
            HabitItem("Учиться новому", mutableStateOf(false), R.drawable.ic_icon_4),
        )
    }


    Surface(modifier = Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize()) {

            Surface(Modifier.fillMaxWidth(), color = btnActiveColor) {
                Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 9.dp)) {
                    ActionBarTitle(
                        titleText = "Цель на сегодня", modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    ScreenHeader()

                }
            }

            LazyColumn() {
                items(habitItems) {
                    MainColumnItem(modifier = Modifier.fillMaxWidth(), it)
                }
            }

        }
    }
}

@Preview
@Composable
fun HomePrev() {
    HomeScreen()
}

@Composable
fun SetActionBarColor(color: Color) {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()

    DisposableEffect(systemUiController, useDarkIcons) {
        systemUiController.setSystemBarsColor(
            color = color, darkIcons = true
        )

        onDispose {}
    }
}

@Composable
private fun ScreenHeader() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 35.dp, vertical = 8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_main_screen_header),
            contentDescription = null
        )

        Spacer(modifier = Modifier.width(28.dp))

        Column() {
            Spacer(modifier = Modifier.height(15.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Spacer(modifier = Modifier.width(3.dp))
                AnimatedCircularProgressIndicator(
                    currentValue = 75,
                    maxValue = 100,
                    progressBackgroundColor = Color.White,
                    progressIndicatorColor = Color.Black,
                    completedColor = Color.Black,
                    modifier = Modifier.size(45.dp)
                )
                Text(
                    text = "75%",
                    color = Color(0xff272727),
                    textAlign = TextAlign.End,
                    style = TextStyle(
                        fontSize = 24.sp, fontWeight = FontWeight.Bold, letterSpacing = 4.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 6.dp)
                )
            }
            Spacer(modifier = Modifier.height(14.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Привычки:",
                    color = Color(0xff272727),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 12.sp, letterSpacing = (-0.5).sp
                    )
                )
                Text(
                    text = "4",
                    color = Color(0xff272727),
                    textAlign = TextAlign.End,
                    style = TextStyle(
                        fontSize = 12.sp, letterSpacing = (-0.5).sp
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(6.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Осталось дней:",
                    color = Color(0xff272727),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 12.sp, letterSpacing = (-0.5).sp
                    )
                )
                Text(
                    text = "15",
                    color = Color(0xff272727),
                    textAlign = TextAlign.End,
                    style = TextStyle(
                        fontSize = 12.sp, letterSpacing = (-0.5).sp
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }

        }
    }

}