package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.atoms.AppIcon
import com.example.musicapp.ui.components.atoms.IconSizeKey
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme
import com.example.musicapp.ui.theme.theme.appShadow

@Composable
fun FloatingAddButtonOrganism(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    imageVector: ImageVector = Icons.Filled.Add,
    contentDescription: String? = "Add",
) {
    val colors = AppTheme.colors
    val comp = AppTheme.dimensions.component
    Box(
        modifier = modifier
            .size(comp.fabSize)
            .appShadow(CircleShape, AppTheme.elevation.glowPrimary)
            .clip(CircleShape)
            .background(colors.primary)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        AppIcon(
            imageVector = imageVector,
            contentDescription = contentDescription,
            tint = colors.onPrimary,
            sizeKey = IconSizeKey.Large,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun FloatingAddButtonOrganismPreview() {
    DesignSystemPreviewSurface {
        FloatingAddButtonOrganism(onClick = {})
    }
}
