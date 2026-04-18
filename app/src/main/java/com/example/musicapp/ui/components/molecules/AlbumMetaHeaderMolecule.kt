package com.example.musicapp.ui.components.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Album
import androidx.compose.material.icons.outlined.Event
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.atoms.AppIcon
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.components.atoms.IconSizeKey
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun AlbumMetaHeaderMolecule(
    title: String,
    artist: String,
    year: String,
    format: String,
    modifier: Modifier = Modifier,
) {
    val s = AppTheme.spacing
    val colors = AppTheme.colors
    val metaColor = colors.onSurfaceVariant
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(s.sm),
    ) {
        AppText(
            text = title,
            style = AppTheme.typography.headlineLarge,
            color = colors.onSurface,
        )
        AppText(
            text = artist.uppercase(),
            style = AppTheme.typography.labelLarge,
            color = colors.primary,
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(s.xs),
        ) {
            AppIcon(
                imageVector = Icons.Outlined.Event,
                contentDescription = null,
                tint = metaColor,
                sizeKey = IconSizeKey.Small,
            )
            AppText(
                text = year,
                style = AppTheme.typography.bodySmall,
                color = metaColor,
            )
            AppText(
                text = "•",
                style = AppTheme.typography.bodySmall,
                color = metaColor,
            )
            AppIcon(
                imageVector = Icons.Outlined.Album,
                contentDescription = null,
                tint = metaColor,
                sizeKey = IconSizeKey.Small,
            )
            AppText(
                text = format,
                style = AppTheme.typography.bodySmall,
                color = metaColor,
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun AlbumMetaHeaderMoleculePreview() {
    DesignSystemPreviewSurface {
        AlbumMetaHeaderMolecule(
            title = "Midnight Neon",
            artist = "SYNTHETIX WAVE",
            year = "1984",
            format = "180g Virgin Vinyl",
        )
    }
}
