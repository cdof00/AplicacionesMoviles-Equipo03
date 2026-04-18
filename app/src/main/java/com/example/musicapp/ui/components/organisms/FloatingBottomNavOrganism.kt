package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LibraryMusic
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.atoms.AppSurface
import com.example.musicapp.ui.components.molecules.BottomNavItemMolecule
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme

data class NavDestination(
    val icon: ImageVector,
    val label: String?,
)

@Composable
fun FloatingBottomNavOrganism(
    destinations: List<NavDestination>,
    selectedIndex: Int,
    onSelect: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val s = AppTheme.spacing
    val shapes = AppTheme.shapes
    val colors = AppTheme.colors
    val shape = shapes.roundedFull()

    AppSurface(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = s.xl, vertical = s.sm),
        shape = shape,
        color = colors.surfaceContainerLow.copy(alpha = 0.82f),
        borderColor = colors.glassEdge,
        elevation = AppTheme.elevation.floating,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(s.md),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            destinations.forEachIndexed { index, dest ->
                BottomNavItemMolecule(
                    icon = dest.icon,
                    label = dest.label,
                    selected = index == selectedIndex,
                    onClick = { onSelect(index) },
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun FloatingBottomNavOrganismPreview() {
    DesignSystemPreviewSurface {
        FloatingBottomNavOrganism(
            destinations = listOf(
                NavDestination(Icons.Outlined.Home, "Home"),
                NavDestination(Icons.Outlined.Search, null),
                NavDestination(Icons.Outlined.LibraryMusic, "Lib"),
            ),
            selectedIndex = 0,
            onSelect = {},
        )
    }
}
