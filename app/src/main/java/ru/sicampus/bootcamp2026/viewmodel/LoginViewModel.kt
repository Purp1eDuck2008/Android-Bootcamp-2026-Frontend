package ru.sicampus.bootcamp2026.viewmodel

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import ru.sicampus.bootcamp2026.data.userList
import ru.sicampus.bootcamp2026.model.uistate.loginscreen.LoginScreenState

class LoginViewModel : ViewModel(){
    private val _uiState = MutableStateFlow(LoginScreenState())
    val uiState: StateFlow<LoginScreenState> = _uiState.asStateFlow()

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

    fun OnLoginProceedButtonClick(){
        _uiState.update { uiState ->
            uiState.copy(
                currentComposable = "password"
            )
        }
    }

    fun OnLoginBackButtonClick(){
        ClearState()
        _uiState.update { uiState ->
            uiState.copy(
                currentComposable = "login"
            )
        }
    }



    fun TogglePasswordVidibility(){
        _uiState.update { uiState ->
            uiState.copy(
                showPassword = !_uiState.value.showPassword
            )
        }
    }

    fun OnRegisterClick(){
        _uiState.update { uiState ->
            uiState.copy(
                currentComposable = "registration"
            )
        }
    }

    fun OnNameValueChange(name: String){
        _uiState.update { uiState ->
            uiState.copy(
                regName = name
            )
        }
    }

    fun OnLoginValueChange(login: String){
        _uiState.update { uiState ->
            uiState.copy(
                regLogin = login
            )
        }
    }

    fun OnFirstRegPasswordChange(firstPassword: String){
        _uiState.update { uiState ->
            uiState.copy(
                firstRegPassword = firstPassword
            )
        }
    }

    fun OnSecondRegPasswordChange(secondPassword: String){
        _uiState.update { uiState ->
            uiState.copy(
                secondRegPassword = secondPassword
            )
        }
    }

    fun ValidateEmail(email: String): Boolean{
        if (email.isNotBlank() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return true
        }
        else{
            return false
        }
    }

    fun authenticateUser(): Boolean {
        val currentUserEmail = _uiState.value.authLogin
        val currentUserPassword = _uiState.value.authPassword

        val authenticatedUser = userList.find { user ->
            user.email == currentUserEmail && user.password == currentUserPassword
        }

        return authenticatedUser != null
    }

    fun OnLoginSuccess() {
        _uiState.update { uiState ->
            uiState.copy(
                isLoggedIn = true
            )
        }
    }

    private fun ClearState(){
        _uiState.update { uiState ->
            uiState.copy(
                authLogin = "",
                authPassword = "",

                regName = "",
                regLogin = "",
                firstRegPassword = "",
                secondRegPassword = "",
                isLoggedIn = false
            )

        }
    }

}