package com.example.musicapp.ui.components.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.atoms.AppSurface
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun InfoStatCardMolecule(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    highlightValuePrimary: Boolean = false,
) {
    val s = AppTheme.spacing
    val colors = AppTheme.colors
    AppSurface(
        modifier = modifier.fillMaxWidth(),
        elevation = AppTheme.elevation.card,
        borderColor = colors.outline.copy(alpha = 0.2f),
    ) {
        Column(
            modifier = Modifier.padding(s.md),
            verticalArrangement = Arrangement.spacedBy(s.xs),
        ) {
            AppText(
                text = label.uppercase(),
                style = AppTheme.typography.labelSmall,
                color = colors.onSurfaceVariant,
            )
            AppText(
                text = value,
                style = AppTheme.typography.titleMedium,
                color = if (highlightValuePrimary) colors.primary else colors.onSurface,
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun InfoStatCardMoleculePreview() {
    DesignSystemPreviewSurface {
        InfoStatCardMolecule(
            label = "Condition",
            value = "MINT",
            highlightValuePrimary = true,
        )
    }
}
