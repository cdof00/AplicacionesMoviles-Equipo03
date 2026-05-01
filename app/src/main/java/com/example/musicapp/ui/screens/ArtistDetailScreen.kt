package com.example.musicapp.ui.screens

import android.app.Application
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.musicapp.ui.components.organisms.ArtistDetailContentOrganism
import com.example.musicapp.ui.components.organisms.CatalogBottomNavBarOrganism
import com.example.musicapp.ui.components.templates.ArtistDetailTemplate
import com.example.musicapp.ui.screens.artist.ArtistDetailAward
import com.example.musicapp.ui.screens.artist.ArtistDetailTopAlbum
import com.example.musicapp.ui.screens.artist.ArtistDetailUiModel
import com.example.musicapp.viewmodels.MusicianViewModel

private const val ARTISTS_TAB_INDEX = 1

@Composable
fun ArtistDetailScreen(
    artistId: Int,
    onBack: () -> Unit,
    onTabSelected: (Int) -> Unit,
    onAlbumClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val applicationContext = LocalContext.current.applicationContext
    val musicianViewModel: MusicianViewModel = viewModel(
        factory = MusicianViewModel.Factory(applicationContext as Application, artistId)
    )
    val musicianDetailUiState by musicianViewModel.musicianDetail.collectAsState()

    if (musicianDetailUiState.musician.musicianId == 0) {
        CircularProgressIndicator(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(align = Alignment.Center)
        )
    } else {
        val musician = musicianDetailUiState.musician
        val uiModel = ArtistDetailUiModel(
            screenTitle = "Collection",
            featuredLabel = "FEATURED ARTIST",
            name = musician.name,
            curatorRatingLabel = "Curator Rating",
            vaultLabel = "LP's in Vault",
            heroCoverVariantIndex = 0,
            bioTitle = "Artist Bio",
            bioBody = musician.description,
            originLabel = "ORIGIN",
            originValue = musician.birthDate.take(4),
            genreLabel = "GENRE",
            genreValue = "",
            awardsTitle = "Awards",
            awards = musician.performerPrizes.mapIndexed { index, _ ->
                ArtistDetailAward(
                    numberLabel = "0${index + 1}",
                    title = "Award",
                    subtitle = ""
                )
            },
            viewArchiveLabel = "View Archive ↗",
            topAlbumsSectionTitle = "Top Albums",
            seeAllLabel = "See All",
            topAlbums = musician.albums.map { album ->
                ArtistDetailTopAlbum(
                    albumId = album.albumId.toString(),
                    title = album.name,
                    metaLine = album.releaseDate.take(4),
                    coverVariantIndex = 0
                )
            }
        )

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
                ui = uiModel,
                innerPadding = innerPadding,
                onBackClick = onBack,
                onSearchClick = {},
                onMenuClick = {},
                onViewArchiveClick = {},
                onSeeAllAlbumsClick = {},
                onAlbumClick = { albumIdStr ->
                    albumIdStr.toIntOrNull()?.let { onAlbumClick(it) }
                },
            )
        }
    }
}