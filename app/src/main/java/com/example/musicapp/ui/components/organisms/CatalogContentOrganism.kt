package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.R
import com.example.musicapp.models.Album
import com.example.musicapp.ui.components.molecules.AlbumTileMolecule
import com.example.musicapp.ui.components.molecules.CatalogBrandRowMolecule
import com.example.musicapp.ui.components.molecules.CatalogCollectionHeaderMolecule
import com.example.musicapp.ui.components.molecules.FeaturedSpunCardMolecule
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.screens.catalog.catalogAlbumMockList
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun CatalogContentOrganism(
    albums: List<Album>,
    modifier: Modifier = Modifier,
    onAlbumClick: (Int) -> Unit = {},
    contentPadding: PaddingValues = PaddingValues(),
    brandTitle: String = stringResource(R.string.album_title),
    collectionTitle: String = stringResource(R.string.collection),
    featuredTitle: String = stringResource(R.string.spun),
    featuredSubtitle: String = "A LOVE SUPREME • COLTRANE",
    heroTitle: String = stringResource(R.string.vault),
    heroSubtitle: String = stringResource(R.string.archive),
) {
    val s = AppTheme.spacing
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.fillMaxSize(),
        contentPadding = contentPadding,
        horizontalArrangement = Arrangement.spacedBy(s.md),
        verticalArrangement = Arrangement.spacedBy(s.lg),
    ) {
        item(span = { GridItemSpan(2) }) {
            CatalogBrandRowMolecule(title = brandTitle)
        }
        item(span = { GridItemSpan(2) }) {
            CatalogCollectionHeaderMolecule(title = collectionTitle)
        }
        item(span = { GridItemSpan(2) }) {
            CatalogHeroSectionOrganism(
                title = heroTitle,
                subtitle = heroSubtitle,
            )
        }
        item(span = { GridItemSpan(2) }) {
            FeaturedSpunCardMolecule(
                title = featuredTitle,
                subtitle = featuredSubtitle,
                modifier = Modifier.padding(bottom = s.xs),
            )
        }
        items(items = albums, key = { it.albumId }) { album ->
            AlbumTileMolecule(
                album = album,
                modifier = Modifier.fillMaxWidth(),
                onClick = onAlbumClick,
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A, heightDp = 800)
@Composable
private fun CatalogContentOrganismPreview() {
    DesignSystemPreviewSurface {
        val s = AppTheme.spacing
        CatalogContentOrganism(
            albums = catalogAlbumMockList,
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = s.xl, vertical = s.sm),
        )
    }
}
