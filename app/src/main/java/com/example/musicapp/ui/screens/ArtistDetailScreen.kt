package com.example.musicapp.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.organisms.ArtistDetailContentOrganism
import com.example.musicapp.ui.components.organisms.CatalogBottomNavBarOrganism
import com.example.musicapp.ui.components.templates.ArtistDetailTemplate
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.screens.artist.artistDetailUiMock

private const val ARTISTS_TAB_INDEX = 1

@Composable
fun ArtistDetailScreen(
    onBack: () -> Unit,
    onTabSelected: (Int) -> Unit,
    onAlbumClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    ArtistDetailTemplate(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            CatalogBottomNavBarOrganism(
                selectedIndex = ARTISTS_TAB_INDEX,
                onSelect = onTabSelected,
            )
        },
        floatingActionButton = {},
    ) { innerPadding ->
        ArtistDetailContentOrganism(
            ui = artistDetailUiMock,
            innerPadding = innerPadding,
            onBackClick = onBack,
            onSearchClick = {},
            onMenuClick = {},
            onViewArchiveClick = {},
            onSeeAllAlbumsClick = {},
            onAlbumClick = onAlbumClick,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A, heightDp = 1200)
@Composable
private fun ArtistDetailScreenPreview() {
    DesignSystemPreviewSurface {
        ArtistDetailScreen(
            onBack = {},
            onTabSelected = {},
            onAlbumClick = {},
        )
    }
}
