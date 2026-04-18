package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.EmojiEvents
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.atoms.AppButton
import com.example.musicapp.ui.components.atoms.AppButtonVariant
import com.example.musicapp.ui.components.atoms.AppIcon
import com.example.musicapp.ui.components.atoms.AppSurface
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.components.atoms.IconSizeKey
import com.example.musicapp.ui.components.molecules.AwardListItemMolecule
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.screens.artist.ArtistDetailAward
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun ArtistAwardsCardOrganism(
    title: String,
    awards: List<ArtistDetailAward>,
    viewArchiveLabel: String,
    onViewArchiveClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val s = AppTheme.spacing
    val colors = AppTheme.colors
    AppSurface(
        modifier = modifier.fillMaxWidth(),
        shape = AppTheme.shapes.roundedLg(),
        color = colors.surfaceContainer.copy(alpha = 0.92f),
        borderColor = colors.outlineSubtle,
        elevation = AppTheme.elevation.raised,
    ) {
        Column(
            modifier = Modifier.padding(s.lg),
            verticalArrangement = Arrangement.spacedBy(s.md),
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(s.sm),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                AppIcon(
                    imageVector = Icons.Outlined.EmojiEvents,
                    contentDescription = null,
                    tint = colors.primary,
                    sizeKey = IconSizeKey.Medium,
                )
                AppText(
                    text = title,
                    style = AppTheme.typography.titleLarge,
                    color = colors.onSurface,
                )
            }
            awards.forEach { award ->
                AwardListItemMolecule(
                    numberLabel = award.numberLabel,
                    title = award.title,
                    subtitle = award.subtitle,
                )
            }
            AppButton(
                text = viewArchiveLabel,
                onClick = onViewArchiveClick,
                modifier = Modifier.fillMaxWidth(),
                variant = AppButtonVariant.Primary,
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun ArtistAwardsCardOrganismPreview() {
    DesignSystemPreviewSurface {
        ArtistAwardsCardOrganism(
            title = "Awards",
            awards = listOf(
                ArtistDetailAward("08", "Grammy Awards", "Best Jazz Performance"),
            ),
            viewArchiveLabel = "View Archive ↗",
            onViewArchiveClick = {},
            modifier = Modifier.padding(AppTheme.spacing.md),
        )
    }
}
