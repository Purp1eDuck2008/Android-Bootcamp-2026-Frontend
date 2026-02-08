package ru.sicampus.bootcamp2026.ui.loginscreen.auth

sealed interface AuthState{
    object Loading: AuthState

    data class Data(
        val isValidEmail: Boolean,
        val isEnabledSend: Boolean,
        val error: String?
    ): AuthState
}


//data class LoginScreenState (
//    val authLogin: String = "",
//    val authPassword: String = "",
//    val isAuthEmailValid: Boolean = false,
//
//    val regName: String = "",
//    val regLogin: String = "",
//    val firstRegPassword: String = "",
//    val secondRegPassword: String = "",
//    val isRegEmailValid: Boolean = false,
//
//    val currentComposable: String = "login",
//
//    val showPassword: Boolean = false,
//
//    val isLoggedIn: Boolean = false
//)