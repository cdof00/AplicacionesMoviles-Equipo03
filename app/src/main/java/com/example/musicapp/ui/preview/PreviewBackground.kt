package com.example.musicapp.ui.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun DesignSystemPreviewSurface(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    AppTheme {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(AppTheme.colors.background)
                .padding(AppTheme.spacing.md),
        ) {
            content()
        }
    }
}

fun previewDarkBg(): Color = Color(0xFF0A0A0A)
