package com.example.musicapp.ui.components.atoms

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme
import com.example.musicapp.ui.theme.theme.OpacityTokens

@Composable
fun AppSearchField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    enabled: Boolean = true,
) {
    val colors = AppTheme.colors
    val shapes = AppTheme.shapes
    val fill = colors.surfaceContainerHighest.copy(alpha = 0.15f)

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        singleLine = true,
        shape = shapes.roundedLg(),
        placeholder = {
            AppText(placeholder, style = AppTheme.typography.bodyMedium, color = colors.onSurfaceVariant)
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = colors.onSurface,
            unfocusedTextColor = colors.onSurface,
            disabledTextColor = colors.onSurface.copy(alpha = OpacityTokens.disabledContent),
            focusedBorderColor = colors.primary,
            unfocusedBorderColor = colors.outlineSubtle,
            disabledBorderColor = colors.outlineSubtle.copy(alpha = OpacityTokens.disabledContent),
            focusedContainerColor = fill,
            unfocusedContainerColor = fill,
            disabledContainerColor = fill.copy(alpha = OpacityTokens.disabledContainer),
            cursorColor = colors.primary,
        ),
    )
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun AppSearchFieldPreview() {
    DesignSystemPreviewSurface {
        AppSearchField("", {}, placeholder = "Search")
    }
}
