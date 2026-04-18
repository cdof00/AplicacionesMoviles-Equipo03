package com.example.musicapp.ui.theme.color

import androidx.compose.ui.graphics.Color
import com.example.musicapp.ui.theme.theme.OpacityTokens

/**
 * Semantic colors for the app. All hex literals for the dark premium theme live in [darkAppColors].
 */
data class AppColors(
    val primary: Color,
    val onPrimary: Color,
    val secondary: Color,
    val onSecondary: Color,
    val tertiary: Color,
    val onTertiary: Color,
    val background: Color,
    val onBackground: Color,
    val surface: Color,
    val onSurface: Color,
    val surfaceVariant: Color,
    val onSurfaceVariant: Color,
    val surfaceContainerLow: Color,
    val surfaceContainer: Color,
    val surfaceContainerHigh: Color,
    val surfaceContainerHighest: Color,
    val outline: Color,
    val outlineVariant: Color,
    val outlineSubtle: Color,
    val outlineAccent: Color,
    val glassEdge: Color,
    val glassTint: Color,
    val error: Color,
    val onError: Color,
    /** Light elevated form fields on dark screens (e.g. New Release). */
    val inputElevated: Color,
    val onInputElevated: Color,
)

fun darkAppColors(): AppColors {
    val primary = Color(0xFFC8902A)
    val tertiary = Color(0xFFE8BB68)
    val secondary = Color(0xFF252525)
    val bg = Color(0xFF0A0A0A)
    val warmGray1 = Color(0xFF141210)
    val warmGray2 = Color(0xFF1C1A18)
    val warmGray3 = Color(0xFF2A2622)
    val warmGray4 = Color(0xFF38342E)
    val onDark = Color.White
    val muted = Color(0xFFB7B5B4)
    val outlineBase = Color(0xFF4A4238)

    return AppColors(
        primary = primary,
        onPrimary = Color(0xFF1A1206),
        secondary = secondary,
        onSecondary = onDark,
        tertiary = tertiary,
        onTertiary = Color(0xFF1A1206),
        background = bg,
        onBackground = onDark,
        surface = warmGray1,
        onSurface = onDark,
        surfaceVariant = warmGray3,
        onSurfaceVariant = muted,
        surfaceContainerLow = warmGray1,
        surfaceContainer = warmGray2,
        surfaceContainerHigh = warmGray3,
        surfaceContainerHighest = warmGray4,
        outline = outlineBase,
        outlineVariant = outlineBase.copy(alpha = OpacityTokens.borderSubtle),
        outlineSubtle = outlineBase.copy(alpha = OpacityTokens.borderSubtle),
        outlineAccent = primary.copy(alpha = OpacityTokens.borderStrong),
        glassEdge = Color.White.copy(alpha = OpacityTokens.glassEdge),
        glassTint = Color.White.copy(alpha = OpacityTokens.glassTint),
        error = Color(0xFFCF6679),
        onError = Color.Black,
        inputElevated = Color(0xFFF2F0EC),
        onInputElevated = Color(0xFF1C1A18),
    )
}

/** Stub for future light theme — not wired yet. */
fun lightAppColors(): AppColors = darkAppColors()
