package ru.sicampus.bootcamp2026.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationItem(val route: String, val icon: ImageVector, val title: String) {
    object Home : BottomNavigationItem("home", Icons.Default.Home, "Home")
    object Profile : BottomNavigationItem("profile", Icons.Default.Person, "Profile")
    object Settings : BottomNavigationItem("invites", Icons.Default.Email, "invites")
}