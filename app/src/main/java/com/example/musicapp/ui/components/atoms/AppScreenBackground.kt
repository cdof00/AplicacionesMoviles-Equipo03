package com.example.musicapp.ui.components.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme

/**
 * Full-screen floor: deep black + subtle warm amber wash (aligns with primary family).
 */
@Composable
fun AppScreenBackground(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit,
) {
    val colors = AppTheme.colors
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(colors.background)
            .drawBehind {
                val r = size.maxDimension * 0.65f
                drawCircle(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            colors.primary.copy(alpha = 0.08f),
                            Color.Transparent,
                        ),
                        center = Offset(size.width * 0.32f, size.height * 0.14f),
                        radius = r,
                    ),
                    radius = r,
                    center = Offset(size.width * 0.32f, size.height * 0.14f),
                )
            },
    ) {
        content()
    }
}

@Preview(showBackground = true)
@Composable
private fun AppScreenBackgroundPreview() {
    DesignSystemPreviewSurface {
        AppScreenBackground {
            AppText("Content")
        }
    }
}
