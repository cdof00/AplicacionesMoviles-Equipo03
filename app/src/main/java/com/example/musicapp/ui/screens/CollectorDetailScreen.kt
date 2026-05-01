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
import com.example.musicapp.ui.components.organisms.CatalogBottomNavBarOrganism
import com.example.musicapp.ui.components.organisms.CollectorDetailContentOrganism
import com.example.musicapp.ui.components.templates.CollectorDetailTemplate
import com.example.musicapp.ui.screens.collector.CollectorDetailUiModel
import com.example.musicapp.ui.screens.collector.FavoriteArtistMock
import com.example.musicapp.viewmodels.CollectorViewModel

private const val COLLECTORS_TAB_INDEX = 2

@Composable
fun CollectorDetailScreen(
    collectorId: Int,
    onBack: () -> Unit,
    onShare: () -> Unit,
    onTabSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val applicationContext = LocalContext.current.applicationContext
    val collectorViewModel: CollectorViewModel = viewModel(
        factory = CollectorViewModel.Factory(applicationContext as Application, collectorId)
    )
    val collectorDetailUiState by collectorViewModel.collectorDetail.collectAsState()

    if (collectorDetailUiState.collector.collectorId == 0) {
        CircularProgressIndicator(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(align = Alignment.Center)
        )
    } else {
        val collector = collectorDetailUiState.collector
        val uiModel = CollectorDetailUiModel(
            screenTitle = "Collector Detail",
            collectorName = collector.name,
            metadata = collector.email,
            avatarInitials = collector.name.take(2).uppercase(),
            eliteBadgeLabel = "COLLECTOR",
            followLabel = "Follow",
            heroAvatarGradientIndex = 0,
            genres = emptyList(),
            artists = collector.favoritePerformers.map { performer ->
                FavoriteArtistMock(
                    name = performer.name,
                    gradientVariantIndex = 0
                )
            },
            recentAlbums = emptyList()
        )

        CollectorDetailTemplate(
            modifier = modifier.fillMaxSize(),
            bottomBar = {
                CatalogBottomNavBarOrganism(
                    selectedIndex = COLLECTORS_TAB_INDEX,
                    onSelect = onTabSelected,
                )
            },
            floatingActionButton = {},
        ) { innerPadding ->
            CollectorDetailContentOrganism(
                ui = uiModel,
                innerPadding = innerPadding,
                onBackClick = onBack,
                onShareClick = onShare,
            )
        }
    }
}