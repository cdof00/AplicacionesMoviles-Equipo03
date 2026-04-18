package com.example.musicapp.ui.theme.dimension

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class IconSizeTokens(
    val xs: Dp,
    val sm: Dp,
    val md: Dp,
    val lg: Dp,
    val xl: Dp,
)

fun defaultIconSizeTokens(): IconSizeTokens = IconSizeTokens(
    xs = 16.dp,
    sm = 20.dp,
    md = 24.dp,
    lg = 28.dp,
    xl = 32.dp,
)
