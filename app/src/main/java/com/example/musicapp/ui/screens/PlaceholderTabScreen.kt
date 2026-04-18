package com.example.musicapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun PlaceholderTabScreen(
    title: String,
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier,
) {
    val s = AppTheme.spacing
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(horizontal = s.xl, vertical = s.lg),
        contentAlignment = Alignment.Center,
    ) {
        AppText(
            text = title,
            style = AppTheme.typography.headlineMedium,
            color = AppTheme.colors.onSurfaceVariant,
        )
    }
}
