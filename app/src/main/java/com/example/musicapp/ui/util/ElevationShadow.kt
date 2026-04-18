package com.example.musicapp.ui.util

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.example.musicapp.ui.theme.elevation.ElevationSpec

fun Modifier.elevationShadow(shape: Shape, spec: ElevationSpec): Modifier {
    if (spec.ambientAlpha <= 0f) return this
    return shadow(
        elevation = spec.blur.coerceAtLeast(1.dp),
        shape = shape,
        clip = false,
        ambientColor = Color.Black.copy(alpha = spec.ambientAlpha),
        spotColor = Color.Black.copy(alpha = spec.spotAlpha),
    )
}
