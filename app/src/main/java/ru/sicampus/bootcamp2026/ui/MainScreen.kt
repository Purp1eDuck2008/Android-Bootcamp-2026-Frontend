package ru.sicampus.bootcamp2026.ui

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.*
import ru.sicampus.bootcamp2026.navigation.NavigationItem
import ru.sicampus.bootcamp2026.ui.mainscreen.HomeScreen
import ru.sicampus.bootcamp2026.ui.mainscreen.ProfileScreen
import ru.sicampus.bootcamp2026.ui.mainscreen.SettingsScreen
import ru.sicampus.bootcamp2026.ui.theme.AndroidBootcamp2026FrontendTheme

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val colorScheme = MaterialTheme.colorScheme

    val items = listOf(
        NavigationItem.Profile,
        NavigationItem.Home,
        NavigationItem.Settings
    )

    Scaffold(
        bottomBar = {
            Surface(
                shape = RoundedCornerShape(
                    topStart = 24.dp,
                    topEnd = 24.dp,
                    bottomStart = 0.dp,
                    bottomEnd = 0.dp
                ),
                border = BorderStroke(
                    width = 1.dp,
                    color = colorScheme.secondary.copy(alpha = 0.7f)
                ),
                modifier = Modifier.offset(y = 1.dp)
            ) {
            NavigationBar(
                containerColor = colorScheme.primary
            ) {
                items.forEach { item ->
                    val isSelected = currentRoute(navController) == item.route

                    NavigationBarItem(
                        selected = isSelected,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(
                                modifier = Modifier.size(28.dp),
                                imageVector = item.icon,
                                contentDescription = item.title
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = colorScheme.onPrimary,
                            selectedTextColor = colorScheme.onPrimary,
                            unselectedIconColor = colorScheme.onPrimary.copy(alpha = 0.7f),
                            unselectedTextColor = colorScheme.onPrimary.copy(alpha = 0.7f),
                            indicatorColor = colorScheme.primary
                        )
                    )
                    }
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = NavigationItem.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(NavigationItem.Home.route) { HomeScreen() }
            composable(NavigationItem.Profile.route) { ProfileScreen() }
            composable(NavigationItem.Settings.route) { SettingsScreen() }
        }
    }
}

@Composable
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PreviewMainScreen() {
    AndroidBootcamp2026FrontendTheme() {
        MainScreen()
    }
}
