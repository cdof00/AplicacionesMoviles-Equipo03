package com.example.musicapp.ui.components.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun TrackListItemMolecule(
    number: Int,
    title: String,
    subtitle: String,
    duration: String,
    modifier: Modifier = Modifier,
) {
    val s = AppTheme.spacing
    val colors = AppTheme.colors
    val numberText = number.toString().padStart(2, '0')
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(s.md),
    ) {
        AppText(
            text = numberText,
            style = AppTheme.typography.titleMedium,
            color = colors.onSurface.copy(alpha = 0.38f),
        )
        Column(
            modifier = Modifier.weight(1f),
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
        AppText(
            text = duration,
            style = AppTheme.typography.bodyMedium,
            color = colors.onSurfaceVariant,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun TrackListItemMoleculePreview() {
    DesignSystemPreviewSurface {
        TrackListItemMolecule(
            number = 1,
            title = "Pulse Width Highway",
            subtitle = "Side A — Analog Synth",
            duration = "4:12",
        )
    }
}
