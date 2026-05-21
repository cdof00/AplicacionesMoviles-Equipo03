package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.models.Track
import com.example.musicapp.ui.components.atoms.AppSurface
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.components.molecules.SectionHeaderMolecule
import com.example.musicapp.ui.components.molecules.TrackListItemMolecule
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun TracklistCardOrganism(
    tracks: List<Track>,
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
                        text = "${tracks.size} TRACKS",
                        style = AppTheme.typography.labelSmall,
                        color = colors.onSurfaceVariant,
                    )
                },
            )
            if (tracks.size == 0){
                Box(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(horizontal = s.xl),
                    contentAlignment = Alignment.Center,
                ) {
                    AppText(
                        text = "Este album no tiene canciones",
                        style = AppTheme.typography.bodyLarge,
                        color = colors.onSurfaceVariant,
                    )
                }
            }
            else{
                Column(verticalArrangement = Arrangement.spacedBy(s.sm)) {
                    var trackNum:Int = 0
                    tracks.forEach { track ->
                        trackNum++
                        TrackListItemMolecule(
                            number = trackNum,
                            title = track.name,
                            duration = track.duration,
                        )
                    }
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
            Track(1, "Pulse Width Highway",  "4:12",1),
            Track(2, "Chrome Mirage",  "5:01",1),
            Track(3, "Digital Sunset",  "4:48",1),
        )
        TracklistCardOrganism(
            tracks = tracks,
            modifier = Modifier.padding(AppTheme.spacing.md),
        )
    }
}
