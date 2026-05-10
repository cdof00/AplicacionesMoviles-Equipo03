package com.example.musicapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.musicapp.ui.components.organisms.ArtistsContentOrganism
import com.example.musicapp.ui.components.organisms.CatalogBottomNavBarOrganism
import com.example.musicapp.ui.components.organisms.FloatingAddButtonOrganism
import com.example.musicapp.ui.components.templates.ArtistsScreenTemplate
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.screens.artists.ArtistListEntry
import com.example.musicapp.ui.theme.theme.AppTheme
import com.example.musicapp.viewmodels.MusicianListViewModel

@Composable
fun ArtistsScreen(
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier,
    onArtistClick: (Int) -> Unit = {},
    musicianListViewModel: MusicianListViewModel = viewModel(),
) {
    val uiState by musicianListViewModel.uiState.collectAsState()
    val isLoading by musicianListViewModel.isLoading.collectAsState()

    if (isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    } else {
        val artists = uiState.musicians.mapIndexed { index, musician ->
            ArtistListEntry(
                artistId = musician.musicianId,
                name = musician.name,
                description = musician.description,
                imageUrl = musician.image,
                avatarGradientIndex = index % 6,
            )
        }
        ArtistsContentOrganism(
            innerPadding = innerPadding,
            onArtistClick = onArtistClick,
            modifier = modifier.fillMaxSize(),
            artists = artists,
            isLoading = false,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A, heightDp = 900)
@Composable
private fun ArtistsScreenPreview() {
    DesignSystemPreviewSurface {
        var tab by rememberSaveable { mutableIntStateOf(1) }
        val s = AppTheme.spacing
        ArtistsScreenTemplate(
            bottomBar = {
                CatalogBottomNavBarOrganism(
                    selectedIndex = tab,
                    onSelect = { tab = it },
                )
            },
            floatingActionButton = {
                FloatingAddButtonOrganism(onClick = {})
            },
        ) { scaffoldPadding ->
            ArtistsContentOrganism(
                innerPadding = PaddingValues(
                    top = scaffoldPadding.calculateTopPadding() + s.sm,
                    bottom = scaffoldPadding.calculateBottomPadding() + s.md,
                ),
                onArtistClick = { _ -> },
                artists = listOf(
                    ArtistListEntry(1, "Miles Davis", "Jazz icon and bandleader.", "", 0),
                    ArtistListEntry(2, "Adele", "British soul and pop artist.", "", 1),
                ),
            )
        }
    }
}