package com.example.musicapp.ui.components.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme
import com.example.musicapp.ui.theme.theme.OpacityTokens

enum class AppChipVariant {
    Default,
    Selected,
    Neutral,
    Accent,
}

@Composable
fun AppChip(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    variant: AppChipVariant = AppChipVariant.Default,
    enabled: Boolean = true,
) {
    val colors = AppTheme.colors
    val inter = AppTheme.interaction
    val shapes = AppTheme.shapes
    val s = AppTheme.spacing
    val comp = AppTheme.dimensions.component
    val b = AppTheme.borders
    val interaction = remember { MutableInteractionSource() }
    val shape = shapes.roundedFull()

    val bg: Color
    val fg: Color
    val showAccentBorder: Boolean
    when (variant) {
        AppChipVariant.Default -> {
            bg = colors.surfaceContainer
            fg = colors.onSurface
            showAccentBorder = false
        }
        AppChipVariant.Selected -> {
            bg = inter.selectedContainer
            fg = inter.selectedOnContainer
            showAccentBorder = true
        }
        AppChipVariant.Neutral -> {
            bg = colors.surfaceContainerLow
            fg = colors.onSurfaceVariant
            showAccentBorder = false
        }
        AppChipVariant.Accent -> {
            bg = colors.primary.copy(alpha = 0.15f)
            fg = colors.primary
            showAccentBorder = false
        }
    }

    Row(
        modifier = modifier
            .heightIn(min = comp.chipHeight)
            .clip(shape)
            .then(
                if (showAccentBorder) {
                    Modifier.border(b.thin, colors.primary.copy(alpha = OpacityTokens.borderSubtle), shape)
                } else {
                    Modifier
                }
            )
            .background(if (enabled) bg else bg.copy(alpha = OpacityTokens.disabledContainer))
            .clickable(
                interactionSource = interaction,
                indication = null,
                enabled = enabled,
                onClick = onClick,
            )
            .padding(horizontal = s.md, vertical = s.xs),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        AppText(
            text = label,
            style = AppTheme.typography.labelMedium,
            color = if (enabled) fg else fg.copy(alpha = OpacityTokens.disabledContent),
        )
    }
}

@Composable
fun AppTag(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    variant: AppChipVariant = AppChipVariant.Neutral,
) {
    AppChip(label = label, onClick = onClick, modifier = modifier, variant = variant)
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun AppChipPreview() {
    DesignSystemPreviewSurface {
        AppChip("Selected", {}, variant = AppChipVariant.Selected)
    }
}
