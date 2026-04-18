package com.example.musicapp.ui.components.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun AwardListItemMolecule(
    numberLabel: String,
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
) {
    val s = AppTheme.spacing
    val colors = AppTheme.colors
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = s.sm),
        horizontalArrangement = Arrangement.spacedBy(s.md),
    ) {
        AppText(
            text = numberLabel,
            style = AppTheme.typography.titleLarge,
            color = colors.primary,
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(s.xxs),
        ) {
            AppText(
                text = title,
                style = AppTheme.typography.titleSmall,
                color = colors.onSurface,
            )
            AppText(
                text = subtitle,
                style = AppTheme.typography.bodySmall,
                color = colors.onSurfaceVariant,
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun AwardListItemMoleculePreview() {
    DesignSystemPreviewSurface {
        AwardListItemMolecule(
            numberLabel = "08",
            title = "Grammy Awards",
            subtitle = "Best Jazz Performance",
        )
    }
}
