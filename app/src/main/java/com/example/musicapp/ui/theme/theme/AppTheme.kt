package com.example.musicapp.ui.theme.theme

// New token groups: add files under ui/theme/* and extend [AppThemeConfig] + factory in [AppTheme].

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import com.example.musicapp.ui.theme.border.BorderTokens
import com.example.musicapp.ui.theme.border.defaultBorderTokens
import com.example.musicapp.ui.theme.color.AppColors
import com.example.musicapp.ui.theme.color.darkAppColors
import com.example.musicapp.ui.theme.color.lightAppColors
import com.example.musicapp.ui.theme.dimension.DimensionTokens
import com.example.musicapp.ui.theme.dimension.defaultDimensionTokens
import com.example.musicapp.ui.theme.elevation.ElevationTokens
import com.example.musicapp.ui.theme.elevation.defaultElevationTokens
import com.example.musicapp.ui.theme.shape.ShapeTokens
import com.example.musicapp.ui.theme.shape.defaultShapeTokens
import com.example.musicapp.ui.theme.spacing.SpacingTokens
import com.example.musicapp.ui.theme.spacing.defaultSpacingTokens
import com.example.musicapp.ui.theme.typography.appTypography

/**
 * Single aggregate for the design system. Add new token groups here when scaling.
 */
data class AppThemeConfig(
    val colors: AppColors,
    val spacing: SpacingTokens,
    val shapes: ShapeTokens,
    val elevation: ElevationTokens,
    val borders: BorderTokens,
    val dimensions: DimensionTokens,
    val interaction: InteractionStateTokens,
)

val LocalAppTheme = staticCompositionLocalOf<AppThemeConfig> {
    error("AppTheme not provided — wrap UI with AppTheme { }")
}

@Composable
fun AppTheme(
    darkTheme: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colors = remember(darkTheme) {
        if (darkTheme) darkAppColors() else lightAppColors()
    }
    val config = remember(colors) {
        AppThemeConfig(
            colors = colors,
            spacing = defaultSpacingTokens(),
            shapes = defaultShapeTokens(),
            elevation = defaultElevationTokens(),
            borders = defaultBorderTokens(),
            dimensions = defaultDimensionTokens(),
            interaction = interactionTokens(colors),
        )
    }
    val typography = remember { appTypography() }
    val materialColors = remember(colors) { appColorsToMaterialColorScheme(colors) }

    CompositionLocalProvider(LocalAppTheme provides config) {
        MaterialTheme(
            colorScheme = materialColors,
            typography = typography,
            content = content,
        )
    }
}

/**
 * Access design tokens from any Composable under [AppTheme].
 */
object AppTheme {
    val config: AppThemeConfig
        @Composable
        @ReadOnlyComposable
        get() = LocalAppTheme.current

    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = config.colors

    val spacing: SpacingTokens
        @Composable
        @ReadOnlyComposable
        get() = config.spacing

    val shapes: ShapeTokens
        @Composable
        @ReadOnlyComposable
        get() = config.shapes

    val elevation: ElevationTokens
        @Composable
        @ReadOnlyComposable
        get() = config.elevation

    val borders: BorderTokens
        @Composable
        @ReadOnlyComposable
        get() = config.borders

    val dimensions: DimensionTokens
        @Composable
        @ReadOnlyComposable
        get() = config.dimensions

    val interaction: InteractionStateTokens
        @Composable
        @ReadOnlyComposable
        get() = config.interaction

    val typography: androidx.compose.material3.Typography
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.typography
}
