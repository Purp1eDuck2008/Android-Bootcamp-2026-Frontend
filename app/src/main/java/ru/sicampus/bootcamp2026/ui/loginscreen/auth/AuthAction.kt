package ru.sicampus.bootcamp2026.ui.loginscreen.auth

sealed interface AuthAction {
    data class OpenScreen(val route: String): AuthAction
}