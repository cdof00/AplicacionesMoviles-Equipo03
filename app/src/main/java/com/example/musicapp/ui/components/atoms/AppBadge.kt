package com.example.musicapp.ui.components.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun AppBadge(
    count: Int?,
    modifier: Modifier = Modifier,
    dotOnly: Boolean = false,
) {
    val colors = AppTheme.colors
    val s = AppTheme.spacing
    when {
        dotOnly -> {
            Box(
                modifier = modifier
                    .size(s.sm)
                    .clip(CircleShape)
                    .background(colors.primary),
            )
        }
        count != null && count > 0 -> {
            Box(
                modifier = modifier
                    .clip(CircleShape)
                    .background(colors.primary)
                    .padding(horizontal = s.xs, vertical = s.xxs),
                contentAlignment = Alignment.Center,
            ) {
                AppText(
                    text = count.coerceAtMost(99).toString(),
                    style = AppTheme.typography.labelSmall,
                    color = colors.onPrimary,
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun AppBadgePreview() {
    DesignSystemPreviewSurface {
        AppBadge(3)
    }
}
