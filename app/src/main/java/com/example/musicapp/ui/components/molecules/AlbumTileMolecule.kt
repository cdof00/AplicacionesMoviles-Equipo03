package com.example.musicapp.ui.components.molecules

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.models.Album
import com.example.musicapp.ui.components.atoms.AppAlbumCoverPlaceholder
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun AlbumTileMolecule(
    album: Album,
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit = {},
) {
    val s = AppTheme.spacing
    Column(
        modifier = modifier
            .fillMaxWidth()
            .testTag("album_tile")
            .semantics {
                contentDescription = album.name
            }
            .clickable(onClick = { onClick(album.albumId) }),
        verticalArrangement = Arrangement.spacedBy(s.sm),
    ) {
        val artista = album.performers.firstOrNull()
        var nombre = ""
        if(artista!=null){
            nombre = artista.name
        }
        else{
            nombre = "Sin Artista"
        }
        AppAlbumCoverPlaceholder(album.cover)
        AlbumMetaFooterMolecule(
            title = album.name,
            genre = nombre,
            releaseDate = album.releaseDate,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun AlbumTileMoleculePreview() {
    DesignSystemPreviewSurface {
        AlbumTileMolecule(
            album = Album(
                albumId = 1,
                name = "Dust & Diamonds",
                cover = "https://example.com/cover.jpg",
                releaseDate = "1982-09-14",
                description = "A collection of 12 tracks",
                genre = "Folk",
                recordLabel = "Columbia"
            ),
            modifier = Modifier.fillMaxWidth(),
            onClick = { _ -> },
        )
    }
}
