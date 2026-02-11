package ru.sicampus.bootcamp2026.ui.loginscreen.auth

import android.content.res.Configuration
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.exclude
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.sicampus.bootcamp2026.navigation.FirstScreenRoute
import ru.sicampus.bootcamp2026.navigation.Graphs
import ru.sicampus.bootcamp2026.ui.loginscreen.subscreens.AuthorizationScreen
import ru.sicampus.bootcamp2026.ui.loginscreen.subscreens.StartScreen
import ru.sicampus.bootcamp2026.ui.loginscreen.subscreens.RegistrationScreen
import kotlin.math.log

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = viewModel(),
    onAuthSuccess: () -> Unit
) {
    val context = LocalContext.current
    val loginScreenState by loginViewModel.uiState.collectAsState()
    val currentstate = loginScreenState

    LaunchedEffect(Unit) {
        loginViewModel.actionFlow.collect { action ->
            when(action){
                is AuthAction.OpenScreen -> onAuthSuccess()
            }
        }
    }

    when(val currentState = loginScreenState){
        is AuthState.Loading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.Companion.linearGradient(
                            listOf(
                                MaterialTheme.colorScheme.surfaceContainerHigh,
                                MaterialTheme.colorScheme.surfaceContainerLow
                            )
                        )
                    ),
                contentAlignment = Alignment.Center
            ){
                CircularProgressIndicator(
                    modifier = Modifier.size(48.dp)
                )
            }
        }
        is AuthState.Data -> {
            DataScreenState(
                state = currentState, loginViewModel = loginViewModel,
            )
        }
    }

}

@Composable
fun DataScreenState(
    state: AuthState.Data,
    loginViewModel: LoginViewModel,
){
    val navController = rememberNavController()
    val focusManager = LocalFocusManager.current

    var loginValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }
    var showPassword by remember {  mutableStateOf(false) }

    val context = LocalContext.current

    Scaffold(
        contentWindowInsets = ScaffoldDefaults.contentWindowInsets.exclude(WindowInsets.statusBars)
    ){ paddingValues ->
        NavHost(
            modifier = Modifier.padding(paddingValues),
            navController = navController,
            startDestination = FirstScreenRoute.Start.route,
        ){
            composable(
                route = FirstScreenRoute.Start.route,
                exitTransition = {
                    slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Left,
                        tween(350)
                    )
                },
                popEnterTransition = {
                    slideIntoContainer(
                        towards = AnimatedContentTransitionScope.SlideDirection.Right,
                        animationSpec = tween(350)
                    )
                }
                ) {
                StartScreen(
                    OnLoginValueChange = {
                        loginValue = it
                        loginViewModel.onIntent(AuthIntent.EmailTextInput(loginValue))
                    },
                    OnProceedClick = {
                        navController.navigate(FirstScreenRoute.Password.route){
                            launchSingleTop = true
                        }
                    },
                    loginValue = loginValue,
                    validateEmail = state.isValidEmail ,
                    OnRegisterClick = {
                        navController.navigate(FirstScreenRoute.Register.route){
                            launchSingleTop = true
                        }
                    },
                    onOAuthClick = { Toast.makeText(context, "Not implemented yet :(", Toast.LENGTH_SHORT).show() }
                )
            }

            composable(
                route = FirstScreenRoute.Password.route,
                enterTransition = {
                    slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Left,
                        tween(350)
                    )
                },
                popExitTransition = {
                    slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Right,
                        tween(350)
                    )
                }
            ){
                AuthorizationScreen(
                    enteredEmail = loginValue,
                    OnBackButtonClick = {
                        navController.navigateUp()
                    },
                    showPassword = showPassword,
                    ShowPasswordToggle = { showPassword = !showPassword },
                    onProceedClick = {
                        loginViewModel.onIntent(AuthIntent.Send(loginValue, passwordValue))
                    },
                    OnPasswordValueChange = {
                        passwordValue = it
                        loginViewModel.onIntent(AuthIntent.PasswordTextInput(passwordValue))
                    },
                    passwordValue = passwordValue,
                    isEnabledSend = state.isEnabledSend,
                    isError = state.error != null,
                    error = state.error
                )
            }

            composable(
                route = FirstScreenRoute.Register.route,
                enterTransition = {
                    slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Left,
                        tween(350)
                    )
                },
                popExitTransition = {
                    slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Right,
                        tween(350)
                    )
                }
            ){
                RegistrationScreen(
                    OnBackButtonClick = {
                        navController.navigateUp()
                    },
                    nameValue = "",
                    OnNameValueChange = {  },
                    loginValue = "",
                    OnLoginValueChange = {  },
                    firstPasswordValue = "",
                    OnFirstPasswordChange = {  },
                    secondPasswordValue = "",
                    OnSecondPasswordChange = {  },
                    showPassword = false,
                    ShowPasswordToggle = {  },
                    validateEmail = false,
                    FocusDown = {  }
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
    LoginScreen(
        onAuthSuccess = {}
    )
}