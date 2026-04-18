package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.MenuBook
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.atoms.AppIcon
import com.example.musicapp.ui.components.atoms.AppSurface
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.components.atoms.IconSizeKey
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun ArtistBioCardOrganism(
    title: String,
    body: String,
    originLabel: String,
    originValue: String,
    genreLabel: String,
    genreValue: String,
    modifier: Modifier = Modifier,
) {
    val s = AppTheme.spacing
    val colors = AppTheme.colors
    val b = AppTheme.borders
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
                    imageVector = Icons.AutoMirrored.Outlined.MenuBook,
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
            AppText(
                text = body,
                style = AppTheme.typography.bodyMedium,
                color = colors.onSurfaceVariant,
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(b.thin)
                    .background(colors.outlineSubtle.copy(alpha = 0.45f)),
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(s.lg),
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(s.xs),
                ) {
                    AppText(
                        text = originLabel,
                        style = AppTheme.typography.labelSmall,
                        color = colors.onSurfaceVariant,
                    )
                    AppText(
                        text = originValue,
                        style = AppTheme.typography.bodyMedium,
                        color = colors.onSurface,
                    )
                }
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(s.xs),
                ) {
                    AppText(
                        text = genreLabel,
                        style = AppTheme.typography.labelSmall,
                        color = colors.onSurfaceVariant,
                    )
                    AppText(
                        text = genreValue,
                        style = AppTheme.typography.bodyMedium,
                        color = colors.onSurface,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun ArtistBioCardOrganismPreview() {
    DesignSystemPreviewSurface {
        ArtistBioCardOrganism(
            title = "Artist Bio",
            body = "Short bio text for preview purposes.",
            originLabel = "ORIGIN",
            originValue = "Alton, Illinois, U.S.",
            genreLabel = "GENRE",
            genreValue = "Modal Jazz, Fusion",
            modifier = Modifier.padding(AppTheme.spacing.md),
        )
    }
}
