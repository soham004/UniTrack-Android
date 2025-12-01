package com.soham.classplan.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val ClassPlanColorScheme = darkColorScheme(
    primary = AccentPrimary,
    onPrimary = TextPrimary,
    secondary = AccentSecondary,
    onSecondary = TextPrimary,
    tertiary = AccentSuccess,
    background = NightSurface,
    onBackground = TextPrimary,
    surface = NightSurfaceVariant,
    onSurface = TextPrimary,
    surfaceVariant = NightSurfaceHighlight,
    onSurfaceVariant = TextSecondary,
    outline = AccentPrimary.copy(alpha = 0.6f)
)

@Composable
fun ClassPlanTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = ClassPlanColorScheme,
        typography = Typography,
        content = content
    )
}