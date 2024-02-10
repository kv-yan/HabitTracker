package ru.habit.tracker.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
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
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.habit.tracker.MenuScreens
import ru.habit.tracker.R
import ru.habit.tracker.ui.screens.btnActiveColor
import ru.habit.tracker.ui.theme.actionBarTitleColor

@Composable
fun BottomActionBar(
    menuNavController: NavController,
) {

    Column(
        modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                IconButton(onClick = { menuNavController.navigate(MenuScreens.HOME_SCREEN.route) }) {
                    Image(
                        painter = painterResource(
                            id = if (DetectIsInCurrentNeededScreen(
                                    navController = menuNavController,
                                    rout = MenuScreens.HOME_SCREEN.route
                                )
                            ) R.drawable.ic_menu_home_active else R.drawable.ic_menu_home_passive
                        ), contentDescription = "home"
                    )
                }

                IconButton(onClick = { menuNavController.navigate(MenuScreens.CALENDAR_SCREEN.route) }) {
                    Icon(
                        painter = painterResource(
                            id = if (DetectIsInCurrentNeededScreen(
                                    navController = menuNavController,
                                    rout = MenuScreens.CALENDAR_SCREEN.route
                                )
                            ) R.drawable.ic_menu_calendar_active else R.drawable.ic_menu_calendar_passive
                        ), contentDescription = "calendar"
                    )
                }

                ExtendedFloatingActionButton(modifier = Modifier
                    .size(52.dp)
                    .offset(y = (-11).dp),
                    shape = CircleShape,
                    containerColor = if (DetectIsInCurrentNeededScreen(
                            navController = menuNavController,
                            rout = MenuScreens.ADD_NEW_HABIT.route
                        )
                    ) actionBarTitleColor else btnActiveColor,
                    onClick = { menuNavController.navigate(MenuScreens.ADD_NEW_HABIT.route) }) {

                    Icon(
                        imageVector = if (DetectIsInCurrentNeededScreen(
                                navController = menuNavController,
                                rout = MenuScreens.ADD_NEW_HABIT.route
                            )
                        ) Icons.Default.Check else Icons.Default.Add,
                        contentDescription = "Add",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }


                IconButton(onClick = { menuNavController.navigate(MenuScreens.LUMP_SCREEN.route) }) {
                    Icon(
                        painter = painterResource(
                            id = if (DetectIsInCurrentNeededScreen(
                                    navController = menuNavController,
                                    rout = MenuScreens.LUMP_SCREEN.route
                                )
                            ) R.drawable.ic_menu_lamp_active else R.drawable.ic_menu_lamp_passive
                        ),
                        contentDescription = "lamp"
                    )
                }


                IconButton(onClick = { menuNavController.navigate(MenuScreens.SETTINGS_SCREEN.route) }) {
                    Image(
                        painter = painterResource(
                            id = if (DetectIsInCurrentNeededScreen(
                                    navController = menuNavController,
                                    rout = MenuScreens.SETTINGS_SCREEN.route
                                )
                            ) R.drawable.ic_menu_settings_active else R.drawable.ic_menu_settings_passive
                        ),
                        contentDescription = "settings"
                    )
                }
            }

        }
    }
}

@Composable
fun DetectIsInCurrentNeededScreen(navController: NavController, rout: String): Boolean {
    return navController.currentBackStackEntryAsState().value?.destination?.route == rout
}