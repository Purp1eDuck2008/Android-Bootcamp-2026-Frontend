package ru.sicampus.bootcamp2026.viewmodel

import android.util.Patterns
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import ru.sicampus.bootcamp2026.model.uistate.loginscreen.LoginScreenUiState

class LoginViewModel : ViewModel(){
    private val _uiState = MutableStateFlow(LoginScreenUiState())
    val uiState: StateFlow<LoginScreenUiState> = _uiState.asStateFlow()

    fun OnAuthLoginChange(login: String){
        _uiState.update { currentState ->
            currentState.copy(
                authLogin = login
            )
        }
    }

    fun OnLoginProceedButtonClick(){
        _uiState.update { uiState ->
            uiState.copy(
                currentComposable = "password"
            )
        }
    }

    fun OnLoginBackButtonClick(){
        _uiState.update { uiState ->
            uiState.copy(
                currentComposable = "login"
            )
        }
    }

    fun OnAuthPasswordChange(password: String){
        _uiState.update { currentState ->
            currentState.copy(
                authPassword = password
            )
        }
    }

    fun ToggleLoginPasswordVidibility(){
        _uiState.update { uiState ->
            uiState.copy(
                showLoginPassword = !_uiState.value.showLoginPassword
            )
        }
    }

}