package com.example.musicapp.ui.components.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.SubcomposeAsyncImage
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme
import com.example.musicapp.ui.util.coverGradientBrush

/**
 * Square album art placeholder using theme-driven gradients (no bitmap assets).
 */
@Composable
fun AppAlbumCoverPlaceholder(
    model: String? = null,
    modifier: Modifier = Modifier,
){
    val colors = AppTheme.colors
    val shape = AppTheme.shapes.roundedXl()
    SubcomposeAsyncImage(
        modifier = modifier.fillMaxWidth()
            .aspectRatio(1f)
            .clip(shape),
        model = model,
        error = {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(shape)
                    .background(brush = coverGradientBrush(0, colors)),
            )
        },
        loading = {
            CircularProgressIndicator()
        },
        contentDescription = null,
    )
}


@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun AppAlbumCoverPlaceholderPreview() {
    DesignSystemPreviewSurface {
        AppAlbumCoverPlaceholder()
    }
}
