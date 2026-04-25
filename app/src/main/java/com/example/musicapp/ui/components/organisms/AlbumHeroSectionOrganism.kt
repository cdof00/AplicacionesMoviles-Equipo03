package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.atoms.AppAlbumCoverPlaceholder
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun AlbumHeroSectionOrganism(
    coverVariantIndex: Int,
    onPlayClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val s = AppTheme.spacing
    Box(modifier = modifier.fillMaxWidth()) {
        AppAlbumCoverPlaceholder("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimages.assetsdelivery.com%2Fcompings_v2%2Falonastep%2Falonastep1602%2Falonastep160200364.jpg&f=1&nofb=1&ipt=2a3d537441750a6e329d6ac3c6d77ba1e7faa305c8720880ccaf0f1ab59c0ff5")
        FloatingAddButtonOrganism(
            onClick = onPlayClick,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset(x = -s.lg, y = -s.lg),
            imageVector = Icons.Filled.PlayArrow,
            contentDescription = "Play",
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun AlbumHeroSectionOrganismPreview() {
    DesignSystemPreviewSurface {
        AlbumHeroSectionOrganism(
            coverVariantIndex = 2,
            onPlayClick = {},
        )
    }
}
