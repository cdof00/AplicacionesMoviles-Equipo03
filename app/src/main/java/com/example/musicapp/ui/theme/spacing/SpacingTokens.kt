package com.example.musicapp.ui.theme.spacing

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class SpacingTokens(
    val xxs: Dp,
    val xs: Dp,
    val sm: Dp,
    val md: Dp,
    val lg: Dp,
    val xl: Dp,
    val xxl: Dp,
)

fun defaultSpacingTokens(): SpacingTokens = SpacingTokens(
    xxs = 2.dp,
    xs = 4.dp,
    sm = 8.dp,
    md = 12.dp,
    lg = 16.dp,
    xl = 24.dp,
    xxl = 32.dp,
)
