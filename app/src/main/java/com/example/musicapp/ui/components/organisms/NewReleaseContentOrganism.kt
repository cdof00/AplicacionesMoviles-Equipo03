package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.musicapp.models.CreateTrack
import com.example.musicapp.models.Musician
import com.example.musicapp.ui.components.atoms.AppAlbumDialog
import com.example.musicapp.ui.components.atoms.AppArtistDropdown
import com.example.musicapp.ui.components.atoms.AppDropdown
import com.example.musicapp.ui.components.atoms.AppInputSurfaceStyle
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.components.molecules.AddTrackPlaceholderRowMolecule
import com.example.musicapp.ui.components.molecules.DetailTopBarMolecule
import com.example.musicapp.ui.components.molecules.LabeledInputFieldMolecule
import com.example.musicapp.ui.components.molecules.ReleaseTrackRowMolecule
import com.example.musicapp.ui.components.molecules.TrackListSectionHeaderMolecule
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme
import com.example.musicapp.viewmodels.CreateAlbumViewModel

@Composable
fun NewReleaseContentOrganism(
    navController : NavHostController,
    viewModel: CreateAlbumViewModel,
    musicians: List<Musician>,
    isLoading: Boolean,
    innerPadding: PaddingValues,
    onClose: () -> Unit,
    onSave: () -> Unit,
    onAddTrackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {

    val s = AppTheme.spacing
    val colors = AppTheme.colors
    val b = AppTheme.borders

    val uiState by viewModel.uiState.collectAsState()
    val idCreatedAlbum by viewModel.createdAlbumId.collectAsState()

    var albumTitle by rememberSaveable { mutableStateOf("") }
    var description by rememberSaveable { mutableStateOf("") }
    var year by rememberSaveable { mutableStateOf("") }
    var artwork by rememberSaveable { mutableStateOf("") }

    if(idCreatedAlbum != 0){
        AppAlbumDialog(
            albumId = idCreatedAlbum,
            onDismissRequest={},
            onConfirmation={
                navController.navigate("album_detail/$idCreatedAlbum") {
                    launchSingleTop = true
                }
                viewModel.createdAlbumId.value = 0
                albumTitle = ""
                description = ""
                year = ""
                artwork = ""
            },
            dialogTitle= "Album created successfully",
            dialogText="This album has been created successfully. Do you want to see it?",
        )

    }

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
                            .clickable(onClick = {viewModel.createAlbum()}),
                    )
                },
            )
        }
        item {
            LabeledInputFieldMolecule(
                label = "ALBUM TITLE",
                value = albumTitle,
                onValueChange = {
                    uiState.albumTitle = it
                    albumTitle = uiState.albumTitle
                                },
                placeholder = "Title",
                surfaceStyle = AppInputSurfaceStyle.Elevated,
            )
        }
        item {
            LabeledInputFieldMolecule(
                label = "ALBUM DESCRIPTION",
                value = description,
                onValueChange = {
                    uiState.description = it
                    description = uiState.description
                                },
                placeholder = "Description",
                surfaceStyle = AppInputSurfaceStyle.Elevated,
            )
        }
        item {
            AppArtistDropdown(
                label = "ARTIST / ENSEMBLE",
                search = "",
                value = uiState.artist,
                artists = musicians,
                onValueChange = {
                    uiState.artist = it
                }
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
                    onValueChange = {
                        uiState.year = it
                        year = uiState.year
                                    },
                    placeholder = "2026",
                    surfaceStyle = AppInputSurfaceStyle.Elevated,
                    modifier = Modifier.weight(1f),
                )
            }
        }
        item {
            AppDropdown(
                label = "GENRE",
                search = "",
                value = uiState.genre,
                list = listOf("Classical","Salsa","Rock","Folk"),
                onValueChange = {
                    uiState.genre = it
                }
            )
        }

        item {
            LabeledInputFieldMolecule(
                label = "ARTWORK URL",
                value = artwork,
                onValueChange = {
                    uiState.artwork = it
                    artwork = uiState.artwork
                },
                placeholder = "URL",
                surfaceStyle = AppInputSurfaceStyle.Elevated,
            )
        }
        item {
            AppDropdown(
                label = "RECORD LABEL",
                search = "",
                value = uiState.recordLabel,
                list = listOf("Sony Music", "EMI", "Discos Fuentes", "Elektra", "Fania Records"),
                onValueChange = {
                    uiState.recordLabel = it
                }
            )
        }

//        item {
//            TrackListSectionHeaderMolecule(
//                title = "Track List",
//                subtitle = "DIGITAL CURATION — SIDE A / B",
//                watermarkNumber = uiState.tracks.size,
//            )
//        }
//        item {
//            Column(verticalArrangement = Arrangement.spacedBy(s.sm)) {
//
//                tracks.forEachIndexed { index, track ->
//                    ReleaseTrackRowMolecule(
//                        trackNumberLabel = index+1,
//                        track = track,
//                        onUpdate = { updatedTrack ->
//                            tracks[index] = updatedTrack
//                            uiState.tracks = tracks.toList()
//                        },
//                        onClick = {}
//                    )
//                }
//                AddTrackPlaceholderRowMolecule(
//                    label = "Add next track",
//                    onClick =  {tracks.add(CreateTrack("",""))},
//                )
//            }
//        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A, heightDp = 900)
@Composable
private fun NewReleaseContentOrganismPreview() {
    DesignSystemPreviewSurface {
        val s = AppTheme.spacing
        val createAlbumViewModel: CreateAlbumViewModel = viewModel()
        NewReleaseContentOrganism(
            navController = rememberNavController(),
            innerPadding = PaddingValues(top = s.sm, bottom = s.md),
            onClose = {},
            onSave = {},
            onAddTrackClick = {},
            musicians = listOf(Musician(1, "Prueba", "Imagen", "","")),
            isLoading = false,
            viewModel = createAlbumViewModel
        )
    }
}
