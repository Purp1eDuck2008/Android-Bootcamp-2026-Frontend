package ru.sicampus.bootcamp2026.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import ru.sicampus.bootcamp2026.ui.LoginScreen
import ru.sicampus.bootcamp2026.ui.MainScreen

@Composable
fun RootNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavigationGraphs.LOGIN,
        route = NavigationGraphs.ROOT
    ) {
        navigation(
            route = NavigationGraphs.LOGIN,
            startDestination = LoginScreens.LOGIN_SCREEN
        ) {
            composable(LoginScreens.LOGIN_SCREEN) {
                LoginScreen(
                    onSuccessfulLogin = {
                        navController.navigate(NavigationGraphs.MAIN) {
                            popUpTo(NavigationGraphs.ROOT) {
                                inclusive = true
                            }
                        }
                    }
                )
            }
        }


        navigation(
            route = NavigationGraphs.MAIN,
            startDestination = MainScreens.MAIN_SCREEN
        ) {
            composable(MainScreens.MAIN_SCREEN) {
                MainScreen()
            }
        }
    }
}