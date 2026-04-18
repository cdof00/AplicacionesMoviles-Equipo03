package com.example.musicapp.ui.components.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun ArtistsHeroSectionMolecule(
    eyebrow: String,
    titleLinePrimary: String,
    titleLineAccent: String,
    modifier: Modifier = Modifier,
) {
    val s = AppTheme.spacing
    val colors = AppTheme.colors
    val b = AppTheme.borders
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = s.sm, bottom = s.lg),
        verticalArrangement = Arrangement.spacedBy(s.sm),
    ) {
        AppText(
            text = eyebrow,
            style = AppTheme.typography.labelSmall,
            color = colors.primary,
        )
        AppText(
            text = titleLinePrimary,
            style = AppTheme.typography.headlineLarge,
            color = colors.onBackground,
        )
        AppText(
            text = titleLineAccent,
            style = AppTheme.typography.headlineLarge,
            color = colors.primary,
        )
        Box(
            modifier = Modifier
                .width(s.xl * 2)
                .height(b.thin)
                .background(colors.primary),
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun ArtistsHeroSectionMoleculePreview() {
    DesignSystemPreviewSurface {
        ArtistsHeroSectionMolecule(
            eyebrow = "CURATED COLLECTION",
            titleLinePrimary = "Legendary",
            titleLineAccent = "Voices",
        )
    }
}
