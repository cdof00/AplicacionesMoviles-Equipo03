package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.musicapp.R
import com.example.musicapp.models.Musician
import com.example.musicapp.ui.components.atoms.AppArtistDropdown
import com.example.musicapp.ui.components.atoms.AppDialog
import com.example.musicapp.ui.components.atoms.AppDropdown
import com.example.musicapp.ui.components.atoms.AppInputSurfaceStyle
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.components.molecules.DetailTopBarMolecule
import com.example.musicapp.ui.components.molecules.LabeledInputFieldMolecule
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
    var validTitle by rememberSaveable { mutableStateOf(true) }
    var validCover by rememberSaveable { mutableStateOf(true) }
    var validReleaseDate by rememberSaveable { mutableStateOf(true) }
    var validDescription by rememberSaveable { mutableStateOf(true) }
    var validArtist by rememberSaveable { mutableStateOf(true) }
    var validGenre by rememberSaveable { mutableStateOf(true) }
    var validRecordLabel by rememberSaveable { mutableStateOf(true) }
    var validUrl by rememberSaveable { mutableStateOf(true) }

    val dialogTitle = "Error"

    val dialogTextTitle = stringResource(id = R.string.album_title_required_error)
    val dialogTextDescription = stringResource(id = R.string.album_description_required_error)
    val dialogTextArtist = stringResource(id = R.string.album_artist_required_error)
    val dialogTextYear = stringResource(id = R.string.album_year_required_error)
    val dialogTextGenre = stringResource(id = R.string.album_genre_required_error)
    val dialogTextUrl = stringResource(id = R.string.album_url_required_error)
    val dialogTextArtwork = stringResource(id = R.string.album_cover_required_error)
    val dialogTextLabel = stringResource(id = R.string.album_label_required_error)
    val titleSuccess = stringResource(id = R.string.album_created_success)
    val dialogSuccess = stringResource(id = R.string.album_created_success_message)

    val headerTitle = stringResource(R.string.new_release_header)
    val saveButtonTitle = stringResource(R.string.save_button)

    val titleHeader = stringResource(R.string.title_form_header)
    val descriptionHeader = stringResource(R.string.description_form_header)
    val artistHeader = stringResource(R.string.artist_form_header)
    val yearHeader = stringResource(R.string.year_form_header)
    val genreHeader = stringResource(R.string.genre_form_header)
    val artworkHeader = stringResource(R.string.cover_form_header)
    val recordLabelHeader = stringResource(R.string.label_form_header)

    val titlePlaceholder = stringResource(R.string.title_placeholder)
    val descriptionPlaceholder = stringResource(R.string.description_placeholder)
    val yearPlaceholder = "2026"
    val artworkPlaceholder = "https://example.com/cover.jpg"

    if(idCreatedAlbum != 0){
        AppDialog(
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
            dialogTitle= titleSuccess,
            dialogText= dialogSuccess,
            modifier = Modifier
                .testTag("album_creation_success")
                .semantics {
                    contentDescription = dialogTitle
                },
        )

    }
    if(!validTitle){
        AppDialog(
            onDismissRequest={validTitle = true},
            onConfirmation={validTitle = true},
            dialogTitle= dialogTitle,
            dialogText=dialogTextTitle,
            modifier = Modifier
                .testTag("album_title_error")
                .semantics {
                    contentDescription = dialogTitle
                },
        )
    }
    if(!validCover){
        AppDialog(
            onDismissRequest={validCover = true},
            onConfirmation={validCover = true},
            dialogTitle= dialogTitle,
            dialogText=dialogTextArtwork,
            modifier = Modifier
                .testTag("album_cover_error")
                .semantics {
                    contentDescription = dialogTitle
                },
        )
    }
    if(!validUrl){
        AppDialog(
            onDismissRequest={validUrl = true},
            onConfirmation={validUrl = true},
            dialogTitle= dialogTitle,
            dialogText=dialogTextUrl,
            modifier = Modifier
                .testTag("album_url_error")
                .semantics {
                    contentDescription = dialogTitle
                },
        )
    }
    if(!validReleaseDate){
        AppDialog(
            onDismissRequest={validReleaseDate = true},
            onConfirmation={validReleaseDate = true},
            dialogTitle= dialogTitle,
            dialogText=dialogTextYear,
            modifier = Modifier
                .testTag("album_date_error")
                .semantics {
                    contentDescription = dialogTitle
                },
        )
    }
    if(!validDescription){
        AppDialog(
            onDismissRequest={validDescription = true},
            onConfirmation={validDescription = true},
            dialogTitle= dialogTitle,
            dialogText=dialogTextDescription,
            modifier = Modifier
                .testTag("album_description_error")
                .semantics {
                    contentDescription = dialogTitle
                },
        )
    }
    if(!validArtist){
        AppDialog(
            onDismissRequest={validArtist = true},
            onConfirmation={validArtist = true},
            dialogTitle= dialogTitle,
            dialogText=dialogTextArtist,
            modifier = Modifier
                .testTag("album_artist_error")
                .semantics {
                    contentDescription = dialogTitle
                },
        )
    }
    if(!validGenre){
        AppDialog(
            onDismissRequest={validGenre = true},
            onConfirmation={validGenre = true},
            dialogTitle= dialogTitle,
            dialogText=dialogTextGenre,
            modifier = Modifier
                .testTag("album_genre_error")
                .semantics {
                    contentDescription = dialogTitle
                },
        )
    }
    if(!validRecordLabel){
        AppDialog(
            onDismissRequest={validRecordLabel = true},
            onConfirmation={validRecordLabel = true},
            dialogTitle= dialogTitle,
            dialogText=dialogTextLabel,
            modifier = Modifier
                .testTag("album_label_error")
                .semantics {
                    contentDescription = dialogTitle
                },
        )
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(horizontal = s.xl)
            .testTag("create_album_form"),
        contentPadding = PaddingValues(bottom = s.xxl),
        verticalArrangement = Arrangement.spacedBy(s.lg),
    ) {
        item {
            DetailTopBarMolecule(
                title = headerTitle,
                onBackClick = onClose,
                onTrailingClick = {},
                leadingIcon = Icons.Outlined.Close,
                leadingContentDescription = "Close",
                customTrailing = {
                    AppText(
                        text = saveButtonTitle,
                        style = AppTheme.typography.labelLarge,
                        color = colors.primary,
                        modifier = Modifier
                            .testTag("create_album_button")
                            .padding(end = s.sm)
                            .clickable(onClick = {
                                if(albumTitle.isNotEmpty() && artwork.isNotEmpty() && year.isNotEmpty() && description.isNotEmpty() && uiState.artist.musicianId != 0 && uiState.genre.isNotEmpty() && uiState.recordLabel.isNotEmpty()){
                                    viewModel.createAlbum()
                                }

                                if(albumTitle.isEmpty()){
                                    validTitle = false
                                }
                                else if(description.isEmpty()){
                                    validDescription = false
                                }
                                else if(uiState.artist.musicianId == 0){
                                    validArtist = false
                                }
                                else if(year.isEmpty()){
                                    validReleaseDate = false
                                }
                                else if(uiState.genre.isEmpty()){
                                    validGenre = false
                                }
                                else if(artwork.isEmpty()){
                                    validCover = false
                                }
                                else if(!artwork.matches("""https?://[\w\d\-\.]+\.[a-z]{2,6}(/[\w\d\-\./?%&=]*)?""".toRegex())){
                                    validUrl = false
                                }
                                else if(uiState.recordLabel.isEmpty()){
                                    validRecordLabel = false
                                }
                            }),
                    )
                },

            )
        }
        item {
            LabeledInputFieldMolecule(
                label = titleHeader,
                value = albumTitle,
                onValueChange = {
                    uiState.albumTitle = it
                    albumTitle = uiState.albumTitle
                                },
                placeholder = titlePlaceholder,
                surfaceStyle = AppInputSurfaceStyle.Elevated,
                inputModifier = Modifier.testTag("album_title_input").semantics {
                    contentDescription = titleHeader
                },
            )
        }
        item {
            LabeledInputFieldMolecule(
                label = descriptionHeader,
                value = description,
                onValueChange = {
                    uiState.description = it
                    description = uiState.description
                                },
                placeholder = descriptionPlaceholder,
                surfaceStyle = AppInputSurfaceStyle.Elevated,
                inputModifier = Modifier.testTag("album_description_input").semantics {
                    contentDescription = descriptionHeader
                }
            )
        }
        item {
            AppArtistDropdown(
                label = artistHeader,
                search = "",
                value = uiState.artist,
                artists = musicians,
                onValueChange = {
                    uiState.artist = it
                },
                modifier = Modifier.testTag("album_artist_input").semantics {
                    contentDescription = artistHeader
                }
            )
        }
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(s.md),
            ) {
                LabeledInputFieldMolecule(
                    label = yearHeader,
                    value = year,
                    onValueChange = {
                        uiState.year = it
                        year = uiState.year
                                    },
                    placeholder = yearPlaceholder,
                    surfaceStyle = AppInputSurfaceStyle.Elevated,
                    inputModifier = Modifier.weight(1f).testTag("album_year_input").semantics {
                        contentDescription = yearHeader
                    },
                )
            }
        }
        item {
            AppDropdown(
                label = genreHeader,
                search = "",
                value = uiState.genre,
                list = listOf("Classical","Salsa","Rock","Folk"),
                onValueChange = {
                    uiState.genre = it
                },
                modifier = Modifier.testTag("album_genre_input").semantics {
                    contentDescription = genreHeader
                },
            )
        }

        item {
            LabeledInputFieldMolecule(
                label = artworkHeader,
                value = artwork,
                onValueChange = {
                    uiState.artwork = it
                    artwork = uiState.artwork
                },
                placeholder = artworkPlaceholder,
                surfaceStyle = AppInputSurfaceStyle.Elevated,
                inputModifier = Modifier.testTag("album_artwork_input").semantics {
                    contentDescription = artworkHeader
                }
            )
        }
        item {
            AppDropdown(
                label = recordLabelHeader,
                search = "",
                value = uiState.recordLabel,
                list = listOf("Sony Music", "EMI", "Discos Fuentes", "Elektra", "Fania Records"),
                onValueChange = {
                    uiState.recordLabel = it
                },
                modifier = Modifier.testTag("album_label_input").semantics {
                    contentDescription = recordLabelHeader
                }
            )
        }
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
