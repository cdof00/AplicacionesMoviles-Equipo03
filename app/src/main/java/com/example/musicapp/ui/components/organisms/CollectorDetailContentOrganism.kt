package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.musicapp.R
import com.example.musicapp.ui.components.molecules.DetailTopBarMolecule
import com.example.musicapp.ui.components.molecules.GenreChipRowMolecule
import com.example.musicapp.ui.components.molecules.SectionHeaderMolecule
import com.example.musicapp.ui.screens.collector.CollectorDetailUiModel
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun CollectorDetailContentOrganism(
    ui: CollectorDetailUiModel,
    innerPadding: PaddingValues,
    onBackClick: () -> Unit,
    onShareClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val s = AppTheme.spacing
    val colors = AppTheme.colors

    val musicalTaste = stringResource(R.string.musical_taste)
    val topGenres = stringResource(R.string.top_genres)
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(horizontal = s.xl),
    ) {
        item {
            DetailTopBarMolecule(
                title = ui.screenTitle,
                onBackClick = onBackClick,
                onTrailingClick = onShareClick,
            )
        }
        item {
            CollectorHeroSectionOrganism(
                collectorName = ui.collectorName,
                metadata = ui.metadata,
                avatarInitials = ui.avatarInitials,
                eliteBadgeLabel = ui.eliteBadgeLabel,
                avatarGradientIndex = ui.heroAvatarGradientIndex,
                modifier = Modifier.padding(top = s.sm),
            )
        }
        item {
            CollectorActionsRowOrganism(
                followLabel = ui.followLabel,
                onFollowClick = {},
                onMessageClick = {},
            )
        }
        item {
            SectionHeaderMolecule(
                title = musicalTaste,
                action = {
                    AppText(
                        text = topGenres,
                        style = AppTheme.typography.labelSmall,
                        color = colors.primary,
                    )
                },
                modifier = Modifier.padding(top = s.xl, bottom = s.sm),
            )
        }
        item {
            GenreChipRowMolecule(genres = ui.genres)
        }
        item {
            FavoriteArtistsSectionOrganism(
                artists = ui.artists,
                modifier = Modifier.padding(top = s.xl),
            )
        }
        item {
            RecentlyAddedSectionOrganism(
                albums = ui.recentAlbums,
                modifier = Modifier.padding(top = s.xl, bottom = s.xxl),
            )
        }
    }
}
