package com.example.musicapp.ui.components.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddAPhoto
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.musicapp.ui.components.atoms.AppIcon
import com.example.musicapp.ui.components.atoms.AppSurface
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.components.atoms.IconSizeKey
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme
import com.example.musicapp.ui.util.coverGradientBrush

private val uploadCardMinHeight = 200.dp

@Composable
fun ArtworkUploadCardMolecule(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    uploadLabel: String = "UPLOAD ARTWORK",
) {
    val s = AppTheme.spacing
    val colors = AppTheme.colors
    AppSurface(
        modifier = modifier
            .fillMaxWidth()
            .height(uploadCardMinHeight)
            .clickable(onClick = onClick),
        shape = AppTheme.shapes.roundedLg(),
        color = colors.surfaceContainer.copy(alpha = 0.85f),
        borderColor = colors.outlineSubtle,
        elevation = AppTheme.elevation.raised,
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(0.35f)
                    .background(brush = coverGradientBrush(6, colors)),
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(s.sm),
                modifier = Modifier.padding(s.lg),
            ) {
                AppIcon(
                    imageVector = Icons.Outlined.AddAPhoto,
                    contentDescription = null,
                    tint = colors.primary,
                    sizeKey = IconSizeKey.ExtraLarge,
                )
                AppText(
                    text = uploadLabel,
                    style = AppTheme.typography.labelSmall,
                    color = colors.onSurfaceVariant,
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun ArtworkUploadCardMoleculePreview() {
    DesignSystemPreviewSurface {
        ArtworkUploadCardMolecule(
            onClick = {},
            modifier = Modifier.padding(AppTheme.spacing.md),
        )
    }
}
