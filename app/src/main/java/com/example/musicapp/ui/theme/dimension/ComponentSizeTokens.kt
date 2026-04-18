package com.example.musicapp.ui.theme.dimension

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class ComponentSizeTokens(
    val minTouchTarget: Dp,
    val buttonHeight: Dp,
    val inputHeight: Dp,
    val chipHeight: Dp,
    val fabSize: Dp,
    val avatarSm: Dp,
    val avatarMd: Dp,
    val avatarLg: Dp,
    val artistRowAvatar: Dp,
)

fun defaultComponentSizeTokens(): ComponentSizeTokens = ComponentSizeTokens(
    minTouchTarget = 48.dp,
    buttonHeight = 48.dp,
    inputHeight = 52.dp,
    chipHeight = 36.dp,
    fabSize = 56.dp,
    avatarSm = 36.dp,
    avatarMd = 48.dp,
    avatarLg = 120.dp,
    artistRowAvatar = 64.dp,
)

data class DimensionTokens(
    val icon: IconSizeTokens,
    val component: ComponentSizeTokens,
)

fun defaultDimensionTokens(): DimensionTokens = DimensionTokens(
    icon = defaultIconSizeTokens(),
    component = defaultComponentSizeTokens(),
)
