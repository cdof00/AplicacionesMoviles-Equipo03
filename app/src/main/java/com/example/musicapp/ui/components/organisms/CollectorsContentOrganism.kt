package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.R
import com.example.musicapp.ui.components.molecules.CatalogCollectionHeaderMolecule
import com.example.musicapp.ui.components.molecules.CollectorListItemMolecule
import com.example.musicapp.ui.components.molecules.CollectorsHeroSectionMolecule
import com.example.musicapp.ui.components.molecules.FilterChipRowMolecule
import com.example.musicapp.ui.screens.collectors.CollectorListEntry
import com.example.musicapp.ui.screens.collectors.collectorsFilterChipLabels
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.screens.collectors.collectorsMockList
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun CollectorsContentOrganism(
    innerPadding: PaddingValues,
    collectors: List<CollectorListEntry>,
    onOpenCollectorDetail: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val s = AppTheme.spacing
    var selectedChipIndex by rememberSaveable { mutableIntStateOf(0) }
    val collectorsText = stringResource(R.string.collectors)
    val collectorsTitle = stringResource(R.string.collectors_title)
    val collectorsSubtitle = stringResource(R.string.collectors_subtitle)

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(horizontal = s.xl),
        contentPadding = PaddingValues(bottom = s.xxl),
    ) {
        item {
            CatalogCollectionHeaderMolecule(title = collectorsTitle)
        }

        item {
            CollectorsHeroSectionMolecule(
                watermarkNumber = "03",
                title = collectorsText,
                subtitle = collectorsSubtitle,
            )
        }

        item {
            FilterChipRowMolecule(
                labels = collectorsFilterChipLabels,
                selectedIndex = selectedChipIndex,
                onSelect = { selectedChipIndex = it },
                modifier = Modifier.padding(bottom = s.md),
            )
        }

        items(
            items = collectors,
            key = { it.collectorId },
        ) { entry ->
            CollectorListItemMolecule(
                entry = entry,
                onClick = { onOpenCollectorDetail(entry.collectorId) },
                modifier = Modifier.padding(bottom = s.md),
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A, heightDp = 720)
@Composable
private fun CollectorsContentOrganismPreview() {
    DesignSystemPreviewSurface {
        val s = AppTheme.spacing
        CollectorsContentOrganism(
            innerPadding = PaddingValues(top = s.sm, bottom = s.md),
            collectors = collectorsMockList,
            onOpenCollectorDetail = { _ -> },
        )
    }
}