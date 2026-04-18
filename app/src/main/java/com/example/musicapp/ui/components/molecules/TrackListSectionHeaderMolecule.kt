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
fun TrackListSectionHeaderMolecule(
    title: String,
    subtitle: String,
    watermarkNumber: String,
    modifier: Modifier = Modifier,
) {
    val s = AppTheme.spacing
    val colors = AppTheme.colors
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = s.sm),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(s.xs),
            modifier = Modifier.weight(1f),
        ) {
            AppText(
                text = title,
                style = AppTheme.typography.headlineSmall,
                color = colors.onBackground,
            )
            AppText(
                text = subtitle,
                style = AppTheme.typography.labelSmall,
                color = colors.onSurfaceVariant,
            )
        }
        AppText(
            text = watermarkNumber,
            style = AppTheme.typography.displayLarge,
            color = colors.primary.copy(alpha = 0.22f),
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun TrackListSectionHeaderMoleculePreview() {
    DesignSystemPreviewSurface {
        TrackListSectionHeaderMolecule(
            title = "Track List",
            subtitle = "DIGITAL CURATION — SIDE A / B",
            watermarkNumber = "01",
            modifier = Modifier.padding(AppTheme.spacing.md),
        )
    }
}
