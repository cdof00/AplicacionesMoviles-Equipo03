package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.components.molecules.ArtistListItemMolecule
import com.example.musicapp.ui.components.molecules.ArtistsHeroSectionMolecule
import com.example.musicapp.ui.components.molecules.CatalogCollectionHeaderMolecule
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.screens.artists.ArtistListEntry
import com.example.musicapp.ui.screens.artists.artistsMockList
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun ArtistsContentOrganism(
    innerPadding: PaddingValues,
    onArtistClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    artists: List<ArtistListEntry> = emptyList(),
    isLoading: Boolean = false,
) {
    val s = AppTheme.spacing
    val colors = AppTheme.colors

    if (!isLoading && artists.isEmpty()) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = s.xl),
            contentAlignment = Alignment.Center,
        ) {
            AppText(
                text = "No se encuentran artistas",
                style = AppTheme.typography.bodyLarge,
                color = colors.onSurfaceVariant,
            )
        }
        return
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(horizontal = s.xl),
        contentPadding = PaddingValues(bottom = s.xxl),
    ) {
        item {
            CatalogCollectionHeaderMolecule(title = "Artists")
        }
        item {
            ArtistsHeroSectionMolecule(
                eyebrow = "CURATED COLLECTION",
                titleLinePrimary = "Legendary",
                titleLineAccent = "Voices",
            )
        }
        items(
            items = artists,
            key = { it.artistId },
        ) { entry ->
            ArtistListItemMolecule(
                entry = entry,
                onClick = { onArtistClick(entry.artistId) },
                modifier = Modifier.padding(bottom = s.md),
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A, heightDp = 900)
@Composable
private fun ArtistsContentOrganismPreview() {
    DesignSystemPreviewSurface {
        val s = AppTheme.spacing
        ArtistsContentOrganism(
            innerPadding = PaddingValues(top = s.sm, bottom = s.md),
            onArtistClick = { _ -> },
            artists = artistsMockList,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A, heightDp = 400)
@Composable
private fun ArtistsContentOrganismEmptyPreview() {
    DesignSystemPreviewSurface {
        val s = AppTheme.spacing
        ArtistsContentOrganism(
            innerPadding = PaddingValues(top = s.sm, bottom = s.md),
            onArtistClick = { _ -> },
            artists = emptyList(),
            isLoading = false,
        )
    }
}
