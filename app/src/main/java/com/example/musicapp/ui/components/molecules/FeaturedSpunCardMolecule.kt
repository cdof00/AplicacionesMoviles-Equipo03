package com.example.musicapp.ui.components.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Bolt
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.atoms.AppIcon
import com.example.musicapp.ui.components.atoms.AppSurface
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.components.atoms.IconSizeKey
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun FeaturedSpunCardMolecule(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
) {
    val s = AppTheme.spacing
    val colors = AppTheme.colors
    val shapes = AppTheme.shapes
    AppSurface(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = s.xxl + s.lg),
        shape = shapes.roundedFull(),
        color = colors.surfaceContainerLow.copy(alpha = 0.88f),
        borderColor = colors.glassEdge,
        elevation = AppTheme.elevation.raised,
    ) {
        Row(
            modifier = Modifier
                .heightIn(min = s.xxl + s.lg)
                .padding(s.md),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(s.md),
        ) {
            Box(
                modifier = Modifier
                    .width(s.xs)
                    .height(s.xxl)
                    .clip(shapes.roundedFull())
                    .background(colors.primary.copy(alpha = 0.85f)),
            )
            AppIcon(
                imageVector = Icons.Outlined.Bolt,
                contentDescription = null,
                tint = colors.primary,
                sizeKey = IconSizeKey.Medium,
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(s.xxs),
                modifier = Modifier.weight(1f),
            ) {
                AppText(
                    text = title,
                    style = AppTheme.typography.titleSmall,
                    color = colors.onSurface,
                )
                AppText(
                    text = subtitle,
                    style = AppTheme.typography.labelMedium,
                    color = colors.onSurfaceVariant,
                    maxLines = 2,
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun FeaturedSpunCardMoleculePreview() {
    DesignSystemPreviewSurface {
        FeaturedSpunCardMolecule(
            title = "Recently Spun",
            subtitle = "A LOVE SUPREME • COLTRANE",
        )
    }
}
