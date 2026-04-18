package com.example.musicapp.ui.components.atoms

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme
import com.example.musicapp.ui.theme.theme.OpacityTokens

enum class AppButtonVariant {
    Primary,
    Secondary,
    Ghost,
    Outlined,
}

@Composable
fun AppButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    variant: AppButtonVariant = AppButtonVariant.Primary,
    enabled: Boolean = true,
) {
    val colors = AppTheme.colors
    val shapes = AppTheme.shapes
    val comp = AppTheme.dimensions.component
    val b = AppTheme.borders
    val shape = shapes.roundedLg()
    val interaction = remember { MutableInteractionSource() }

    val container: Color
    val content: Color
    val border: BorderStroke?
    when (variant) {
        AppButtonVariant.Primary -> {
            container = colors.primary
            content = colors.onPrimary
            border = null
        }
        AppButtonVariant.Secondary -> {
            container = colors.surfaceContainerHigh
            content = colors.onSurface
            border = null
        }
        AppButtonVariant.Ghost -> {
            container = Color.Transparent
            content = colors.onSurface
            border = null
        }
        AppButtonVariant.Outlined -> {
            container = Color.Transparent
            content = colors.onSurface
            border = BorderStroke(b.thin, colors.outlineSubtle)
        }
    }

    val mod = modifier.heightIn(min = comp.minTouchTarget)
    val contentPadding = PaddingValues(
        horizontal = AppTheme.spacing.lg,
        vertical = AppTheme.spacing.sm,
    )

    when (variant) {
        AppButtonVariant.Ghost -> TextButton(
            onClick = onClick,
            modifier = mod,
            enabled = enabled,
            shape = shape,
            interactionSource = interaction,
            colors = ButtonDefaults.textButtonColors(
                contentColor = content,
                disabledContentColor = content.copy(alpha = OpacityTokens.disabledContent),
            ),
            contentPadding = contentPadding,
        ) { AppText(text, style = AppTheme.typography.labelLarge, color = content) }

        AppButtonVariant.Outlined -> OutlinedButton(
            onClick = onClick,
            modifier = mod,
            enabled = enabled,
            shape = shape,
            border = border!!,
            interactionSource = interaction,
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = content,
                disabledContentColor = content.copy(alpha = OpacityTokens.disabledContent),
            ),
            contentPadding = contentPadding,
        ) { AppText(text, style = AppTheme.typography.labelLarge, color = content) }

        else -> Button(
            onClick = onClick,
            modifier = mod,
            enabled = enabled,
            shape = shape,
            interactionSource = interaction,
            colors = ButtonDefaults.buttonColors(
                containerColor = container,
                contentColor = content,
                disabledContainerColor = container.copy(alpha = OpacityTokens.disabledContainer),
                disabledContentColor = content.copy(alpha = OpacityTokens.disabledContent),
            ),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = AppTheme.spacing.xxs),
            contentPadding = contentPadding,
        ) { AppText(text, style = AppTheme.typography.labelLarge, color = content) }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun AppButtonPreview() {
    DesignSystemPreviewSurface {
        AppButton("Primary", {}, variant = AppButtonVariant.Primary)
    }
}
