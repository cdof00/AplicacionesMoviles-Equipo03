package com.example.musicapp.ui.components.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun SmallInfoRowMolecule(
    title: String,
    value: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AppText(title, style = AppTheme.typography.bodyMedium, color = AppTheme.colors.onSurfaceVariant)
        AppText(value, style = AppTheme.typography.bodyMedium)
    }
}
