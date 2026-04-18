package com.example.musicapp.ui.components.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Album
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.atoms.AppIcon
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.components.atoms.IconSizeKey
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme

/**
 * Catalog bottom nav item: icon, label, then optional amber dot below label (mock alignment).
 */
@Composable
fun CatalogNavItemMolecule(
    icon: ImageVector,
    label: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val colors = AppTheme.colors
    val s = AppTheme.spacing
    val interaction = remember { MutableInteractionSource() }
    val tint = if (selected) colors.primary else colors.onSurface.copy(alpha = 0.72f)
    Column(
        modifier = modifier
            .clip(AppTheme.shapes.roundedMd())
            .clickable(interactionSource = interaction, indication = null, onClick = onClick)
            .padding(horizontal = s.md, vertical = s.xs),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(s.xxs),
    ) {
        AppIcon(icon, contentDescription = label, tint = tint, sizeKey = IconSizeKey.Medium)
        AppText(
            text = label,
            style = AppTheme.typography.labelSmall,
            color = tint,
        )
        Box(
            modifier = Modifier.size(s.sm),
            contentAlignment = Alignment.Center,
        ) {
            if (selected) {
                Box(
                    Modifier
                        .size(s.xs)
                        .clip(CircleShape)
                        .background(colors.primary),
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun CatalogNavItemMoleculePreview() {
    DesignSystemPreviewSurface {
        CatalogNavItemMolecule(
            icon = Icons.Outlined.Album,
            label = "ALBUMS",
            selected = true,
            onClick = {},
        )
    }
}
