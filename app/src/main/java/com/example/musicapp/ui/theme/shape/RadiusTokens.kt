package com.example.musicapp.ui.theme.shape

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class ShapeTokens(
    val sm: Dp,
    val md: Dp,
    val lg: Dp,
    val xl: Dp,
) {
    fun roundedSm(): RoundedCornerShape = RoundedCornerShape(sm)
    fun roundedMd(): RoundedCornerShape = RoundedCornerShape(md)
    fun roundedLg(): RoundedCornerShape = RoundedCornerShape(lg)
    fun roundedXl(): RoundedCornerShape = RoundedCornerShape(xl)
    fun roundedFull(): RoundedCornerShape = RoundedCornerShape(percent = 50)
}

fun defaultShapeTokens(): ShapeTokens = ShapeTokens(
    sm = 6.dp,
    md = 10.dp,
    lg = 16.dp,
    xl = 24.dp,
)
