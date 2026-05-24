package com.example.musicapp.ui.components.atoms

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme
import com.example.musicapp.ui.theme.theme.OpacityTokens

enum class AppInputState {
    Default,
    Focused,
    Disabled,
}

enum class AppInputSurfaceStyle {
    Default,
    Elevated,
}

@Composable
fun AppInput(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    inputModifier: Modifier = Modifier,
    state: AppInputState = AppInputState.Default,
    surfaceStyle: AppInputSurfaceStyle = AppInputSurfaceStyle.Default,
    placeholder: String? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    singleLine: Boolean = true,
) {
    val colors = AppTheme.colors
    val shapes = AppTheme.shapes
    val comp = AppTheme.dimensions.component
    val s = AppTheme.spacing
    val interaction = remember { MutableInteractionSource() }
    val focused by interaction.collectIsFocusedAsState()
    val enabled = state != AppInputState.Disabled
    val showFocus = state == AppInputState.Focused || focused

    val surfaceColor = when (surfaceStyle) {
        AppInputSurfaceStyle.Default -> colors.surfaceContainerHighest.copy(alpha = 0.15f)
        AppInputSurfaceStyle.Elevated -> colors.inputElevated
    }

    val borderColor = when {
        !enabled -> colors.outlineSubtle.copy(alpha = OpacityTokens.disabledContent)
        showFocus -> colors.primary
        surfaceStyle == AppInputSurfaceStyle.Elevated -> colors.outlineSubtle.copy(alpha = 0.35f)
        else -> colors.outlineSubtle
    }

    val textColor = when {
        !enabled -> when (surfaceStyle) {
            AppInputSurfaceStyle.Default -> colors.onSurface.copy(alpha = OpacityTokens.disabledContent)
            AppInputSurfaceStyle.Elevated -> colors.onInputElevated.copy(alpha = OpacityTokens.disabledContent)
        }

        surfaceStyle == AppInputSurfaceStyle.Elevated -> colors.onInputElevated
        else -> colors.onSurface
    }

    val placeholderColor = when (surfaceStyle) {
        AppInputSurfaceStyle.Default -> colors.onSurfaceVariant
        AppInputSurfaceStyle.Elevated -> colors.onInputElevated.copy(alpha = 0.45f)
    }

    val cursorColor = colors.primary

    AppSurface(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = comp.inputHeight),
        shape = shapes.roundedMd(),
        color = surfaceColor,
        borderColor = borderColor,
        elevation = AppTheme.elevation.none,
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = inputModifier
                .fillMaxWidth()
                .padding(horizontal = s.md, vertical = s.sm),
            enabled = enabled,
            textStyle = AppTheme.typography.bodyLarge.copy(color = textColor),
            interactionSource = interaction,
            cursorBrush = SolidColor(cursorColor),
            singleLine = singleLine,
            visualTransformation = visualTransformation,
            decorationBox = { inner ->
                Box {
                    if (value.isEmpty() && placeholder != null) {
                        AppText(
                            text = placeholder,
                            style = AppTheme.typography.bodyLarge,
                            color = placeholderColor,
                        )
                    }
                    inner()
                }
            },
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun AppInputPreview() {
    DesignSystemPreviewSurface {
        AppInput("", {}, placeholder = "Placeholder")
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun AppInputElevatedPreview() {
    DesignSystemPreviewSurface {
        AppInput(
            "",
            {},
            placeholder = "Album title",
            surfaceStyle = AppInputSurfaceStyle.Elevated,
        )
    }
}