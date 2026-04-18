package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Album
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.atoms.AppAlbumCoverPlaceholder
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.components.molecules.ArtistStatPillMolecule
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun ArtistHeroSectionOrganism(
    featuredLabel: String,
    name: String,
    curatorRatingLabel: String,
    vaultLabel: String,
    heroCoverVariantIndex: Int,
    modifier: Modifier = Modifier,
) {
    val s = AppTheme.spacing
    val colors = AppTheme.colors
    val comp = AppTheme.dimensions.component
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = s.sm),
        horizontalArrangement = Arrangement.spacedBy(s.md),
        verticalAlignment = Alignment.Top,
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(s.sm),
        ) {
            AppText(
                text = featuredLabel,
                style = AppTheme.typography.labelSmall,
                color = colors.primary,
            )
            AppText(
                text = name,
                style = AppTheme.typography.headlineLarge,
                color = colors.onBackground,
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(s.sm),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                ArtistStatPillMolecule(
                    icon = Icons.Filled.Star,
                    label = curatorRatingLabel,
                    iconTintPrimary = true,
                )
                ArtistStatPillMolecule(
                    icon = Icons.Outlined.Album,
                    label = vaultLabel,
                    iconTintPrimary = false,
                )
            }
        }
        Box(modifier = Modifier.width(comp.avatarLg)) {
            AppAlbumCoverPlaceholder(variantIndex = heroCoverVariantIndex)
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun ArtistHeroSectionOrganismPreview() {
    DesignSystemPreviewSurface {
        ArtistHeroSectionOrganism(
            featuredLabel = "FEATURED ARTIST",
            name = "Miles Davis",
            curatorRatingLabel = "9.2 Curator Rating",
            vaultLabel = "54 LP's in Vault",
            heroCoverVariantIndex = 0,
            modifier = Modifier.padding(AppTheme.spacing.md),
        )
    }
}
