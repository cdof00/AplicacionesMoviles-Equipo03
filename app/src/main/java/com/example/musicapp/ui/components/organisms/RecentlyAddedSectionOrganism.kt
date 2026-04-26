package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.models.Album
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.components.molecules.AlbumTileMolecule
import com.example.musicapp.ui.components.molecules.SectionHeaderMolecule
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.screens.collector.collectorRecentlyAddedAlbums
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun RecentlyAddedSectionOrganism(
    albums: List<Album>,
    modifier: Modifier = Modifier,
    onViewAllClick: () -> Unit = {},
) {
    val s = AppTheme.spacing
    val colors = AppTheme.colors
    Column(modifier = modifier.fillMaxWidth()) {
        SectionHeaderMolecule(
            title = "Recently Added",
            action = {
                AppText(
                    text = "VIEW ALL",
                    style = AppTheme.typography.labelSmall,
                    color = colors.primary,
                    modifier = Modifier.clickable(onClick = onViewAllClick),
                )
            },
            modifier = Modifier.padding(bottom = s.md),
        )
        albums.chunked(2).forEach { row ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = s.lg),
                horizontalArrangement = Arrangement.spacedBy(s.md),
            ) {
                row.forEach { album ->
                    AlbumTileMolecule(
                        album = album,
                        modifier = Modifier.weight(1f),
                    )
                }
                if (row.size == 1) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A, heightDp = 640)
@Composable
private fun RecentlyAddedSectionOrganismPreview() {
    DesignSystemPreviewSurface {
        RecentlyAddedSectionOrganism(albums = collectorRecentlyAddedAlbums)
    }
}
