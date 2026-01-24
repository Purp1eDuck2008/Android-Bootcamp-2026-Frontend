package ru.sicampus.bootcamp2026.viewmodel

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

    fun OnRegLoginChange(login: String){
        _uiState.update { currentState ->
            currentState.copy(
                regLogin = login
            )
        }
    }

    fun OnRegPasswordChange(password: String){
        _uiState.update { currentState ->
            currentState.copy(
                regPassword = password
            )
        }
    }

    fun OnAuthLoginChange(login: String){
        _uiState.update { currentState ->
            currentState.copy(
                authLogin = login
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
}