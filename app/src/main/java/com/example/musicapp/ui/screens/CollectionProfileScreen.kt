package com.example.musicapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.musicapp.ui.components.atoms.AppSurface
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun CollectionProfileScreen(
    innerPadding: PaddingValues,
    onOpenCollectorDetail: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val s = AppTheme.spacing
    val colors = AppTheme.colors
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(horizontal = s.xl, vertical = s.md),
    ) {
        AppText(
            text = "Collectors",
            style = AppTheme.typography.headlineSmall,
            color = colors.onBackground,
            modifier = Modifier.padding(bottom = s.lg),
        )
        AppSurface(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = onOpenCollectorDetail),
            shape = AppTheme.shapes.roundedLg(),
            color = colors.surfaceContainer.copy(alpha = 0.92f),
            borderColor = colors.outlineSubtle,
            elevation = AppTheme.elevation.raised,
        ) {
            Column(Modifier.padding(s.lg)) {
                AppText(
                    text = "Audiophile Elite",
                    style = AppTheme.typography.titleLarge,
                    color = colors.onSurface,
                )
                AppText(
                    text = "1,240 LP's in Crate • Portland, OR",
                    style = AppTheme.typography.bodySmall,
                    color = colors.onSurfaceVariant,
                    modifier = Modifier.padding(top = s.xs),
                )
            }
        }
    }
}
