package com.example.musicapp.ui.util

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import com.example.musicapp.ui.theme.theme.AppTheme

/**
 * API 31+: soft blur on the glass layer. Below: tint only (see OpacityTokens.glassTint KDoc on colors).
 */
@Composable
fun Modifier.glassLayer(shape: Shape, blurDp: Dp): Modifier {
    val colors = AppTheme.colors
    val density = LocalDensity.current
    val px = with(density) { blurDp.toPx() }.coerceAtMost(25f)
    return clip(shape)
        .then(
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                Modifier.graphicsLayer {
                    renderEffect = androidx.compose.ui.graphics.BlurEffect(
                        radiusX = px,
                        radiusY = px,
                        edgeTreatment = androidx.compose.ui.graphics.TileMode.Clamp,
                    )
                }
            } else {
                Modifier
            }
        )
        .background(colors.glassTint, shape)
}
