package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircleOutline
import androidx.compose.material.icons.outlined.Album
import androidx.compose.material.icons.outlined.Group
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.atoms.AppSurface
import com.example.musicapp.ui.components.molecules.CatalogNavItemMolecule
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme

data class CatalogNavDestination(
    val icon: ImageVector,
    val label: String,
)

private val defaultCatalogNavDestinations: List<CatalogNavDestination> = listOf(
    CatalogNavDestination(Icons.Outlined.Album, "ALBUMS"),
    CatalogNavDestination(Icons.Outlined.Person, "ARTISTS"),
    CatalogNavDestination(Icons.Outlined.Group, "COLLECTORS"),
    CatalogNavDestination(Icons.Outlined.AddCircleOutline, "ADD"),
)

@Composable
fun CatalogBottomNavBarOrganism(
    selectedIndex: Int,
    onSelect: (Int) -> Unit,
    modifier: Modifier = Modifier,
    destinations: List<CatalogNavDestination> = defaultCatalogNavDestinations,
) {
    val s = AppTheme.spacing
    val shapes = AppTheme.shapes
    val colors = AppTheme.colors
    AppSurface(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = s.xl, vertical = s.sm),
        shape = shapes.roundedFull(),
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
                CatalogNavItemMolecule(
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
private fun CatalogBottomNavBarOrganismPreview() {
    DesignSystemPreviewSurface {
        CatalogBottomNavBarOrganism(
            selectedIndex = 0,
            onSelect = {},
        )
    }
}
