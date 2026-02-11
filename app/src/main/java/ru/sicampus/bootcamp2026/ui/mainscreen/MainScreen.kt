package ru.sicampus.bootcamp2026.ui.mainscreen

import android.app.Activity
import android.content.res.Configuration
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import ru.sicampus.bootcamp2026.navigation.BottomNavigationItem
import ru.sicampus.bootcamp2026.ui.mainscreen.components.subscreens.HomeScreen
import ru.sicampus.bootcamp2026.ui.mainscreen.components.subscreens.InvitesScreen
import ru.sicampus.bootcamp2026.ui.mainscreen.components.subscreens.NewTask
import ru.sicampus.bootcamp2026.ui.mainscreen.components.subscreens.ProfileScreen
import ru.sicampus.bootcamp2026.ui.theme.AndroidBootcamp2026FrontendTheme

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val colorScheme = MaterialTheme.colorScheme
    var shouldExit by remember { mutableStateOf(false) }
    val context = LocalContext.current

    if (shouldExit) {
        LaunchedEffect(Unit) {
            delay(2000)
            shouldExit = false
        }
    }

    BackHandler(enabled = true) {
        if (navController.currentBackStackEntry?.destination?.route != BottomNavigationItem.Home.route) {
            navController.navigate(BottomNavigationItem.Home.route) {
                popUpTo(navController.graph.findStartDestination().id) { inclusive = true }
                launchSingleTop = true
            }
        } else {
            if (shouldExit) {
                (context as? Activity)?.finish()
            } else {
                shouldExit = true
                Toast.makeText(context, "Нажмите еще раз, чтобы выйти", Toast.LENGTH_SHORT).show()
            }
        }
    }

    val items = listOf(
        BottomNavigationItem.Profile,
        BottomNavigationItem.Home,
        BottomNavigationItem.Invites
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
                modifier = Modifier.Companion.offset(y = 1.dp)
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
                                    modifier = Modifier.Companion.size(28.dp),
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
            startDestination = BottomNavigationItem.Home.route,
            modifier = Modifier.Companion.padding(paddingValues)
        ) {
            composable(BottomNavigationItem.Home.route) {
                HomeScreen(
                    onFabClick = {
                        navController.navigate("NewTask"){
                            launchSingleTop = true
                        }
                    }
                )
            }
            composable(BottomNavigationItem.Profile.route) { ProfileScreen() }
            composable(BottomNavigationItem.Invites.route) { InvitesScreen() }
            composable("NewTask") {
                NewTask(
                    onBackButtonClick = { navController.navigateUp() }
                )
            }
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