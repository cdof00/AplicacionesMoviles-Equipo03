package com.example.musicapp.ui.components.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.atoms.AppIcon
import com.example.musicapp.ui.components.atoms.AppSurface
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.components.atoms.IconSizeKey
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun EliteStatusBadgeMolecule(
    label: String,
    modifier: Modifier = Modifier,
) {
    val s = AppTheme.spacing
    val colors = AppTheme.colors
    AppSurface(
        modifier = modifier,
        shape = AppTheme.shapes.roundedFull(),
        color = colors.surfaceContainerHighest.copy(alpha = 0.94f),
        borderColor = colors.outlineAccent,
        elevation = AppTheme.elevation.raised,
    ) {
        Row(
            modifier = Modifier.padding(horizontal = s.sm, vertical = s.xs),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(s.xs),
        ) {
            AppIcon(
                imageVector = Icons.Filled.Check,
                contentDescription = null,
                tint = colors.primary,
                sizeKey = IconSizeKey.ExtraSmall,
            )
            AppText(
                text = label,
                style = AppTheme.typography.labelSmall,
                color = colors.primary,
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun EliteStatusBadgeMoleculePreview() {
    DesignSystemPreviewSurface {
        EliteStatusBadgeMolecule(label = "ELITE")
    }
}
