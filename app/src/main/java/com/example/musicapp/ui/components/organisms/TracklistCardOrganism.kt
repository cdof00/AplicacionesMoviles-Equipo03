package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.atoms.AppSurface
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.components.molecules.SectionHeaderMolecule
import com.example.musicapp.ui.components.molecules.TrackListItemMolecule
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.screens.album.AlbumDetailTrack
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun TracklistCardOrganism(
    totalTracksLabel: String,
    totalDurationLabel: String,
    tracks: List<AlbumDetailTrack>,
    modifier: Modifier = Modifier,
) {
    val s = AppTheme.spacing
    val colors = AppTheme.colors
    AppSurface(
        modifier = modifier.fillMaxWidth(),
        elevation = AppTheme.elevation.card,
        borderColor = colors.outline.copy(alpha = 0.2f),
    ) {
        Column(
            modifier = Modifier.padding(s.lg),
            verticalArrangement = Arrangement.spacedBy(s.md),
        ) {
            SectionHeaderMolecule(
                title = "Tracklist",
                action = {
                    AppText(
                        text = "${totalTracksLabel.uppercase()} TRACKS • $totalDurationLabel",
                        style = AppTheme.typography.labelSmall,
                        color = colors.onSurfaceVariant,
                    )
                },
            )
            Column(verticalArrangement = Arrangement.spacedBy(s.sm)) {
                tracks.forEach { track ->
                    TrackListItemMolecule(
                        number = track.number,
                        title = track.title,
                        subtitle = track.subtitle,
                        duration = track.duration,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun TracklistCardOrganismPreview() {
    DesignSystemPreviewSurface {
        val tracks = listOf(
            AlbumDetailTrack(1, "Pulse Width Highway", "Side A", "4:12"),
            AlbumDetailTrack(2, "Chrome Mirage", "Instrumental", "5:01"),
            AlbumDetailTrack(3, "Digital Sunset", "Vocal", "4:48"),
        )
        TracklistCardOrganism(
            totalTracksLabel = "12",
            totalDurationLabel = "48:22",
            tracks = tracks,
            modifier = Modifier.padding(AppTheme.spacing.md),
        )
    }
}
