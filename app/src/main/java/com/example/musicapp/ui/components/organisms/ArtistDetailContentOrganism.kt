package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.musicapp.ui.components.molecules.DetailTopBarMolecule
import com.example.musicapp.ui.screens.artist.ArtistDetailUiModel
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun ArtistDetailContentOrganism(
    ui: ArtistDetailUiModel,
    innerPadding: PaddingValues,
    onBackClick: () -> Unit,
    onSearchClick: () -> Unit,
    onMenuClick: () -> Unit,
    onViewArchiveClick: () -> Unit,
    onSeeAllAlbumsClick: () -> Unit,
    onAlbumClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val s = AppTheme.spacing
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
                title = ui.screenTitle,
                onBackClick = onBackClick,
                onTrailingClick = onMenuClick,
                trailingIcon = Icons.Outlined.MoreVert,
                trailingContentDescription = "More",
                leadingTrailingIcon = Icons.Outlined.Search,
                leadingTrailingContentDescription = "Search",
                onLeadingTrailingClick = onSearchClick,
            )
        }
        item {
            ArtistHeroSectionOrganism(
                featuredLabel = ui.featuredLabel,
                name = ui.name,
                curatorRatingLabel = ui.curatorRatingLabel,
                vaultLabel = ui.vaultLabel,
                heroCoverVariantIndex = ui.heroCoverVariantIndex,
            )
        }
        item {
            ArtistBioCardOrganism(
                title = ui.bioTitle,
                body = ui.bioBody,
                originLabel = ui.originLabel,
                originValue = ui.originValue,
                genreLabel = ui.genreLabel,
                genreValue = ui.genreValue,
            )
        }
        item {
            ArtistAwardsCardOrganism(
                title = ui.awardsTitle,
                awards = ui.awards,
                viewArchiveLabel = ui.viewArchiveLabel,
                onViewArchiveClick = onViewArchiveClick,
            )
        }
        item {
            ArtistTopAlbumsSectionOrganism(
                sectionTitle = ui.topAlbumsSectionTitle,
                seeAllLabel = ui.seeAllLabel,
                albums = ui.topAlbums,
                onSeeAllClick = onSeeAllAlbumsClick,
                onAlbumClick = onAlbumClick,
            )
        }
    }
}
