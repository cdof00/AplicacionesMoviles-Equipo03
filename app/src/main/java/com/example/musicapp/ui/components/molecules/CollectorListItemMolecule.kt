package com.example.musicapp.ui.components.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.atoms.AppAvatar
import com.example.musicapp.ui.components.atoms.AppAvatarSize
import com.example.musicapp.ui.components.atoms.AppIcon
import com.example.musicapp.ui.components.atoms.AppSurface
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.components.atoms.IconSizeKey
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.screens.collectors.CollectorListEntry
import com.example.musicapp.ui.screens.collectors.collectorTierUsesPrimaryAccent
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun CollectorListItemMolecule(
    entry: CollectorListEntry,
    onClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val s = AppTheme.spacing
    val colors = AppTheme.colors
    val tierPrimary = collectorTierUsesPrimaryAccent(entry.tierLabel)
    AppSurface(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick(entry.collectorId) },
        shape = AppTheme.shapes.roundedLg(),
        color = colors.surfaceContainer.copy(alpha = 0.92f),
        borderColor = colors.outlineSubtle,
        elevation = AppTheme.elevation.raised,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(s.md),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(s.md),
        ) {
            Box {
                AppAvatar(
                    initials = entry.name,
                    size = AppAvatarSize.Medium,
                    accentRing = entry.highlightAvatarBadge,
                    gradientVariantIndex = entry.avatarGradientIndex,
                )
                if (entry.highlightAvatarBadge) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .size(s.sm)
                            .clip(CircleShape)
                            .background(colors.primary),
                    )
                }
            }
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(s.xxs),
            ) {
                AppText(
                    text = entry.name,
                    style = AppTheme.typography.titleMedium,
                    color = colors.onSurface,
                )
                AppText(
                    text = "${entry.lpCount} LPs in Crate",
                    style = AppTheme.typography.bodySmall,
                    color = colors.onSurfaceVariant,
                )
            }
            AppText(
                text = entry.tierLabel,
                style = AppTheme.typography.labelSmall,
                color = if (tierPrimary) colors.primary else colors.onSurfaceVariant,
            )
            AppIcon(
                imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                contentDescription = null,
                tint = colors.onSurfaceVariant.copy(alpha = 0.72f),
                sizeKey = IconSizeKey.Medium,
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun CollectorListItemMoleculePreview() {
    DesignSystemPreviewSurface {
        CollectorListItemMolecule(
            entry = CollectorListEntry(
                collectorId = 1,
                name = "Marcus Vane",
                lpCount = 1_240,
                tierLabel = "ELITE",
                highlightAvatarBadge = true,
                avatarGradientIndex = 0,
            ),
            onClick = { _ -> },
        )
    }
}