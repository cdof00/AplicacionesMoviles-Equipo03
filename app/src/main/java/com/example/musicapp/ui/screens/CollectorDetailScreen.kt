package com.example.musicapp.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.organisms.CatalogBottomNavBarOrganism
import com.example.musicapp.ui.components.organisms.CollectorDetailContentOrganism
import com.example.musicapp.ui.components.templates.CollectorDetailTemplate
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.screens.collector.collectorDetailUiMock

private const val COLLECTORS_TAB_INDEX = 2

@Composable
fun CollectorDetailScreen(
    onBack: () -> Unit,
    onShare: () -> Unit,
    onTabSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
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
            ui = collectorDetailUiMock,
            innerPadding = innerPadding,
            onBackClick = onBack,
            onShareClick = onShare,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A, heightDp = 900)
@Composable
private fun CollectorDetailScreenPreview() {
    DesignSystemPreviewSurface {
        CollectorDetailScreen(
            onBack = {},
            onShare = {},
            onTabSelected = {},
        )
    }
}
