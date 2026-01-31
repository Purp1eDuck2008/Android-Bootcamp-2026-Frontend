package ru.sicampus.bootcamp2026.model.uistate.loginscreen

data class LoginScreenUiState (
    val authLogin: String = "",
    val authPassword: String = "",
    val regLogin: String = "",
    val regPassword: String = "",
    val currentComposable: String = "login",
    //val isLoginEmail: Boolean = false
    val showLoginPassword: Boolean = false
)