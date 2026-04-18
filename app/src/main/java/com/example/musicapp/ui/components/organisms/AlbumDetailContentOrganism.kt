package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.musicapp.ui.components.molecules.AlbumMetaHeaderMolecule
import com.example.musicapp.ui.components.molecules.DetailTopBarMolecule
import com.example.musicapp.ui.components.molecules.InfoStatCardMolecule
import com.example.musicapp.ui.screens.album.AlbumDetailUiModel
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun AlbumDetailContentOrganism(
    ui: AlbumDetailUiModel,
    innerPadding: PaddingValues,
    onBackClick: () -> Unit,
    onMenuClick: () -> Unit,
    onPlayClick: () -> Unit,
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
            )
        }
        item {
            AlbumHeroSectionOrganism(
                coverVariantIndex = ui.coverVariantIndex,
                onPlayClick = onPlayClick,
            )
        }
        item {
            AlbumMetaHeaderMolecule(
                title = ui.title,
                artist = ui.artist,
                year = ui.year,
                format = ui.format,
            )
        }
        item {
            TracklistCardOrganism(
                totalTracksLabel = ui.totalTracksLabel,
                totalDurationLabel = ui.totalDurationLabel,
                tracks = ui.tracks,
            )
        }
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(s.md),
            ) {
                InfoStatCardMolecule(
                    label = "Matrix",
                    value = ui.matrixCode,
                    modifier = Modifier.weight(1f),
                )
                InfoStatCardMolecule(
                    label = "Condition",
                    value = ui.condition,
                    highlightValuePrimary = true,
                    modifier = Modifier.weight(1f),
                )
            }
        }
    }
}
