package ru.sicampus.bootcamp2026.navigation

sealed class FirstScreenRoute(val route: String) {
    object Start : FirstScreenRoute("start")
    object Password : FirstScreenRoute("password")
    object Register: FirstScreenRoute("register")
}