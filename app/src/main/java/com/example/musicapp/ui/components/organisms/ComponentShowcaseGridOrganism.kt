package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.musicapp.ui.components.atoms.AppCard
import com.example.musicapp.ui.components.atoms.AppCardVariant
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun ComponentShowcaseGridOrganism(
    count: Int,
    modifier: Modifier = Modifier,
    slot: @Composable (index: Int) -> Unit,
) {
    val s = AppTheme.spacing
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(s.sm),
        verticalArrangement = Arrangement.spacedBy(s.sm),
        contentPadding = PaddingValues(vertical = s.xs),
    ) {
        items(count) { index ->
            AppCard(variant = AppCardVariant.Flat) {
                Box(Modifier.padding(s.sm)) {
                    slot(index)
                }
            }
        }
    }
}
