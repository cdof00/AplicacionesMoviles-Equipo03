package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.R
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.components.molecules.ArtistAvatarItemMolecule
import com.example.musicapp.ui.components.molecules.SectionHeaderMolecule
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.screens.collector.FavoriteArtistMock
import com.example.musicapp.ui.screens.collector.collectorFavoriteArtists
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun FavoriteArtistsSectionOrganism(
    artists: List<FavoriteArtistMock>,
    modifier: Modifier = Modifier,
) {
    val s = AppTheme.spacing
    val colors = AppTheme.colors
    val scroll = rememberScrollState()

    val favoriteArtists= stringResource(R.string.favorite_artists)
    Column(modifier = modifier.fillMaxWidth()) {
        SectionHeaderMolecule(
            title = favoriteArtists,
            action = {
                AppText(
                    text = "Top 5",
                    style = AppTheme.typography.labelMedium,
                    color = colors.onSurfaceVariant,
                )
            },
            modifier = Modifier.padding(bottom = s.sm),
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(scroll)
                .padding(vertical = s.xs),
            horizontalArrangement = Arrangement.spacedBy(s.md),
        ) {
            artists.forEach { artist ->
                ArtistAvatarItemMolecule(
                    name = artist.name,
                    gradientVariantIndex = artist.gradientVariantIndex,
                    imageUrl = artist.imageUrl,
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun FavoriteArtistsSectionOrganismPreview() {
    DesignSystemPreviewSurface {
        FavoriteArtistsSectionOrganism(artists = collectorFavoriteArtists)
    }
}
