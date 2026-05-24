package com.example.musicapp.ui.screens

import android.app.Application
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.musicapp.R
import com.example.musicapp.ui.components.organisms.CatalogBottomNavBarOrganism
import com.example.musicapp.ui.components.organisms.CollectorsContentOrganism
import com.example.musicapp.ui.components.organisms.FloatingAddButtonOrganism
import com.example.musicapp.ui.components.templates.CollectorsScreenTemplate
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.screens.collectors.CollectorListEntry
import com.example.musicapp.ui.theme.theme.AppTheme
import com.example.musicapp.viewmodels.CollectorViewModel

@Composable
fun CollectorsScreen(
    innerPadding: PaddingValues,
    onOpenCollectorDetail: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {

    val application = LocalContext.current.applicationContext as Application

    val errorLoading = stringResource(R.string.error_loading)
    val no_collectors = stringResource(R.string.no_collectors)
    val elite = stringResource(R.string.elite)
    val pro = stringResource(R.string.pro)
    val archivist = stringResource(R.string.archivist)
    val legend = stringResource(R.string.legend)
    val emerging = stringResource(R.string.emerging)

    val collectorViewModel: CollectorViewModel = viewModel(
        factory = CollectorViewModel.Factory(
            app = application,
            collectorId = 0
        )
    )

    val collectorListUiState by collectorViewModel.uiState.collectAsState()
    val isLoading by collectorViewModel.isLoading.collectAsState()
    val hasError by collectorViewModel.hasError.collectAsState()

    when {

        isLoading -> {
            CircularProgressIndicator(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(align = Alignment.Center)
            )
        }

        hasError -> {
            Text(
                text = errorLoading,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(align = Alignment.Center)
            )
        }

        collectorListUiState.collectors.isEmpty() -> {
            Text(
                text = no_collectors,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(align = Alignment.Center)
            )
        }

        else -> {

            val collectorEntries = collectorListUiState.collectors.mapIndexed { index, collector ->

                val tier = when (index % 5) {
                    0 -> elite
                    1 -> pro
                    2 -> archivist
                    3 -> legend
                    else -> emerging
                }

                CollectorListEntry(
                    collectorId = collector.collectorId,
                    name = collector.name,
                    lpCount = collector.collectorAlbums.size,
                    tierLabel = tier,
                    highlightAvatarBadge = tier == elite,
                    avatarGradientIndex = index,
                    genres = emptyList()
                )
            }

            CollectorsContentOrganism(
                innerPadding = innerPadding,
                collectors = collectorEntries,
                onOpenCollectorDetail = onOpenCollectorDetail,
                modifier = modifier.fillMaxSize(),
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A, heightDp = 900)
@Composable
private fun CollectorsScreenPreview() {

    DesignSystemPreviewSurface {

        var tab by rememberSaveable { mutableIntStateOf(2) }

        val s = AppTheme.spacing

        CollectorsScreenTemplate(

            bottomBar = {
                CatalogBottomNavBarOrganism(
                    selectedIndex = tab,
                    onSelect = { tab = it },
                )
            },

            floatingActionButton = {
                FloatingAddButtonOrganism(
                    onClick = {},
                    imageVector = Icons.Filled.PersonAdd,
                    contentDescription = "Add collector",
                )
            },

            ) { scaffoldPadding ->

            CollectorsScreen(
                innerPadding = PaddingValues(
                    top = scaffoldPadding.calculateTopPadding() + s.sm,
                    bottom = scaffoldPadding.calculateBottomPadding() + s.md,
                ),
                onOpenCollectorDetail = { _ -> },
            )
        }
    }
}