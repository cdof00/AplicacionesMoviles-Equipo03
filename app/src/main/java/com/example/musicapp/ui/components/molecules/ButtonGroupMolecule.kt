package com.example.musicapp.ui.components.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.musicapp.ui.components.atoms.AppButton
import com.example.musicapp.ui.components.atoms.AppButtonVariant
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun ButtonGroupMolecule(
    options: List<String>,
    selectedIndex: Int,
    onSelect: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(AppTheme.spacing.sm),
    ) {
        options.forEachIndexed { index, label ->
            AppButton(
                text = label,
                onClick = { onSelect(index) },
                variant = if (index == selectedIndex) AppButtonVariant.Primary else AppButtonVariant.Outlined,
            )
        }
    }
}
