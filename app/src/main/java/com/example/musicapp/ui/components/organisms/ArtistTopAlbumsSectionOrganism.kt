package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LibraryMusic
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.atoms.AppIcon
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.components.atoms.IconSizeKey
import com.example.musicapp.ui.components.molecules.ArtistTopAlbumTileMolecule
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.screens.artist.ArtistDetailTopAlbum
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun ArtistTopAlbumsSectionOrganism(
    sectionTitle: String,
    seeAllLabel: String,
    albums: List<ArtistDetailTopAlbum>,
    onSeeAllClick: () -> Unit,
    onAlbumClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val s = AppTheme.spacing
    val colors = AppTheme.colors
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(s.md),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(s.sm),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                AppIcon(
                    imageVector = Icons.Outlined.LibraryMusic,
                    contentDescription = null,
                    tint = colors.primary,
                    sizeKey = IconSizeKey.Medium,
                )
                AppText(
                    text = sectionTitle,
                    style = AppTheme.typography.titleLarge,
                    color = colors.onSurface,
                )
            }
            AppText(
                text = seeAllLabel,
                style = AppTheme.typography.labelLarge,
                color = colors.primary,
                modifier = Modifier.clickable(onClick = onSeeAllClick),
            )
        }
        albums.chunked(2).forEach { rowAlbums ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(s.md),
            ) {
                rowAlbums.forEach { album ->
                    ArtistTopAlbumTileMolecule(
                        album = album,
                        onClick = onAlbumClick,
                        modifier = Modifier.weight(1f),
                    )
                }
                if (rowAlbums.size == 1) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A, heightDp = 400)
@Composable
private fun ArtistTopAlbumsSectionOrganismPreview() {
    DesignSystemPreviewSurface {
        val albums = listOf(
            ArtistDetailTopAlbum("Kind of Blue", "1959 • 5 Tracks", 1),
            ArtistDetailTopAlbum("Bitches Brew", "1970 • 6 Tracks", 2),
        )
        ArtistTopAlbumsSectionOrganism(
            sectionTitle = "Top Albums",
            seeAllLabel = "See All",
            albums = albums,
            onSeeAllClick = {},
            onAlbumClick = {},
            modifier = Modifier.padding(AppTheme.spacing.md),
        )
    }
}
