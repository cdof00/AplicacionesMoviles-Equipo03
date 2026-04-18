package com.example.musicapp.ui.components.molecules

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.musicapp.ui.components.atoms.AppIcon
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.components.atoms.IconSizeKey
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun BottomNavItemMolecule(
    icon: ImageVector,
    label: String?,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val colors = AppTheme.colors
    val s = AppTheme.spacing
    val interaction = remember { MutableInteractionSource() }
    val tint = if (selected) colors.primary else colors.onSurface.copy(alpha = 0.72f)
    Column(
        modifier = modifier
            .clip(AppTheme.shapes.roundedMd())
            .clickable(interactionSource = interaction, indication = null, onClick = onClick)
            .padding(horizontal = s.md, vertical = s.xs),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AppIcon(icon, contentDescription = label, tint = tint, sizeKey = IconSizeKey.Medium)
        Box(
            Modifier
                .padding(top = s.xs)
                .size(s.sm),
            contentAlignment = Alignment.Center,
        ) {
            if (selected) {
                Box(
                    Modifier
                        .size(s.xs)
                        .clip(CircleShape)
                        .background(colors.primary),
                )
            }
        }
        if (label != null) {
            AppText(
                label,
                style = AppTheme.typography.labelSmall,
                color = tint,
                modifier = Modifier.padding(top = s.xxs),
            )
        }
    }
}
