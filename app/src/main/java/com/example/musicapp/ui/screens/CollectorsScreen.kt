package com.example.musicapp.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.organisms.CatalogBottomNavBarOrganism
import com.example.musicapp.ui.components.organisms.CollectorsContentOrganism
import com.example.musicapp.ui.components.organisms.FloatingAddButtonOrganism
import com.example.musicapp.ui.components.templates.CollectorsScreenTemplate
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme

/**
 * Collectors discovery list. Scaffold (bottom bar + FAB) is provided by [com.example.musicapp.ui.navigation.MusicAppRoot].
 */
@Composable
fun CollectorsScreen(
    innerPadding: PaddingValues,
    onOpenCollectorDetail: () -> Unit,
    modifier: Modifier = Modifier,
) {
    CollectorsContentOrganism(
        innerPadding = innerPadding,
        onOpenCollectorDetail = onOpenCollectorDetail,
        modifier = modifier.fillMaxSize(),
    )
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
                onOpenCollectorDetail = {},
            )
        }
    }
}
