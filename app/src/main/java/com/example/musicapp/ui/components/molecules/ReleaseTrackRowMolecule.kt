package com.example.musicapp.ui.components.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DragHandle
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
fun ReleaseTrackRowMolecule(
    trackNumberLabel: String,
    title: String,
    duration: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val s = AppTheme.spacing
    val colors = AppTheme.colors
    AppSurface(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = AppTheme.shapes.roundedLg(),
        color = colors.surfaceContainer.copy(alpha = 0.92f),
        borderColor = colors.outlineSubtle,
        elevation = AppTheme.elevation.none,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(s.md),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(s.md),
        ) {
            Box(
                modifier = Modifier
                    .size(s.lg)
                    .clip(CircleShape)
                    .background(colors.primary.copy(alpha = 0.18f)),
                contentAlignment = Alignment.Center,
            ) {
                AppText(
                    text = trackNumberLabel,
                    style = AppTheme.typography.labelMedium,
                    color = colors.primary,
                )
            }
            AppText(
                text = title,
                style = AppTheme.typography.titleSmall,
                color = colors.onSurface,
                modifier = Modifier.weight(1f),
            )
            AppText(
                text = duration,
                style = AppTheme.typography.bodySmall,
                color = colors.onSurfaceVariant,
            )
            AppIcon(
                imageVector = Icons.Outlined.DragHandle,
                contentDescription = null,
                tint = colors.onSurfaceVariant.copy(alpha = 0.6f),
                sizeKey = IconSizeKey.Medium,
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun ReleaseTrackRowMoleculePreview() {
    DesignSystemPreviewSurface {
        ReleaseTrackRowMolecule(
            trackNumberLabel = "01",
            title = "So What",
            duration = "9:22",
            onClick = {},
            modifier = Modifier.padding(AppTheme.spacing.md),
        )
    }
}
