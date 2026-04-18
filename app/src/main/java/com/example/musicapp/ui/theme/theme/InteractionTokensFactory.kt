package com.example.musicapp.ui.theme.theme

import androidx.compose.ui.graphics.Color
import com.example.musicapp.ui.theme.color.AppColors

fun interactionTokens(colors: AppColors): InteractionStateTokens = InteractionStateTokens(
    pressedOverlay = Color.White.copy(alpha = OpacityTokens.pressedOverlay),
    focusedBorder = colors.primary.copy(alpha = OpacityTokens.focusedRing),
    disabledOverlay = Color.White.copy(alpha = OpacityTokens.disabledContainer),
    selectedContainer = colors.primary.copy(alpha = 0.18f),
    selectedOnContainer = colors.primary,
)
