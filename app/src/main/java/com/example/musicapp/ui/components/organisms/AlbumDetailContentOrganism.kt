package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import com.example.musicapp.models.Album
import com.example.musicapp.models.Track
import com.example.musicapp.ui.components.atoms.AppAlbumCoverPlaceholder
import com.example.musicapp.ui.components.molecules.AlbumMetaHeaderMolecule
import com.example.musicapp.ui.components.molecules.DetailTopBarMolecule
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun AlbumDetailContentOrganism(
    tracks: List<Track>,
    album: Album,
    innerPadding: PaddingValues,
    onBackClick: () -> Unit,
    onMenuClick: () -> Unit,
    onPlayClick: () -> Unit,
    onCreateTrack: (String, String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val s = AppTheme.spacing

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(horizontal = s.xl),
        contentPadding = PaddingValues(bottom = s.xxl),
        verticalArrangement = Arrangement.spacedBy(s.lg),
    ) {
        item {
            DetailTopBarMolecule(
                title = album.name,
                onBackClick = onBackClick,
                onTrailingClick = onMenuClick,
                trailingIcon = Icons.Outlined.MoreVert,
                trailingContentDescription = "More",
                modifier = Modifier
                    .testTag("album_detail_header_title")
                    .semantics {
                        contentDescription = album.name
                    },
            )
        }

        item {
            AppAlbumCoverPlaceholder(album.cover)
        }

        item {
            val artistName = album.performers.firstOrNull()?.name ?: "Sin Artista"

            AlbumMetaHeaderMolecule(
                title = album.name,
                artist = artistName,
                year = album.releaseDate.split("-")[0],
            )
        }

        item {
            TracklistCardOrganism(
                tracks = tracks,
                onCreateTrack = onCreateTrack,
            )
        }
    }
}