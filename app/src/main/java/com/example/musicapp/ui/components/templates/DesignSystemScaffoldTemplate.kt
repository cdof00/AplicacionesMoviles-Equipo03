package com.example.musicapp.ui.components.templates

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.musicapp.ui.components.atoms.AppScreenBackground
/**
 * Layout shell for DS screens: full-bleed [AppScreenBackground], transparent [Scaffold], slots for bars.
 */
@Composable
fun DesignSystemScaffoldTemplate(
    modifier: Modifier = Modifier,
    bottomBar: @Composable () -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.Transparent,
        bottomBar = bottomBar,
        floatingActionButton = floatingActionButton,
    ) { innerPadding ->
        AppScreenBackground {
            Box(Modifier.fillMaxSize()) {
                content(innerPadding)
            }
        }
    }
}
