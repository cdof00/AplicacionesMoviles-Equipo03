package com.example.musicapp.ui.components.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme
import com.example.musicapp.ui.util.coverGradientBrush

enum class AppAvatarSize {
    Small,
    Medium,
    Large,
    ArtistRow,
}

@Composable
fun AppAvatar(
    initials: String,
    modifier: Modifier = Modifier,
    size: AppAvatarSize = AppAvatarSize.Medium,
    accentRing: Boolean = false,
    gradientVariantIndex: Int? = null,
) {
    val comp = AppTheme.dimensions.component
    val colors = AppTheme.colors
    val b = AppTheme.borders

    val dim = when (size) {
        AppAvatarSize.Small -> comp.avatarSm
        AppAvatarSize.Medium -> comp.avatarMd
        AppAvatarSize.Large -> comp.avatarLg
        AppAvatarSize.ArtistRow -> comp.artistRowAvatar
    }

    val shape = CircleShape

    val ringColor = if (accentRing) {
        colors.primary.copy(alpha = 0.88f)
    } else {
        colors.glassEdge
    }

    val bgBrush: Brush? = gradientVariantIndex?.let {
        coverGradientBrush(it, colors)
    }

    Box(
        modifier = modifier
            .size(dim)
            .clip(shape)
            .border(b.thin, ringColor, shape)
            .then(
                if (bgBrush != null) {
                    Modifier.background(bgBrush)
                } else {
                    Modifier.background(colors.surfaceContainerHigh)
                },
            ),
        contentAlignment = Alignment.Center,
    ) {
        AppText(
            text = getAvatarInitials(initials),
            style = AppTheme.typography.labelMedium,
            color = colors.onSurface,
        )
    }
}

private fun getAvatarInitials(name: String): String {
    val words = name
        .trim()
        .split(" ")
        .filter { it.isNotBlank() }

    return when {
        words.size >= 2 -> "${words[0].first()}${words[1].first()}".uppercase()
        words.size == 1 -> words[0].take(2).uppercase()
        else -> "?"
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun AppAvatarPreview() {
    DesignSystemPreviewSurface {
        AppAvatar("Manolo Bellon", gradientVariantIndex = 0)
    }
}