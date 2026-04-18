package com.example.musicapp.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.organisms.AlbumDetailContentOrganism
import com.example.musicapp.ui.components.organisms.CatalogBottomNavBarOrganism
import com.example.musicapp.ui.components.templates.AlbumDetailTemplate
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.screens.album.albumDetailUiMock

private const val ALBUMS_TAB_INDEX = 0

@Composable
fun AlbumDetailScreen(
    onBack: () -> Unit,
    onTabSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    AlbumDetailTemplate(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            CatalogBottomNavBarOrganism(
                selectedIndex = ALBUMS_TAB_INDEX,
                onSelect = onTabSelected,
            )
        },
        floatingActionButton = {},
    ) { innerPadding ->
        AlbumDetailContentOrganism(
            ui = albumDetailUiMock,
            innerPadding = innerPadding,
            onBackClick = onBack,
            onMenuClick = {},
            onPlayClick = {},
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A, heightDp = 900)
@Composable
private fun AlbumDetailScreenPreview() {
    DesignSystemPreviewSurface {
        AlbumDetailScreen(
            onBack = {},
            onTabSelected = {},
        )
    }
}
