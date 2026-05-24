package com.example.musicapp.ui.screens

import android.R.attr.contentDescription
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.organisms.CatalogBottomNavBarOrganism
import com.example.musicapp.ui.components.organisms.FloatingAddButtonOrganism
import com.example.musicapp.ui.components.organisms.NewReleaseContentOrganism
import com.example.musicapp.ui.components.templates.NewReleaseScreenTemplate
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.musicapp.viewmodels.CreateAlbumViewModel
import com.example.musicapp.viewmodels.MusicianListViewModel

private const val ADD_TAB_INDEX = 3

@Composable
fun NewReleaseScreen(
    navController : NavHostController,
    innerPadding: PaddingValues,
    onClose: () -> Unit,
    modifier: Modifier = Modifier,
    onSave: () -> Unit = {},
    onUploadArtworkClick: () -> Unit = {},
    onAddTrackClick: () -> Unit = {},
    musicianListViewModel: MusicianListViewModel = viewModel(),
    createAlbumViewModel: CreateAlbumViewModel = viewModel(),
) {
    val musicians by musicianListViewModel.uiState.collectAsState()
    val isLoadingList by musicianListViewModel.isLoading.collectAsState()
    val isLoadingSend by createAlbumViewModel.isLoading.collectAsState()

    if (isLoadingList || isLoadingSend ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White.copy(alpha = 0.3f))
                .clickable(enabled = false) {},
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
    else{
        NewReleaseContentOrganism(
            navController = navController,
            viewModel = createAlbumViewModel,
            musicians = musicians.musicians,
            isLoading = isLoadingList,
            innerPadding = innerPadding,
            onClose = onClose,
            onSave = onSave,
            onAddTrackClick = onAddTrackClick,
            modifier = modifier.fillMaxSize(),
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A, heightDp = 900)
@Composable
private fun NewReleaseScreenPreview() {
    DesignSystemPreviewSurface {
        var tab by rememberSaveable { mutableIntStateOf(ADD_TAB_INDEX) }
        val s = AppTheme.spacing
        NewReleaseScreenTemplate(
            bottomBar = {
                CatalogBottomNavBarOrganism(
                    selectedIndex = tab,
                    onSelect = { tab = it },
                )
            },
            floatingActionButton = {
                FloatingAddButtonOrganism(
                    onClick = {},
                    imageVector = Icons.Filled.Check,
                    contentDescription = "Confirm",
                )
            },
        ) { scaffoldPadding ->
            NewReleaseScreen(
                navController = rememberNavController(),
                innerPadding = PaddingValues(
                    top = scaffoldPadding.calculateTopPadding() + s.sm,
                    bottom = scaffoldPadding.calculateBottomPadding() + s.md,
                ),
                onClose = {},
            )
        }
    }
}
