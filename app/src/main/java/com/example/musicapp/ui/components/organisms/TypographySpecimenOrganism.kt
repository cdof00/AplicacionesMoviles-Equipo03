package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun TypographySpecimenOrganism(modifier: Modifier = Modifier) {
    val t = AppTheme.typography
    val s = AppTheme.spacing
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(s.md),
    ) {
        AppText("Display M", style = t.displayMedium)
        AppText("Headline L", style = t.headlineLarge)
        AppText("Headline M", style = t.headlineMedium)
        AppText("Title L", style = t.titleLarge)
        AppText("Title M", style = t.titleMedium)
        AppText("Body L — editorial rhythm on dark.", style = t.bodyLarge)
        AppText("Body M — metadata & support.", style = t.bodyMedium, color = AppTheme.colors.onSurfaceVariant)
        AppText("LABEL", style = t.labelLarge, color = AppTheme.colors.primary)
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun TypographySpecimenOrganismPreview() {
    DesignSystemPreviewSurface {
        TypographySpecimenOrganism()
    }
}
