
package com.fazra.coetus.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

// Light theme: warm cream background
private val lightScheme = lightColorScheme(
    primary = AirForceBlue,
    onPrimary = CoetusWhite,
    primaryContainer = Color(0xFFD5E9ED),
    onPrimaryContainer = Color(0xFF193B45),

    secondary = SkyBlue,
    onSecondary = Color(0xFF17343B),
    secondaryContainer = Color(0xFFC8EAF0),
    onSecondaryContainer = Color(0xFF183D45),

    tertiary = ToffeeBrown,
    onTertiary = CoetusWhite,
    tertiaryContainer = Color(0xFFEBD2C1),
    onTertiaryContainer = Color(0xFF38251D),

    error = Color(0xFFBA1A1A),
    onError = CoetusWhite,

    background = AntiqueWhite,
    onBackground = CoetusBlack,

    surface = Color(0xFFFFF3E8),
    onSurface = CoetusBlack,
    surfaceVariant = Color(0xFFF0DDCC),
    onSurfaceVariant = Color(0xFF51443D),

    outline = Color(0xFF82736A),
    outlineVariant = Color(0xFFD4BFAE),

    inverseSurface = Color(0xFF30251F),
    inverseOnSurface = AntiqueWhite,
    inversePrimary = Color(0xFF9CCBD8)
)

// Dark theme: deep blue-grey background
private val darkScheme = darkColorScheme(
    primary = Color(0xFF8CC9D9),
    onPrimary = Color(0xFF18333B),
    primaryContainer = Color(0xFF365F6D),
    onPrimaryContainer = Color(0xFFD5F1F4),

    secondary = SkyBlue,
    onSecondary = Color(0xFF102B32),
    secondaryContainer = Color(0xFF345E68),
    onSecondaryContainer = Color(0xFFD5F1F4),

    tertiary = Color(0xFFD0A58E),
    onTertiary = Color(0xFF35231B),
    tertiaryContainer = Color(0xFF624737),
    onTertiaryContainer = Color(0xFFF1D8C8),

    error = Color(0xFFFFB4AB),
    onError = Color(0xFF690005),

    background = Color(0xFF172329),
    onBackground = Color(0xFFF4E9DF),

    surface = Color(0xFF26343A),
    onSurface = Color(0xFFF4E9DF),
    surfaceVariant = Color(0xFF40535A),
    onSurfaceVariant = Color(0xFFD0DDE0),

    outline = Color(0xFF899DA3),
    outlineVariant = Color(0xFF52656C),

    inverseSurface = AntiqueWhite,
    inverseOnSurface = CoetusBlack,
    inversePrimary = AirForceBlue
)

@Composable
fun CoetusTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val context = LocalContext.current

    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            if (darkTheme) {
                dynamicDarkColorScheme(context)
            } else {
                dynamicLightColorScheme(context)
            }
        }

        darkTheme -> darkScheme
        else -> lightScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}
