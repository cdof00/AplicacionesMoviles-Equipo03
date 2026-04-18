package com.example.musicapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import com.example.musicapp.ui.components.atoms.AppButton
import com.example.musicapp.ui.components.atoms.AppButtonVariant
import com.example.musicapp.ui.components.atoms.AppDivider
import com.example.musicapp.ui.components.atoms.AppIconButton
import com.example.musicapp.ui.components.atoms.AppIconButtonVariant
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.components.molecules.ButtonGroupMolecule
import com.example.musicapp.ui.components.molecules.LabeledPillMolecule
import com.example.musicapp.ui.components.molecules.SectionHeaderMolecule
import com.example.musicapp.ui.components.molecules.ToolbarAction
import com.example.musicapp.ui.components.organisms.ActionToolbarCardOrganism
import com.example.musicapp.ui.components.organisms.ColorPaletteOrganism
import com.example.musicapp.ui.components.organisms.ComponentShowcaseGridOrganism
import com.example.musicapp.ui.components.organisms.FloatingBottomNavOrganism
import com.example.musicapp.ui.components.organisms.NavDestination
import com.example.musicapp.ui.components.organisms.SearchPanelOrganism
import com.example.musicapp.ui.components.organisms.SettingsPanelCardOrganism
import com.example.musicapp.ui.components.organisms.TokenShowcaseCardOrganism
import com.example.musicapp.ui.components.organisms.TypographySpecimenOrganism
import com.example.musicapp.ui.components.templates.DesignSystemScaffoldTemplate
import com.example.musicapp.ui.screens.showcase.ShowcaseModels
import com.example.musicapp.ui.theme.theme.AppTheme
import com.example.musicapp.ui.theme.theme.horizontalScreenPadding
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LibraryMusic
import androidx.compose.material.icons.outlined.Search

@Composable
fun DesignSystemShowcaseScreen(modifier: Modifier = Modifier) {
    var query by remember { mutableStateOf("") }
    var navIndex by remember { mutableIntStateOf(0) }
    var filterIndex by remember { mutableIntStateOf(0) }
    var groupIndex by remember { mutableIntStateOf(0) }
    val s = AppTheme.spacing

    val destinations = remember {
        listOf(
            NavDestination(Icons.Outlined.Home, "Home"),
            NavDestination(Icons.Outlined.Search, null),
            NavDestination(Icons.Outlined.LibraryMusic, "Library"),
        )
    }

    DesignSystemScaffoldTemplate(
        modifier = modifier,
        bottomBar = {
            FloatingBottomNavOrganism(
                destinations = destinations,
                selectedIndex = navIndex,
                onSelect = { navIndex = it },
            )
        },
        floatingActionButton = {
            AppIconButton(
                imageVector = Icons.Filled.Add,
                contentDescription = "Primary action",
                onClick = { },
                variant = AppIconButtonVariant.Primary,
            )
        },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .horizontalScreenPadding()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(s.xl),
            contentPadding = PaddingValues(
                top = s.lg,
                bottom = s.xxl + s.xxl + s.xl,
            ),
        ) {
            item {
                SectionHeaderMolecule(
                    title = "Design system",
                    subtitle = "Premium dark foundation · tokens first",
                )
            }
            item {
                ActionToolbarCardOrganism(
                    actions = listOf(
                        ToolbarAction(Icons.Outlined.Settings, "Settings") {},
                        ToolbarAction(Icons.Outlined.Notifications, "Alerts") {},
                        ToolbarAction(Icons.Outlined.MoreVert, "More") {},
                    ),
                )
            }
            item {
                AppText("Color", style = AppTheme.typography.titleMedium, color = AppTheme.colors.primary)
                ColorPaletteOrganism(Modifier.padding(top = s.sm))
            }
            item {
                AppText("Typography", style = AppTheme.typography.titleMedium, color = AppTheme.colors.primary)
                TypographySpecimenOrganism(Modifier.padding(top = s.sm))
            }
            item {
                AppText("Buttons", style = AppTheme.typography.titleMedium, color = AppTheme.colors.primary)
                Column(
                    verticalArrangement = Arrangement.spacedBy(s.sm),
                    modifier = Modifier.padding(top = s.sm),
                ) {
                    AppButton("Primary", {}, variant = AppButtonVariant.Primary)
                    AppButton("Secondary", {}, variant = AppButtonVariant.Secondary)
                    AppButton("Ghost", {}, variant = AppButtonVariant.Ghost)
                    AppButton("Outlined", {}, variant = AppButtonVariant.Outlined)
                    ButtonGroupMolecule(
                        options = ShowcaseModels.buttonGroupOptions,
                        selectedIndex = groupIndex,
                        onSelect = { groupIndex = it },
                    )
                }
            }
            item {
                LabeledPillMolecule(
                    label = "Catalog",
                    pillLabel = "New",
                    onPillClick = { },
                )
            }
            item {
                SearchPanelOrganism(
                    query = query,
                    onQueryChange = { query = it },
                    filterLabels = ShowcaseModels.filterLabels,
                    selectedFilterIndex = filterIndex,
                    onFilterSelect = { filterIndex = it },
                )
            }
            item {
                SettingsPanelCardOrganism(
                    title = "Appearance",
                    rows = ShowcaseModels.settingsRows,
                )
            }
            item {
                Column(verticalArrangement = Arrangement.spacedBy(s.sm)) {
                    ShowcaseModels.tokenCards.forEach { (name, desc) ->
                        TokenShowcaseCardOrganism(tokenName = name, description = desc)
                    }
                }
            }
            item {
                AppDivider()
            }
            item {
                AppText("Atom grid", style = AppTheme.typography.titleMedium, color = AppTheme.colors.primary)
                ComponentShowcaseGridOrganism(count = 4) { index ->
                    AppText(
                        "Slot ${index + 1}",
                        style = AppTheme.typography.labelMedium,
                        color = AppTheme.colors.onSurfaceVariant,
                    )
                }
            }
        }
    }
}
