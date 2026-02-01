package ru.sicampus.bootcamp2026.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import ru.sicampus.bootcamp2026.R

sealed class NavigationItem(val route: String, val icon: ImageVector, val title: String) {
    object Home : NavigationItem("home", Icons.Default.Home, "Home")
    object Profile : NavigationItem("profile", Icons.Default.Person, "Profile")
    object Settings : NavigationItem("settings", Icons.Default.Settings, "Settings")
}