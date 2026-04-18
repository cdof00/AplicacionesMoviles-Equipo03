package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.musicapp.ui.components.atoms.AppCard
import com.example.musicapp.ui.components.atoms.AppCardVariant
import com.example.musicapp.ui.components.molecules.SectionHeaderMolecule
import com.example.musicapp.ui.components.molecules.SmallInfoRowMolecule
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun SettingsPanelCardOrganism(
    title: String,
    rows: List<Pair<String, String>>,
    modifier: Modifier = Modifier,
) {
    val s = AppTheme.spacing
    AppCard(modifier = modifier.fillMaxWidth(), variant = AppCardVariant.Elevated) {
        Column(
            modifier = Modifier.padding(s.md),
            verticalArrangement = Arrangement.spacedBy(s.md),
        ) {
            SectionHeaderMolecule(title = title, subtitle = null)
            rows.forEach { (k, v) ->
                SmallInfoRowMolecule(title = k, value = v)
            }
        }
    }
}
