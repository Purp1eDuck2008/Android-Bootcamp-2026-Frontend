package ru.sicampus.bootcamp2026.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.runBlocking
import ru.sicampus.bootcamp2026.data.source.AuthLocalDataSource
import ru.sicampus.bootcamp2026.ui.loginscreen.auth.LoginScreen
import ru.sicampus.bootcamp2026.ui.mainscreen.MainScreen

@Composable
fun RootNavigation() {
    val navController = rememberNavController()
    val currentToken = runBlocking { AuthLocalDataSource.token }
    
    NavHost(
        navController = navController,
        startDestination = if(currentToken != null) { Graphs.MAIN.route } else { Graphs.AUTH.route},
        route = Graphs.ROOT.route
    ) {
        composable(route = Graphs.AUTH.route) {
            LoginScreen(
                onSuccessfulLogin = {
                    // Navigate to main graph and clear back stack to prevent back navigation
                    navController.navigate(Graphs.MAIN.route) {
                        popUpTo(Graphs.AUTH.route) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(route = Graphs.MAIN.route) {
            MainScreen()
        }
    }
}

sealed class Graphs(val route: String) {
    object ROOT: Graphs("ROOT")
    object AUTH: Graphs("AUTH")
    object MAIN: Graphs("MAIN")
}