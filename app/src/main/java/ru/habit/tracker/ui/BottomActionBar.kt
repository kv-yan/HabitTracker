package ru.habit.tracker.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.habit.tracker.R
import ru.habit.tracker.ui.screens.btnActiveColor

@Composable
fun BottomActionBar(menuNavController: NavController) {
    Column(
        Modifier.fillMaxWidth()
    ) {
        Row(
            Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
        ) {
            ExtendedFloatingActionButton(modifier = Modifier
                .size(52.dp)
                .offset(y = (40).dp),
                shape = CircleShape,
                containerColor = btnActiveColor,
                onClick = { menuNavController.navigate(MenuScreens.ADD_NEW_HABIT.route) }) {

                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            IconButton(onClick = {  menuNavController.navigate(MenuScreens.HOME_SCREEN.route)}) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_menu_home_active),
                    contentDescription = "home",
                    tint = Color(0xff272727)
                )

            }

            IconButton(onClick = { menuNavController.navigate(MenuScreens.CALENDAR_SCREEN.route) }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_menu_calendar_passive),
                    contentDescription = "calendar",
                    tint = Color(0xff272727)
                )
            }

            Spacer(modifier = Modifier.size(52.dp))

            IconButton(onClick = { menuNavController.navigate(MenuScreens.LUMP_SCREEN.route) }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_menu_lamp_passive),
                    contentDescription = "lamp"
                )
            }


            IconButton(onClick = { menuNavController.navigate(MenuScreens.SETTINGS_SCREEN.route) }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_menu_settings_passive),
                    contentDescription = "settings"
                )
            }
        }
    }
}