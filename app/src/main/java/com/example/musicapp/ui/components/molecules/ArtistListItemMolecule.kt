package com.example.musicapp.ui.components.molecules

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.musicapp.ui.components.atoms.AppAvatar
import com.example.musicapp.ui.components.atoms.AppAvatarSize
import com.example.musicapp.ui.components.atoms.AppIcon
import com.example.musicapp.ui.components.atoms.AppSurface
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.components.atoms.IconSizeKey
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.screens.artists.ArtistListEntry
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun ArtistListItemMolecule(
    entry: ArtistListEntry,
    onClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val s = AppTheme.spacing
    val colors = AppTheme.colors
    AppSurface(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick(entry.artistId) },
        shape = AppTheme.shapes.roundedLg(),
        color = colors.surfaceContainer.copy(alpha = 0.92f),
        borderColor = colors.outlineSubtle,
        elevation = AppTheme.elevation.raised,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(s.md),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(s.md),
        ) {
            if (entry.imageUrl.isNotEmpty()) {
                AsyncImage(
                    model = entry.imageUrl,
                    contentDescription = entry.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape),
                )
            } else {
                AppAvatar(
                    initials = entry.name,
                    size = AppAvatarSize.Medium,
                    accentRing = false,
                    gradientVariantIndex = entry.avatarGradientIndex,
                )
            }
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(s.xxs),
            ) {
                AppText(
                    text = entry.name,
                    style = AppTheme.typography.titleMedium,
                    color = colors.onSurface,
                )
                if (entry.description.isNotEmpty()) {
                    AppText(
                        text = entry.description,
                        style = AppTheme.typography.bodySmall,
                        color = colors.onSurfaceVariant,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
            AppIcon(
                imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                contentDescription = null,
                tint = colors.onSurfaceVariant.copy(alpha = 0.72f),
                sizeKey = IconSizeKey.Medium,
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun ArtistListItemMoleculePreview() {
    DesignSystemPreviewSurface {
        ArtistListItemMolecule(
            entry = ArtistListEntry(1, "Miles Davis", "Jazz trumpeter and bandleader.", "", 0),
            onClick = { _ -> },
        )
    }
}
