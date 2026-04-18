package com.example.musicapp.ui.theme.theme

import androidx.compose.ui.graphics.Color

/**
 * Semantic overlays for interaction; combine with [OpacityTokens] and base colors.
 */
data class InteractionStateTokens(
    val pressedOverlay: Color,
    val focusedBorder: Color,
    val disabledOverlay: Color,
    val selectedContainer: Color,
    val selectedOnContainer: Color,
)
