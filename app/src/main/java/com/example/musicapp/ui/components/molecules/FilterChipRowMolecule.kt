package com.example.musicapp.ui.components.molecules

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.atoms.AppChip
import com.example.musicapp.ui.components.atoms.AppChipVariant
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun FilterChipRowMolecule(
    labels: List<String>,
    selectedIndex: Int,
    onSelect: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val s = AppTheme.spacing
    val scroll = rememberScrollState()
    Row(
        modifier = modifier
            .horizontalScroll(scroll)
            .padding(vertical = s.xs),
        horizontalArrangement = Arrangement.spacedBy(s.sm),
    ) {
        labels.forEachIndexed { index, label ->
            AppChip(
                label = label,
                onClick = { onSelect(index) },
                variant = if (index == selectedIndex) AppChipVariant.Selected else AppChipVariant.Neutral,
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun FilterChipRowMoleculePreview() {
    DesignSystemPreviewSurface {
        FilterChipRowMolecule(
            labels = listOf("All", "Jazz", "Rock"),
            selectedIndex = 0,
            onSelect = {},
        )
    }
}
