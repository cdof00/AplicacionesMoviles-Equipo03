package com.example.musicapp.ui.components.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.atoms.AppIcon
import com.example.musicapp.ui.components.atoms.AppSurface
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.components.atoms.IconSizeKey
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun AlbumMetaFooterMolecule(
    title: String,
    genre: String,
    releaseDate: String,
    modifier: Modifier = Modifier,
    showAccentStar: Boolean = false,
) {
    val s = AppTheme.spacing
    val colors = AppTheme.colors
    AppSurface(
        modifier = modifier.fillMaxWidth(),
        shape = AppTheme.shapes.roundedLg(),
        color = colors.surfaceContainer.copy(alpha = 0.92f),
        borderColor = colors.outlineSubtle,
        elevation = AppTheme.elevation.none,
    ) {
        Column(
            modifier = Modifier.padding(horizontal = s.sm, vertical = s.sm),
            verticalArrangement = Arrangement.spacedBy(s.xxs),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(s.xs),
            ) {
                AppText(
                    text = title,
                    style = AppTheme.typography.titleSmall,
                    color = colors.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f, fill = false),
                )
                if (showAccentStar) {
                    AppIcon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = null,
                        tint = colors.primary,
                        sizeKey = IconSizeKey.ExtraSmall,
                    )
                }
            }
            AppText(
                text = genre,
                style = AppTheme.typography.labelMedium,
                color = colors.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            AppText(
                text = releaseDate,
                style = AppTheme.typography.labelSmall,
                color = colors.onSurfaceVariant.copy(alpha = 0.85f),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun AlbumMetaFooterMoleculePreview() {
    DesignSystemPreviewSurface {
        AlbumMetaFooterMolecule(
            title = "Dust & Diamond",
            genre = "Folk",
            releaseDate = "1982-09-14",
        )
    }
}
