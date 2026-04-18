package com.example.musicapp.ui.components.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun StatRowMolecule(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(AppTheme.spacing.xxs)) {
        AppText(value, style = AppTheme.typography.headlineSmall, color = AppTheme.colors.primary)
        AppText(label, style = AppTheme.typography.labelMedium, color = AppTheme.colors.onSurfaceVariant)
    }
}
