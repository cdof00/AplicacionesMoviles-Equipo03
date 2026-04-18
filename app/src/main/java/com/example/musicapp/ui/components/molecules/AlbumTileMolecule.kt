package com.example.musicapp.ui.components.molecules

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.atoms.AppAlbumCoverPlaceholder
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.screens.catalog.CatalogAlbum
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun AlbumTileMolecule(
    album: CatalogAlbum,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit = {},
) {
    val s = AppTheme.spacing
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = { onClick(album.id) }),
        verticalArrangement = Arrangement.spacedBy(s.sm),
    ) {
        AppAlbumCoverPlaceholder(variantIndex = album.coverVariantIndex)
        AlbumMetaFooterMolecule(
            title = album.title,
            artist = album.artist,
            releaseDate = album.releaseDate,
            showAccentStar = album.showAccentStar,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun AlbumTileMoleculePreview() {
    DesignSystemPreviewSurface {
        AlbumTileMolecule(
            album = CatalogAlbum(
                id = "cat-05",
                title = "Dust & Diamond",
                artist = "The Outlaws",
                coverVariantIndex = 4,
                showAccentStar = true,
                releaseDate = "1982-09-14",
            ),
            modifier = Modifier.fillMaxWidth(),
            onClick = { _ -> },
        )
    }
}
