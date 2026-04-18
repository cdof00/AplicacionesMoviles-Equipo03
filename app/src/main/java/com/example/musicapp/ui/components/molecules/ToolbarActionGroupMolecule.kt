package com.example.musicapp.ui.components.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.musicapp.ui.components.atoms.AppIconButton
import com.example.musicapp.ui.components.atoms.AppIconButtonVariant
import com.example.musicapp.ui.theme.theme.AppTheme

data class ToolbarAction(
    val icon: androidx.compose.ui.graphics.vector.ImageVector,
    val contentDescription: String?,
    val onClick: () -> Unit,
)

@Composable
fun ToolbarActionGroupMolecule(
    actions: List<ToolbarAction>,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(AppTheme.spacing.xs),
    ) {
        actions.forEach { a ->
            AppIconButton(
                imageVector = a.icon,
                contentDescription = a.contentDescription,
                onClick = a.onClick,
                variant = AppIconButtonVariant.Ghost,
            )
        }
    }
}
