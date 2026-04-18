package com.example.musicapp.ui.components.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun CollectorsHeroSectionMolecule(
    watermarkNumber: String,
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
) {
    val s = AppTheme.spacing
    val colors = AppTheme.colors
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = s.sm, bottom = s.md),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(s.md),
    ) {
        AppText(
            text = watermarkNumber,
            style = AppTheme.typography.displayLarge,
            color = colors.onBackground.copy(alpha = 0.12f),
        )
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(s.xs),
        ) {
            AppText(
                text = title,
                style = AppTheme.typography.headlineLarge,
                color = colors.onBackground,
            )
            AppText(
                text = subtitle,
                style = AppTheme.typography.bodyMedium,
                color = colors.onSurfaceVariant,
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun CollectorsHeroSectionMoleculePreview() {
    DesignSystemPreviewSurface {
        CollectorsHeroSectionMolecule(
            watermarkNumber = "04",
            title = "COLLECTORS",
            subtitle = "Connecting with the elite circles of the high-fidelity community.",
        )
    }
}
