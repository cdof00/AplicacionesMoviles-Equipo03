package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.atoms.AppInputSurfaceStyle
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.components.molecules.AddTrackPlaceholderRowMolecule
import com.example.musicapp.ui.components.molecules.ArtworkUploadCardMolecule
import com.example.musicapp.ui.components.molecules.DetailTopBarMolecule
import com.example.musicapp.ui.components.molecules.LabeledInputFieldMolecule
import com.example.musicapp.ui.components.molecules.ReleaseTrackRowMolecule
import com.example.musicapp.ui.components.molecules.TrackListSectionHeaderMolecule
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun NewReleaseContentOrganism(
    innerPadding: PaddingValues,
    onClose: () -> Unit,
    onSave: () -> Unit,
    onUploadArtworkClick: () -> Unit,
    onAddTrackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val s = AppTheme.spacing
    val colors = AppTheme.colors
    val b = AppTheme.borders

    var albumTitle by rememberSaveable { mutableStateOf("") }
    var artist by rememberSaveable { mutableStateOf("") }
    var year by rememberSaveable { mutableStateOf("") }
    var genre by rememberSaveable { mutableStateOf("Jazz") }
    var matrixNumber by rememberSaveable { mutableStateOf("") }
    var label by rememberSaveable { mutableStateOf("") }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(horizontal = s.xl),
        contentPadding = PaddingValues(bottom = s.xxl),
        verticalArrangement = Arrangement.spacedBy(s.lg),
    ) {
        item {
            DetailTopBarMolecule(
                title = "New Release",
                onBackClick = onClose,
                onTrailingClick = {},
                leadingIcon = Icons.Outlined.Close,
                leadingContentDescription = "Close",
                customTrailing = {
                    AppText(
                        text = "SAVE",
                        style = AppTheme.typography.labelLarge,
                        color = colors.primary,
                        modifier = Modifier
                            .padding(end = s.sm)
                            .clickable(onClick = onSave),
                    )
                },
            )
        }
        item {
            ArtworkUploadCardMolecule(onClick = onUploadArtworkClick)
        }
        item {
            LabeledInputFieldMolecule(
                label = "ALBUM TITLE",
                value = albumTitle,
                onValueChange = { albumTitle = it },
                placeholder = "",
                surfaceStyle = AppInputSurfaceStyle.Elevated,
            )
        }
        item {
            LabeledInputFieldMolecule(
                label = "ARTIST / ENSEMBLE",
                value = artist,
                onValueChange = { artist = it },
                placeholder = "",
                surfaceStyle = AppInputSurfaceStyle.Elevated,
            )
        }
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(s.md),
            ) {
                LabeledInputFieldMolecule(
                    label = "YEAR",
                    value = year,
                    onValueChange = { year = it },
                    placeholder = "",
                    surfaceStyle = AppInputSurfaceStyle.Elevated,
                    modifier = Modifier.weight(1f),
                )
                LabeledInputFieldMolecule(
                    label = "GENRE",
                    value = genre,
                    onValueChange = { genre = it },
                    placeholder = "Jazz",
                    surfaceStyle = AppInputSurfaceStyle.Default,
                    modifier = Modifier.weight(1f),
                )
            }
        }
        item {
            TrackListSectionHeaderMolecule(
                title = "Track List",
                subtitle = "DIGITAL CURATION — SIDE A / B",
                watermarkNumber = "01",
            )
        }
        item {
            Column(verticalArrangement = Arrangement.spacedBy(s.sm)) {
                ReleaseTrackRowMolecule(
                    trackNumberLabel = "01",
                    title = "So What",
                    duration = "9:22",
                    onClick = {},
                )
                ReleaseTrackRowMolecule(
                    trackNumberLabel = "02",
                    title = "Freddie Freeloader",
                    duration = "9:46",
                    onClick = {},
                )
                AddTrackPlaceholderRowMolecule(
                    label = "Add next track…",
                    onClick = onAddTrackClick,
                )
            }
        }
        item {
            Column(verticalArrangement = Arrangement.spacedBy(s.md)) {
                AppText(
                    text = "PRESSING DETAILS",
                    style = AppTheme.typography.labelSmall,
                    color = colors.onSurfaceVariant,
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(b.thin)
                        .background(colors.outlineSubtle.copy(alpha = 0.45f)),
                )
                LabeledInputFieldMolecule(
                    label = "MATRIX NUMBER",
                    value = matrixNumber,
                    onValueChange = { matrixNumber = it },
                    placeholder = "",
                    surfaceStyle = AppInputSurfaceStyle.Elevated,
                )
                LabeledInputFieldMolecule(
                    label = "LABEL",
                    value = label,
                    onValueChange = { label = it },
                    placeholder = "",
                    surfaceStyle = AppInputSurfaceStyle.Elevated,
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A, heightDp = 900)
@Composable
private fun NewReleaseContentOrganismPreview() {
    DesignSystemPreviewSurface {
        val s = AppTheme.spacing
        NewReleaseContentOrganism(
            innerPadding = PaddingValues(top = s.sm, bottom = s.md),
            onClose = {},
            onSave = {},
            onUploadArtworkClick = {},
            onAddTrackClick = {},
        )
    }
}
