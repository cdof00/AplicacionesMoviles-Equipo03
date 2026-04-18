package com.example.musicapp.ui.components.atoms

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme
import com.example.musicapp.ui.theme.theme.OpacityTokens

enum class AppIconButtonVariant {
    Primary,
    Secondary,
    Ghost,
    Outlined,
}

@Composable
fun AppIconButton(
    imageVector: ImageVector,
    contentDescription: String?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    variant: AppIconButtonVariant = AppIconButtonVariant.Ghost,
    enabled: Boolean = true,
    sizeKey: IconSizeKey = IconSizeKey.Medium,
) {
    val colors = AppTheme.colors
    val comp = AppTheme.dimensions.component
    val dim = AppTheme.dimensions.icon
    val iconSize = when (sizeKey) {
        IconSizeKey.ExtraSmall -> dim.xs
        IconSizeKey.Small -> dim.sm
        IconSizeKey.Medium -> dim.md
        IconSizeKey.Large -> dim.lg
        IconSizeKey.ExtraLarge -> dim.xl
    }
    val mod = modifier.size(comp.minTouchTarget)
    val interaction = remember { MutableInteractionSource() }

    when (variant) {
        AppIconButtonVariant.Outlined -> OutlinedIconButton(
            onClick = onClick,
            modifier = mod,
            enabled = enabled,
            shape = CircleShape,
            border = BorderStroke(AppTheme.borders.thin, colors.outlineSubtle),
            interactionSource = interaction,
            colors = IconButtonDefaults.outlinedIconButtonColors(
                contentColor = colors.onSurface,
                disabledContentColor = colors.onSurface.copy(alpha = OpacityTokens.disabledContent),
            ),
        ) {
            AppIcon(imageVector, contentDescription, tint = colors.onSurface, sizeKey = sizeKey)
        }
        else -> {
            val container: Color
            val content: Color
            when (variant) {
                AppIconButtonVariant.Primary -> {
                    container = colors.primary
                    content = colors.onPrimary
                }
                AppIconButtonVariant.Secondary -> {
                    container = colors.surfaceContainerHigh
                    content = colors.onSurface
                }
                else -> {
                    container = Color.Transparent
                    content = colors.onSurface
                }
            }
            IconButton(
                onClick = onClick,
                modifier = mod,
                enabled = enabled,
                interactionSource = interaction,
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = container,
                    contentColor = content,
                    disabledContainerColor = container.copy(alpha = OpacityTokens.disabledContainer),
                    disabledContentColor = content.copy(alpha = OpacityTokens.disabledContent),
                ),
            ) {
                AppIcon(imageVector, contentDescription, tint = content, sizeKey = sizeKey)
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun AppIconButtonPreview() {
    DesignSystemPreviewSurface {
        AppIconButton(Icons.Default.Add, null, {}, variant = AppIconButtonVariant.Primary)
    }
}
