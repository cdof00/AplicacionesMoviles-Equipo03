package com.example.musicapp.ui.components.atoms

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun AppIcon(
    imageVector: ImageVector,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = AppTheme.colors.onSurface,
    sizeKey: IconSizeKey = IconSizeKey.Medium,

) {
    val dim = AppTheme.dimensions.icon
    val size = when (sizeKey) {
        IconSizeKey.ExtraSmall -> dim.xs
        IconSizeKey.Small -> dim.sm
        IconSizeKey.Medium -> dim.md
        IconSizeKey.Large -> dim.lg
        IconSizeKey.ExtraLarge -> dim.xl
    }
    Icon(
        imageVector = imageVector,
        contentDescription = contentDescription,
        modifier = modifier.size(size),
        tint = tint,
    )
}

enum class IconSizeKey { ExtraSmall, Small, Medium, Large, ExtraLarge }

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun AppIconPreview() {
    DesignSystemPreviewSurface {
        AppIcon(Icons.Default.Settings, contentDescription = null)
    }
}
