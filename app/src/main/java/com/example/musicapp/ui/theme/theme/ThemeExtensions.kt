package com.example.musicapp.ui.theme.theme

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import com.example.musicapp.ui.theme.elevation.ElevationSpec
import com.example.musicapp.ui.util.elevationShadow

fun Modifier.appShadow(
    shape: Shape,
    spec: ElevationSpec,
): Modifier = elevationShadow(shape, spec)

@Composable
fun Modifier.horizontalScreenPadding(): Modifier {
    val s = AppTheme.spacing
    return padding(horizontal = s.lg)
}

@Composable
fun Modifier.sectionSpacingBottom(): Modifier {
    val s = AppTheme.spacing
    return padding(bottom = s.xl)
}

fun Color.withDisabledAlpha(): Color =
    copy(alpha = OpacityTokens.disabledContent)
