package com.example.musicapp.ui.theme.elevation

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Premium diffuse shadows (ambient occlusion), not heavy Material defaults.
 */
data class ElevationSpec(
    val shadowY: Dp,
    val blur: Dp,
    val ambientAlpha: Float,
    val spotAlpha: Float = 0f,
)

data class ElevationTokens(
    val none: ElevationSpec,
    val raised: ElevationSpec,
    val card: ElevationSpec,
    val floating: ElevationSpec,
    val glowPrimary: ElevationSpec,
)

fun defaultElevationTokens(): ElevationTokens = ElevationTokens(
    none = ElevationSpec(0.dp, 0.dp, 0f),
    raised = ElevationSpec(6.dp, 12.dp, 0.18f),
    card = ElevationSpec(12.dp, 28.dp, 0.28f),
    floating = ElevationSpec(16.dp, 40.dp, 0.35f),
    glowPrimary = ElevationSpec(0.dp, 24.dp, 0.25f),
)
