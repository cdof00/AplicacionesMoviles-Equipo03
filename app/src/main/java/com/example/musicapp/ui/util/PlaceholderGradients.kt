package com.example.musicapp.ui.util

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import com.example.musicapp.ui.theme.color.AppColors

/** Theme-driven gradient stops for square covers and circular avatar placeholders. */
fun coverGradientBrush(index: Int, colors: AppColors): Brush {
    val palette = listOf(
        listOf(colors.surfaceContainerHighest, colors.primary.copy(alpha = 0.42f)),
        listOf(colors.tertiary.copy(alpha = 0.5f), colors.surfaceContainerHigh),
        listOf(colors.surfaceVariant, colors.primary.copy(alpha = 0.28f)),
        listOf(colors.surfaceContainer, colors.tertiary.copy(alpha = 0.35f)),
        listOf(colors.surfaceContainerHigh, colors.surfaceContainerHighest),
        listOf(colors.primary.copy(alpha = 0.38f), colors.surfaceVariant),
        listOf(colors.outline.copy(alpha = 0.25f), colors.surfaceContainerHigh),
        listOf(colors.surfaceContainerHighest, colors.tertiary.copy(alpha = 0.45f)),
    )
    val stops = palette[index % palette.size]
    return Brush.linearGradient(
        colors = stops,
        start = Offset.Zero,
        end = Offset(180f, 280f),
    )
}
