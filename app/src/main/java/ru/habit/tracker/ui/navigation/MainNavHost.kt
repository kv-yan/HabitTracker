package ru.habit.tracker.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.habit.tracker.ui.Screens
import ru.habit.tracker.ui.screens.ChangePasswordScreen
import ru.habit.tracker.ui.screens.ConfirmationsScreen
import ru.habit.tracker.ui.screens.LoginScreen
import ru.habit.tracker.ui.screens.MainContainerScreen
import ru.habit.tracker.ui.screens.RecoveryScreen
import ru.habit.tracker.ui.screens.RegistrationScreen

@Composable
fun MainNavHost() {
    val mainNavController = rememberNavController()

    val enterTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?)? =
        {
            fadeIn(
                animationSpec = tween(
                    700, easing = LinearEasing
                )
            ) + slideIntoContainer(
                animationSpec = tween(400, easing = EaseIn),
                towards = AnimatedContentTransitionScope.SlideDirection.Start
            )
        }


    NavHost(navController = mainNavController, startDestination = Screens.MAIN.route) {
        composable(Screens.LOGIN.route, enterTransition = enterTransition) {
            LoginScreen(
                mainNavController
            )
        }

        composable(
            Screens.REGISTRATION.route, enterTransition = enterTransition
        ) {
            RegistrationScreen(mainNavController)
        }

        composable(Screens.RECOVERY.route, enterTransition = enterTransition) {
            RecoveryScreen(
                mainNavController
            )
        }

        composable(Screens.MAIN.route, enterTransition = enterTransition) {
            MainContainerScreen()
        }

        composable(
            Screens.NEW_PASSWORD_SCREEN.route, enterTransition = enterTransition
        ) { ChangePasswordScreen(mainNavController) }

        composable(
            Screens.CONFIRMATION_SCREEN.route, enterTransition = enterTransition
        ) { ConfirmationsScreen(mainNavController) }

    }
}
