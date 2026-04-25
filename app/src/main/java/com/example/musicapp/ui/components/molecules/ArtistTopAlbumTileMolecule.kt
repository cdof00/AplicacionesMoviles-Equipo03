package com.example.musicapp.ui.components.molecules

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.atoms.AppAlbumCoverPlaceholder
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.screens.artist.ArtistDetailTopAlbum
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun ArtistTopAlbumTileMolecule(
    album: ArtistDetailTopAlbum,
    onClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val s = AppTheme.spacing
    val colors = AppTheme.colors
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = { onClick(album.albumId) }),
        verticalArrangement = Arrangement.spacedBy(s.sm),
    ) {
        AppAlbumCoverPlaceholder("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimages.assetsdelivery.com%2Fcompings_v2%2Falonastep%2Falonastep1602%2Falonastep160200364.jpg&f=1&nofb=1&ipt=2a3d537441750a6e329d6ac3c6d77ba1e7faa305c8720880ccaf0f1ab59c0ff5")
        AppText(
            text = album.title,
            style = AppTheme.typography.titleSmall,
            color = colors.onSurface,
        )
        AppText(
            text = album.metaLine,
            style = AppTheme.typography.bodySmall,
            color = colors.onSurfaceVariant,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun ArtistTopAlbumTileMoleculePreview() {
    DesignSystemPreviewSurface {
        ArtistTopAlbumTileMolecule(
            album = ArtistDetailTopAlbum("art-kob", "Kind of Blue", "1959 • 5 Tracks", 1),
            onClick = { _ -> },
            modifier = Modifier.fillMaxWidth(),
        )
    }
}
