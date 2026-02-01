package ru.sicampus.bootcamp2026.ui

import android.content.res.Configuration
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.sicampus.bootcamp2026.viewmodel.LoginViewModel
import ru.sicampus.bootcamp2026.ui.loginscreen.AuthorizationScreen
import ru.sicampus.bootcamp2026.ui.loginscreen.RegistrationScreen
import ru.sicampus.bootcamp2026.ui.loginscreen.StartScreen


@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = viewModel(),
    onSuccessfulLogin: () -> Unit = {}
) {
    val loginScreenState by loginViewModel.uiState.collectAsState()
    val focusManager = LocalFocusManager.current

    // Проверяем, успешно ли вошел пользователь, и вызываем коллбэк
    if (loginScreenState.isLoggedIn) {
        onSuccessfulLogin()
        return
    }

    BackHandler(
        enabled = loginScreenState.currentComposable == "password" || loginScreenState.currentComposable == "registration"
    ) {
        loginViewModel.OnLoginBackButtonClick()
    }


    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.primary)
            .fillMaxSize()
            .imePadding()
            .background(
                Brush.linearGradient(
                    listOf(Color(0xFF5B22BF),
                        Color(0xFF7624AA)
                    )
                )
            ),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (loginScreenState.currentComposable) {
            "login" -> {
                StartScreen(
                    OnLoginValueChange = { loginViewModel.OnAuthLoginChange(it) },
                    loginValue = loginScreenState.authLogin,
                    validateEmail = loginViewModel.ValidateEmail(loginScreenState.authLogin),
                    OnProceedClick = { loginViewModel.OnLoginProceedButtonClick() },
                    OnRegisterClick = { loginViewModel.OnRegisterClick() }
                )
            }

            "password" -> {
                AuthorizationScreen(
                    enteredEmail = loginScreenState.authLogin,
                    OnBackButtonClick = { loginViewModel.OnLoginBackButtonClick() },
                    OnPasswordValueChange = { loginViewModel.OnAuthPasswordChange(it) },
                    passwordValue = loginScreenState.authPassword,
                    ShowPasswordToggle = { loginViewModel.TogglePasswordVidibility() },
                    showPassword = loginScreenState.showPassword,
                    onProceedClick = {
                        if (loginViewModel.authenticateUser()) {
                            loginViewModel.OnLoginSuccess()
                        }
                    }
                )
            }

            "registration" -> {
                RegistrationScreen(
                    OnBackButtonClick = { loginViewModel.OnLoginBackButtonClick() },
                    nameValue = loginScreenState.regName,
                    OnNameValueChange = { loginViewModel.OnNameValueChange(it) },
                    loginValue = loginScreenState.regLogin,
                    OnLoginValueChange = { loginViewModel.OnLoginValueChange(it) },
                    firstPasswordValue = loginScreenState.firstRegPassword,
                    OnFirstPasswordChange = { loginViewModel.OnFirstRegPasswordChange(it) },
                    secondPasswordValue = loginScreenState.secondRegPassword,
                    OnSecondPasswordChange = { loginViewModel.OnSecondRegPasswordChange(it) },
                    showPassword = loginScreenState.showPassword,
                    ShowPasswordToggle = { loginViewModel.TogglePasswordVidibility() },
                    validateEmail = loginViewModel.ValidateEmail(loginScreenState.regLogin),
                    FocusDown = { focusManager.moveFocus(FocusDirection.Down) }
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun LoginScreenPreview(){
    LoginScreen()
}

