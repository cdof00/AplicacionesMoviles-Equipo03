package com.example.musicapp.ui.screens

import android.app.Application
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.musicapp.ui.components.organisms.AlbumDetailContentOrganism
import com.example.musicapp.ui.components.organisms.CatalogBottomNavBarOrganism
import com.example.musicapp.ui.components.templates.AlbumDetailTemplate
import com.example.musicapp.viewmodels.TrackViewModel

private const val ALBUMS_TAB_INDEX = 0

@Composable
fun AlbumDetailScreen(
    albumId: Int,
    onBack: () -> Unit,
    onTabSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val applicationContext = LocalContext.current.applicationContext

    val trackViewModel: TrackViewModel = viewModel(
        factory = TrackViewModel.Factory(
            applicationContext as Application,
            albumId
        )
    )

    val trackListUiState by trackViewModel.uiState.collectAsState()
    val trackAlbumUiState by trackViewModel.album.collectAsState()
    val isLoading by trackViewModel.isLoading.collectAsState()

    val onCreateTrack = remember(trackViewModel) {
        { name: String, duration: String ->
            trackViewModel.createTrack(name, duration)
        }
    }

    if (isLoading) {
        CircularProgressIndicator(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(align = Alignment.Center)
        )
    } else {
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
                tracks = trackListUiState.tracks,
                album = trackAlbumUiState.album,
                innerPadding = innerPadding,
                onBackClick = onBack,
                onMenuClick = {},
                onPlayClick = {},
                onCreateTrack = onCreateTrack,
            )
        }
    }
}