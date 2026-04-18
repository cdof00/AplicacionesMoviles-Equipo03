package com.example.musicapp.ui.theme.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import com.example.musicapp.ui.theme.color.AppColors

fun appColorsToMaterialColorScheme(c: AppColors): ColorScheme = darkColorScheme(
    primary = c.primary,
    onPrimary = c.onPrimary,
    primaryContainer = c.tertiary.copy(alpha = 0.35f),
    onPrimaryContainer = c.onPrimary,
    secondary = c.secondary,
    onSecondary = c.onSecondary,
    tertiary = c.tertiary,
    onTertiary = c.onTertiary,
    background = c.background,
    onBackground = c.onBackground,
    surface = c.surface,
    onSurface = c.onSurface,
    surfaceVariant = c.surfaceVariant,
    onSurfaceVariant = c.onSurfaceVariant,
    surfaceDim = c.background,
    surfaceBright = c.surfaceContainer,
    surfaceContainerLowest = c.surfaceContainerLow,
    surfaceContainerLow = c.surfaceContainerLow,
    surfaceContainer = c.surfaceContainer,
    surfaceContainerHigh = c.surfaceContainerHigh,
    surfaceContainerHighest = c.surfaceContainerHighest,
    outline = c.outline,
    outlineVariant = c.outlineVariant,
    error = c.error,
    onError = c.onError,
)
