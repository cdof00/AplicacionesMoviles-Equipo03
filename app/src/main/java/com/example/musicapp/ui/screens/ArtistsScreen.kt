package com.example.musicapp.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.organisms.ArtistsContentOrganism
import com.example.musicapp.ui.components.organisms.CatalogBottomNavBarOrganism
import com.example.musicapp.ui.components.organisms.FloatingAddButtonOrganism
import com.example.musicapp.ui.components.templates.ArtistsScreenTemplate
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun ArtistsScreen(
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier,
    onArtistClick: (Int) -> Unit = {},
) {
    ArtistsContentOrganism(
        innerPadding = innerPadding,
        onArtistClick = onArtistClick,
        modifier = modifier.fillMaxSize(),
    )
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
            ArtistsScreen(
                innerPadding = PaddingValues(
                    top = scaffoldPadding.calculateTopPadding() + s.sm,
                    bottom = scaffoldPadding.calculateBottomPadding() + s.md,
                ),
                onArtistClick = { _ -> },
            )
        }
    }
}