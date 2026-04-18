package com.example.musicapp.ui.components.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Album
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
fun CatalogBrandRowMolecule(
    title: String,
    modifier: Modifier = Modifier,
) {
    val s = AppTheme.spacing
    val colors = AppTheme.colors
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = s.xs),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(s.sm),
    ) {
        AppIcon(
            imageVector = Icons.Outlined.Album,
            contentDescription = null,
            tint = colors.primary.copy(alpha = 0.9f),
            sizeKey = IconSizeKey.Small,
        )
        AppText(
            text = title,
            style = AppTheme.typography.labelLarge,
            color = colors.onSurface.copy(alpha = 0.85f),
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun CatalogBrandRowMoleculePreview() {
    DesignSystemPreviewSurface {
        CatalogBrandRowMolecule(title = "Album Catalog")
    }
}
