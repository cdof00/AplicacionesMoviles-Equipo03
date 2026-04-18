package com.example.musicapp.ui.components.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.elevation.ElevationSpec
import com.example.musicapp.ui.theme.theme.AppTheme
import com.example.musicapp.ui.theme.theme.appShadow

@Composable
fun AppSurface(
    modifier: Modifier = Modifier,
    shape: Shape = AppTheme.shapes.roundedLg(),
    color: Color = AppTheme.colors.surfaceContainer,
    borderColor: Color? = null,
    elevation: ElevationSpec = AppTheme.elevation.none,
    content: @Composable () -> Unit,
) {
    val b = AppTheme.borders
    Box(
        modifier = modifier
            .appShadow(shape, elevation)
            .clip(shape)
            .background(color)
            .then(
                if (borderColor != null) Modifier.border(b.hairline, borderColor, shape) else Modifier,
            ),
    ) {
        content()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun AppSurfacePreview() {
    DesignSystemPreviewSurface {
        AppSurface(elevation = AppTheme.elevation.card) {
            AppText(
                "Card surface",
                modifier = Modifier.padding(AppTheme.spacing.md),
                style = AppTheme.typography.bodyMedium,
            )
        }
    }
}
