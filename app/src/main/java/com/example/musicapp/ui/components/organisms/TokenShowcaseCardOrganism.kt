package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.musicapp.ui.components.atoms.AppCard
import com.example.musicapp.ui.components.atoms.AppCardVariant
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun TokenShowcaseCardOrganism(
    tokenName: String,
    description: String,
    modifier: Modifier = Modifier,
) {
    AppCard(modifier = modifier.fillMaxWidth(), variant = AppCardVariant.Flat) {
        Column(Modifier.padding(AppTheme.spacing.md)) {
            AppText(tokenName, style = AppTheme.typography.titleMedium, color = AppTheme.colors.primary)
            AppText(description, style = AppTheme.typography.bodySmall, color = AppTheme.colors.onSurfaceVariant)
        }
    }
}
