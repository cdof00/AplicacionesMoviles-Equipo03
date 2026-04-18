package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.molecules.ArtistListItemMolecule
import com.example.musicapp.ui.components.molecules.ArtistsHeroSectionMolecule
import com.example.musicapp.ui.components.molecules.CatalogCollectionHeaderMolecule
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.screens.artists.artistsMockList
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun ArtistsContentOrganism(
    innerPadding: PaddingValues,
    onArtistClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val s = AppTheme.spacing
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
            items = artistsMockList,
            key = { it.name },
        ) { entry ->
            ArtistListItemMolecule(
                entry = entry,
                onClick = onArtistClick,
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
            onArtistClick = {},
        )
    }
}
