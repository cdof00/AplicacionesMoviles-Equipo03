package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.musicapp.ui.components.atoms.AppSurface
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun ColorPaletteOrganism(modifier: Modifier = Modifier) {
    val c = AppTheme.colors
    val s = AppTheme.spacing
    val shapes = AppTheme.shapes
    val swatches = listOf(
        "Primary" to c.primary,
        "Secondary" to c.secondary,
        "Tertiary" to c.tertiary,
        "Background" to c.background,
        "Surface high" to c.surfaceContainerHigh,
    )
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(s.sm),
    ) {
        swatches.chunked(3).forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(s.sm),
            ) {
                row.forEach { (name, color) ->
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(s.xs),
                    ) {
                        AppSurface(
                            shape = shapes.roundedMd(),
                            color = color,
                            borderColor = c.glassEdge,
                            elevation = AppTheme.elevation.none,
                        ) {
                            Spacer(Modifier.size(s.xxl + s.lg))
                        }
                        AppText(name, style = AppTheme.typography.labelSmall, color = c.onSurfaceVariant)
                    }
                }
            }
        }
    }
}
