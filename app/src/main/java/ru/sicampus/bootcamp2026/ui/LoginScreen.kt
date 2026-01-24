package ru.sicampus.bootcamp2026.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import ru.sicampus.bootcamp2026.ui.loginscreen.StartScreen
import ru.sicampus.bootcamp2026.viewmodel.LoginViewModel
import androidx.navigation.compose.composable
import ru.sicampus.bootcamp2026.ui.loginscreen.AuthorizationScreen
import ru.sicampus.bootcamp2026.ui.loginscreen.RegistrationScreen

enum class LoginScreenRoutes() {
    Start,
    Register,
    Login
}

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        val loginScreenState by loginViewModel.uiState.collectAsState()
        NavHost(
            navController = navController,
            startDestination = LoginScreenRoutes.Start.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = LoginScreenRoutes.Start.name){
                StartScreen(
                    OnRegisterClick = {
                        navController.navigate(LoginScreenRoutes.Register.name)
                    },
                    OnLoginClick = {
                        navController.navigate(LoginScreenRoutes.Login.name)
                    }
                )
            }

            composable(route = LoginScreenRoutes.Register.name){
                RegistrationScreen(
                    loginValue = loginScreenState.regLogin,
                    passwordValue = loginScreenState.regPassword,
                    OnLoginChange = { loginViewModel.OnRegLoginChange(it) },
                    OnPasswordChange = { loginViewModel.OnRegPasswordChange(it) },
                    OnloginClick = {
                        navController.popBackStack(route = LoginScreenRoutes.Start.name, inclusive = false)
                        navController.navigate(LoginScreenRoutes.Login.name)
                    }
                )
            }

            composable(route = LoginScreenRoutes.Login.name){
                AuthorizationScreen(
                    loginValue = loginScreenState.authLogin,
                    passwordValue = loginScreenState.authPassword,
                    OnLoginChange = { loginViewModel.OnAuthLoginChange(it) },
                    OnPasswordChange = { loginViewModel.OnAuthPasswordChange(it) },
                    OnRegisterClick = {
                        navController.popBackStack(route = LoginScreenRoutes.Start.name, inclusive = false)
                        navController.navigate(LoginScreenRoutes.Register.name)
                    }
                )
            }
        }
    }
}