package ru.sicampus.bootcamp2026.model.uistate.loginscreen

data class LoginScreenState (
    val authLogin: String = "",
    val authPassword: String = "",
    val isAuthEmailValid: Boolean = false,

    val regName: String = "",
    val regLogin: String = "",
    val firstRegPassword: String = "",
    val secondRegPassword: String = "",
    val isRegEmailValid: Boolean = false,

    val currentComposable: String = "login",

    val showPassword: Boolean = false,

    val isLoggedIn: Boolean = false
)