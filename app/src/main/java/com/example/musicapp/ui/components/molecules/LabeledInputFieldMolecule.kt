package com.example.musicapp.ui.components.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.atoms.AppInput
import com.example.musicapp.ui.components.atoms.AppInputSurfaceStyle
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun LabeledInputFieldMolecule(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    inputModifier: Modifier = Modifier,
    placeholder: String? = null,
    surfaceStyle: AppInputSurfaceStyle = AppInputSurfaceStyle.Elevated,
    singleLine: Boolean = true,
) {
    val s = AppTheme.spacing
    val colors = AppTheme.colors

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(s.xs),
    ) {
        AppText(
            text = label,
            style = AppTheme.typography.labelSmall,
            color = colors.onSurfaceVariant,
        )

        AppInput(
            value = value,
            onValueChange = onValueChange,
            placeholder = placeholder,
            surfaceStyle = surfaceStyle,
            singleLine = singleLine,
            inputModifier = inputModifier,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun LabeledInputFieldMoleculePreview() {
    DesignSystemPreviewSurface {
        LabeledInputFieldMolecule(
            label = "ALBUM TITLE",
            value = "",
            onValueChange = {},
            placeholder = "Enter title",
            modifier = Modifier.fillMaxWidth(),
        )
    }
}