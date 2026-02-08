package ru.sicampus.bootcamp2026.ui.loginscreen.auth

sealed interface AuthIntent {
    data class Send(val login: String, val password: String): AuthIntent
    data class EmailTextInput(val email: String): AuthIntent

    data class PasswordTextInput(val password: String): AuthIntent
}