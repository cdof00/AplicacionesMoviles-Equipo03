package com.example.musicapp.ui.theme.border

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class BorderTokens(
    val hairline: Dp,
    val thin: Dp,
    val medium: Dp,
)

fun defaultBorderTokens(): BorderTokens = BorderTokens(
    hairline = Dp.Hairline,
    thin = 1.dp,
    medium = 1.5.dp,
)
