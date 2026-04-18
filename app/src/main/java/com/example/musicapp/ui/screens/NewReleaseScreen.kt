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
import com.example.musicapp.ui.components.organisms.CatalogBottomNavBarOrganism
import com.example.musicapp.ui.components.organisms.FloatingAddButtonOrganism
import com.example.musicapp.ui.components.organisms.NewReleaseContentOrganism
import com.example.musicapp.ui.components.templates.NewReleaseScreenTemplate
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check

private const val ADD_TAB_INDEX = 3

/**
 * Add / new release form. Scaffold (bottom bar + FAB) is provided by [com.example.musicapp.ui.navigation.MusicAppRoot].
 */
@Composable
fun NewReleaseScreen(
    innerPadding: PaddingValues,
    onClose: () -> Unit,
    modifier: Modifier = Modifier,
    onSave: () -> Unit = {},
    onUploadArtworkClick: () -> Unit = {},
    onAddTrackClick: () -> Unit = {},
) {
    NewReleaseContentOrganism(
        innerPadding = innerPadding,
        onClose = onClose,
        onSave = onSave,
        onUploadArtworkClick = onUploadArtworkClick,
        onAddTrackClick = onAddTrackClick,
        modifier = modifier.fillMaxSize(),
    )
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
                innerPadding = PaddingValues(
                    top = scaffoldPadding.calculateTopPadding() + s.sm,
                    bottom = scaffoldPadding.calculateBottomPadding() + s.md,
                ),
                onClose = {},
            )
        }
    }
}
