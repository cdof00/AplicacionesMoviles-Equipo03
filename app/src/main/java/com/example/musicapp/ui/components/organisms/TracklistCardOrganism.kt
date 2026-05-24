package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.R
import com.example.musicapp.models.Track
import com.example.musicapp.ui.components.atoms.AppInputSurfaceStyle
import com.example.musicapp.ui.components.atoms.AppSurface
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.components.molecules.LabeledInputFieldMolecule
import com.example.musicapp.ui.components.molecules.SectionHeaderMolecule
import com.example.musicapp.ui.components.molecules.TrackListItemMolecule
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun TracklistCardOrganism(
    tracks: List<Track>,
    modifier: Modifier = Modifier,
    onCreateTrack: (String, String) -> Unit = { _, _ -> },
) {
    val s = AppTheme.spacing
    val colors = AppTheme.colors

    val tracklistTitle = stringResource(R.string.tracklist_title)
    val trackCount = stringResource(R.string.track_count, tracks.size)
    val emptyTracklistMessage = stringResource(R.string.empty_tracklist_message)

    val trackNameLabel = stringResource(R.string.track_name_label)
    val trackNamePlaceholder = stringResource(R.string.track_name_placeholder)
    val trackDurationLabel = stringResource(R.string.track_duration_label)
    val trackDurationPlaceholder = stringResource(R.string.track_duration_placeholder)
    val addTrackButtonText = stringResource(R.string.add_track_button)

    val trackNameRequiredError = stringResource(R.string.track_name_required_error)
    val trackDurationRequiredError = stringResource(R.string.track_duration_required_error)
    val trackDurationFormatError = stringResource(R.string.track_duration_format_error)

    val tracklistContentDescription = stringResource(R.string.tracklist_content_description)
    val addTrackFormContentDescription = stringResource(R.string.add_track_form_content_description)
    val addTrackButtonContentDescription = stringResource(R.string.add_track_button_content_description)
    val trackNameInputContentDescription = stringResource(R.string.track_name_input_content_description)
    val trackDurationInputContentDescription = stringResource(R.string.track_duration_input_content_description)

    var trackName by rememberSaveable { mutableStateOf("") }
    var trackDuration by rememberSaveable { mutableStateOf("") }
    var trackNameError by rememberSaveable { mutableStateOf<String?>(null) }
    var trackDurationError by rememberSaveable { mutableStateOf<String?>(null) }

    fun validateAndCreateTrack() {
        val cleanName = trackName.trim()
        val cleanDuration = trackDuration.trim()

        trackNameError = null
        trackDurationError = null

        if (cleanName.isBlank()) {
            trackNameError = trackNameRequiredError
            return
        }

        if (cleanDuration.isBlank()) {
            trackDurationError = trackDurationRequiredError
            return
        }

        if (!cleanDuration.matches(Regex("^\\d{1,2}:\\d{2}$"))) {
            trackDurationError = trackDurationFormatError
            return
        }

        onCreateTrack(cleanName, cleanDuration)

        trackName = ""
        trackDuration = ""
    }

    AppSurface(
        modifier = modifier
            .fillMaxWidth()
            .testTag("tracklist_card")
            .semantics {
                contentDescription = tracklistContentDescription
            },
        elevation = AppTheme.elevation.card,
        borderColor = colors.outline.copy(alpha = 0.2f),
    ) {
        Column(
            modifier = Modifier.padding(s.lg),
            verticalArrangement = Arrangement.spacedBy(s.md),
        ) {
            SectionHeaderMolecule(
                title = tracklistTitle,
                action = {
                    AppText(
                        text = trackCount,
                        style = AppTheme.typography.labelSmall,
                        color = colors.onSurfaceVariant,
                    )
                },
            )

            if (tracks.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = s.xl)
                        .testTag("empty_tracklist_message"),
                    contentAlignment = Alignment.Center,
                ) {
                    AppText(
                        text = emptyTracklistMessage,
                        style = AppTheme.typography.bodyLarge,
                        color = colors.onSurfaceVariant,
                    )
                }
            } else {
                Column(verticalArrangement = Arrangement.spacedBy(s.sm)) {
                    tracks.forEachIndexed { index, track ->
                        TrackListItemMolecule(
                            number = index + 1,
                            title = track.name,
                            duration = track.duration,
                        )
                    }
                }
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(s.sm),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("add_track_form")
                    .semantics {
                        contentDescription = addTrackFormContentDescription
                    }
            ) {
                LabeledInputFieldMolecule(
                    label = trackNameLabel,
                    value = trackName,
                    onValueChange = { trackName = it },
                    placeholder = trackNamePlaceholder,
                    surfaceStyle = AppInputSurfaceStyle.Elevated,
                    inputModifier = Modifier
                        .testTag("track_name_input")
                        .semantics {
                            contentDescription = trackNameInputContentDescription
                        }
                )

                trackNameError?.let {
                    AppText(
                        text = it,
                        style = AppTheme.typography.bodySmall,
                        color = colors.error,
                    )
                }

                LabeledInputFieldMolecule(
                    label = trackDurationLabel,
                    value = trackDuration,
                    onValueChange = { trackDuration = it },
                    placeholder = trackDurationPlaceholder,
                    surfaceStyle = AppInputSurfaceStyle.Elevated,
                    inputModifier = Modifier
                        .testTag("track_duration_input")
                        .semantics {
                            contentDescription = trackDurationInputContentDescription
                        }
                )

                trackDurationError?.let {
                    AppText(
                        text = it,
                        style = AppTheme.typography.bodySmall,
                        color = colors.error,
                    )
                }

                AppSurface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { validateAndCreateTrack() }
                        .testTag("add_track_button")
                        .semantics {
                            contentDescription = addTrackButtonContentDescription
                        },
                    shape = AppTheme.shapes.roundedLg(),
                    color = colors.primary,
                    elevation = AppTheme.elevation.none,
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(s.md),
                        contentAlignment = Alignment.Center,
                    ) {
                        AppText(
                            text = addTrackButtonText,
                            style = AppTheme.typography.labelLarge,
                            color = colors.onPrimary,
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
            Track(1, "Pulse Width Highway", "4:12", 1),
            Track(2, "Chrome Mirage", "5:01", 1),
            Track(3, "Digital Sunset", "4:48", 1),
        )

        TracklistCardOrganism(
            tracks = tracks,
            modifier = Modifier.padding(AppTheme.spacing.md),
        )
    }
}