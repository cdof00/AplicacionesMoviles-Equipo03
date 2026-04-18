package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.musicapp.ui.components.atoms.AppCard
import com.example.musicapp.ui.components.atoms.AppCardVariant
import com.example.musicapp.ui.components.molecules.ToolbarAction
import com.example.musicapp.ui.components.molecules.ToolbarActionGroupMolecule
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun ActionToolbarCardOrganism(
    actions: List<ToolbarAction>,
    modifier: Modifier = Modifier,
) {
    AppCard(modifier = modifier.fillMaxWidth(), variant = AppCardVariant.Elevated) {
        ToolbarActionGroupMolecule(
            actions = actions,
            modifier = Modifier.padding(AppTheme.spacing.md),
        )
    }
}
