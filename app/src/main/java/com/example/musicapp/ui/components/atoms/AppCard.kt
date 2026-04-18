package com.example.musicapp.ui.components.atoms

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme

enum class AppCardVariant {
    Flat,
    Elevated,
    Interactive,
}

@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    shape: Shape = AppTheme.shapes.roundedLg(),
    variant: AppCardVariant = AppCardVariant.Elevated,
    onClick: (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    val colors = AppTheme.colors
    val el = AppTheme.elevation
    val spec = when (variant) {
        AppCardVariant.Flat -> el.none
        AppCardVariant.Elevated, AppCardVariant.Interactive -> el.card
    }
    val interaction = remember { MutableInteractionSource() }
    val baseMod = if (variant == AppCardVariant.Interactive && onClick != null) {
        modifier.clickable(
            interactionSource = interaction,
            indication = null,
            onClick = onClick,
        )
    } else {
        modifier
    }

    AppSurface(
        modifier = baseMod,
        shape = shape,
        color = colors.surfaceContainerHigh,
        borderColor = colors.glassEdge,
        elevation = spec,
    ) {
        content()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun AppCardPreview() {
    DesignSystemPreviewSurface {
        AppCard {
            AppText("Elevated", modifier = Modifier.padding(AppTheme.spacing.md))
        }
    }
}
