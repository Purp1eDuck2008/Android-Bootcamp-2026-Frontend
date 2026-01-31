package ru.sicampus.bootcamp2026.ui

import android.util.Patterns
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.sicampus.bootcamp2026.viewmodel.LoginViewModel
import ru.sicampus.bootcamp2026.ui.loginscreen.AuthorizationScreen
import ru.sicampus.bootcamp2026.ui.loginscreen.StartScreen


@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = viewModel()
) {
    val loginScreenState by loginViewModel.uiState.collectAsState()
    val isEmailValid = loginScreenState.authLogin.isNotBlank() && Patterns.EMAIL_ADDRESS.matcher(loginScreenState.authLogin).matches()

    BackHandler(
        enabled = loginScreenState.currentComposable == "password"
    ) {
        loginViewModel.OnLoginBackButtonClick()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF5B22BF),
                        Color(0xFF7624AA)
                    )
                )
            )
            .imePadding(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        when (loginScreenState.currentComposable) {
            "login" -> {
                StartScreen(
                    OnLoginValueChange = { loginViewModel.OnAuthLoginChange(it) },
                    loginValue = loginScreenState.authLogin,
                    validateEmail = isEmailValid,
                    OnProceedClick = { loginViewModel.OnLoginProceedButtonClick() }
                )
            }

            "password" -> {
                AuthorizationScreen(
                    enteredEmail = loginScreenState.authLogin,
                    OnBackButtonClick = { loginViewModel.OnLoginBackButtonClick() },
                    OnPasswordValueChange = { loginViewModel.OnAuthPasswordChange(it) },
                    passwordValue = loginScreenState.authPassword,
                    ShowPasswordToggle = { loginViewModel.ToggleLoginPasswordVidibility() },
                    showPassword = loginScreenState.showLoginPassword
                )
            }
        }
    }
}

