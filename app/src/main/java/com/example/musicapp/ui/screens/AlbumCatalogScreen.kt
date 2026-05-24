package com.example.musicapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.musicapp.ui.components.organisms.CatalogBottomNavBarOrganism
import com.example.musicapp.ui.components.organisms.CatalogContentOrganism
import com.example.musicapp.ui.components.organisms.FloatingAddButtonOrganism
import com.example.musicapp.ui.components.templates.CatalogScreenTemplate
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme
import com.example.musicapp.viewmodels.AlbumViewModel

/**
 * Album catalog scroll content. When shown from [com.example.musicapp.ui.navigation.MusicAppRoot],
 * [innerPadding] comes from the shared [CatalogScreenTemplate] scaffold.
 */
@Composable
fun AlbumCatalogScreen(
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier,
    onAlbumClick: (Int) -> Unit = {},
    albumViewModel: AlbumViewModel = viewModel()
) {
    val s = AppTheme.spacing
    albumViewModel.refreshDataFromNetwork()
    val albumListUiState by albumViewModel.uiState.collectAsState()

    if (albumListUiState.albums.isEmpty()){
        CircularProgressIndicator(modifier = Modifier.fillMaxSize()
            .wrapContentSize(align = Alignment.Center))
    }

    else{
        CatalogContentOrganism(
            albums = albumListUiState.albums,
            modifier = modifier.fillMaxSize(),
            onAlbumClick = onAlbumClick,
            contentPadding = PaddingValues(
                start = s.xl,
                end = s.xl,
                top = innerPadding.calculateTopPadding() + s.sm,
                bottom = innerPadding.calculateBottomPadding() + s.md,
            ),
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A, heightDp = 900)
@Composable
private fun AlbumCatalogScreenPreview() {
    DesignSystemPreviewSurface {
        var selectedNav by rememberSaveable { mutableIntStateOf(0) }
        CatalogScreenTemplate(
            bottomBar = {
                CatalogBottomNavBarOrganism(
                    selectedIndex = selectedNav,
                    onSelect = { selectedNav = it },
                )
            },
            floatingActionButton = {
                if (selectedNav == 0) {
                    FloatingAddButtonOrganism(onClick = {})
                }
            },
        ) { innerPadding ->
            when (selectedNav) {
                0 -> AlbumCatalogScreen(innerPadding = innerPadding)
                else -> PlaceholderTabScreen(
                    title = if (selectedNav == 1) "Artists" else if (selectedNav == 2) "Collectors" else "Add",
                    innerPadding = innerPadding,
                )
            }
        }
    }
}
