package com.example.musicapp.ui.components.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.atoms.AppIcon
import com.example.musicapp.ui.components.atoms.AppSurface
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.components.atoms.IconSizeKey
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun ArtistStatPillMolecule(
    icon: ImageVector,
    label: String,
    modifier: Modifier = Modifier,
    iconTintPrimary: Boolean = false,
) {
    val s = AppTheme.spacing
    val colors = AppTheme.colors
    AppSurface(
        modifier = modifier,
        shape = AppTheme.shapes.roundedFull(),
        color = colors.surfaceContainerHigh.copy(alpha = 0.72f),
        borderColor = colors.outlineSubtle.copy(alpha = 0.5f),
        elevation = AppTheme.elevation.none,
    ) {
        Row(
            modifier = Modifier.padding(horizontal = s.md, vertical = s.sm),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(s.xs),
        ) {
            AppIcon(
                imageVector = icon,
                contentDescription = null,
                tint = if (iconTintPrimary) colors.primary else colors.onSurfaceVariant,
                sizeKey = IconSizeKey.Small,
            )
            AppText(
                text = label,
                style = AppTheme.typography.bodySmall,
                color = colors.onSurface,
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun ArtistStatPillMoleculePreview() {
    DesignSystemPreviewSurface {
        ArtistStatPillMolecule(
            icon = Icons.Filled.Star,
            label = "9.2 Curator Rating",
            iconTintPrimary = true,
        )
    }
}
