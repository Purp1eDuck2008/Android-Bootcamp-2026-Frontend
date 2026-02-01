package ru.sicampus.bootcamp2026.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource

private val DarkColorScheme = darkColorScheme(
    primary = Dark100,
    onPrimary = LightForDark,
    secondary = TextFieldForDark,
    onSecondary = Color(0xFF484848),
    onSecondaryContainer = Color(0xFF282828)

)

private val LightColorScheme = lightColorScheme(
    primary = Light100,
    onPrimary = DarkForLight,
    secondary = TextFieldForLight,
    onSecondary = Color(0xFFEDEDED),
    onSecondaryContainer = Color(0xFFC1C1C1),
)

@Composable
fun AndroidBootcamp2026FrontendTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}