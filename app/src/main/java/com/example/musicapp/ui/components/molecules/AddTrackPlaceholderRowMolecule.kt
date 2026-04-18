package com.example.musicapp.ui.components.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.atoms.AppIcon
import com.example.musicapp.ui.components.atoms.AppSurface
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.components.atoms.IconSizeKey
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun AddTrackPlaceholderRowMolecule(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val s = AppTheme.spacing
    val colors = AppTheme.colors
    AppSurface(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = AppTheme.shapes.roundedLg(),
        color = colors.surfaceContainer.copy(alpha = 0.92f),
        borderColor = colors.outlineSubtle,
        elevation = AppTheme.elevation.none,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(s.md),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(s.md),
        ) {
            Box(
                modifier = Modifier
                    .size(s.lg)
                    .clip(CircleShape)
                    .background(colors.surfaceContainerHigh),
                contentAlignment = Alignment.Center,
            ) {
                AppIcon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = null,
                    tint = colors.onSurfaceVariant,
                    sizeKey = IconSizeKey.Small,
                )
            }
            AppText(
                text = label,
                style = AppTheme.typography.bodyMedium.copy(fontStyle = FontStyle.Italic),
                color = colors.onSurfaceVariant,
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun AddTrackPlaceholderRowMoleculePreview() {
    DesignSystemPreviewSurface {
        AddTrackPlaceholderRowMolecule(
            label = "Add next track…",
            onClick = {},
            modifier = Modifier.padding(AppTheme.spacing.md),
        )
    }
}
