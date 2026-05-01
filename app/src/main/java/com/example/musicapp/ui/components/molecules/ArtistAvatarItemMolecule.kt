package com.example.musicapp.ui.components.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.example.musicapp.ui.components.atoms.AppAvatar
import com.example.musicapp.ui.components.atoms.AppAvatarSize
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun ArtistAvatarItemMolecule(
    name: String,
    gradientVariantIndex: Int,
    imageUrl: String = "",
    modifier: Modifier = Modifier,
) {
    val s = AppTheme.spacing
    val colors = AppTheme.colors
    val comp = AppTheme.dimensions.component
    Column(
        modifier = modifier.width(comp.artistRowAvatar + s.lg),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(s.sm),
    ) {
        if (imageUrl.isNotEmpty()) {
            AsyncImage(
                model = imageUrl,
                contentDescription = name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(comp.artistRowAvatar)
                    .clip(CircleShape),
            )
        } else {
            AppAvatar(
                initials = name,
                size = AppAvatarSize.ArtistRow,
                accentRing = true,
                gradientVariantIndex = gradientVariantIndex,
            )
        }
        AppText(
            text = name,
            style = AppTheme.typography.labelMedium,
            color = colors.onSurface,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.width(comp.artistRowAvatar + s.lg),
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun ArtistAvatarItemMoleculePreview() {
    DesignSystemPreviewSurface {
        ArtistAvatarItemMolecule(
            name = "Miles Davis",
            gradientVariantIndex = 1,
        )
    }
}