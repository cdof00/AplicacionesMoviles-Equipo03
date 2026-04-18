package com.example.musicapp.ui.components.templates

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Same shell as [CatalogScreenTemplate]; kept as a named template for collector detail flows.
 */
@Composable
fun CollectorDetailTemplate(
    modifier: Modifier = Modifier,
    bottomBar: @Composable () -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit,
) {
    CatalogScreenTemplate(
        modifier = modifier,
        bottomBar = bottomBar,
        floatingActionButton = floatingActionButton,
        content = content,
    )
}
