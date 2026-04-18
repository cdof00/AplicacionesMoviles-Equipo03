package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.musicapp.ui.components.atoms.AppCard
import com.example.musicapp.ui.components.atoms.AppCardVariant
import com.example.musicapp.ui.components.molecules.FilterChipRowMolecule
import com.example.musicapp.ui.components.molecules.SearchBarMolecule
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun SearchPanelOrganism(
    query: String,
    onQueryChange: (String) -> Unit,
    filterLabels: List<String>,
    selectedFilterIndex: Int,
    onFilterSelect: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val s = AppTheme.spacing
    AppCard(modifier = modifier.fillMaxWidth(), variant = AppCardVariant.Elevated) {
        Column(
            modifier = Modifier.padding(s.md),
            verticalArrangement = Arrangement.spacedBy(s.md),
        ) {
            SearchBarMolecule(
                value = query,
                onValueChange = onQueryChange,
                placeholder = "Search tokens, components…",
            )
            FilterChipRowMolecule(
                labels = filterLabels,
                selectedIndex = selectedFilterIndex,
                onSelect = onFilterSelect,
            )
        }
    }
}
