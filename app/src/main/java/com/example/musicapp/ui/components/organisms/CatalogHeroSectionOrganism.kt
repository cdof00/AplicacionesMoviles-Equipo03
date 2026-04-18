package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
fun CatalogHeroSectionOrganism(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    watermark: String = "1.2K",
) {
    val s = AppTheme.spacing
    val colors = AppTheme.colors
    Box(modifier = modifier.fillMaxWidth()) {
        AppText(
            text = watermark,
            style = AppTheme.typography.displayMedium,
            color = colors.onBackground.copy(alpha = 0.06f),
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(end = s.xs),
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = s.sm, bottom = s.md),
        ) {
            AppText(
                text = title,
                style = AppTheme.typography.headlineLarge,
                color = colors.primary,
            )
            AppText(
                text = subtitle,
                style = AppTheme.typography.bodyMedium,
                color = colors.onSurfaceVariant,
                modifier = Modifier.padding(top = s.xs),
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun CatalogHeroSectionOrganismPreview() {
    DesignSystemPreviewSurface {
        CatalogHeroSectionOrganism(
            title = "CuratedVault",
            subtitle = "High-fidelity analog archives",
        )
    }
}
