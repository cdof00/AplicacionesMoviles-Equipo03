package com.example.musicapp.ui.components.molecules

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.atoms.AppIconButton
import com.example.musicapp.ui.components.atoms.AppIconButtonVariant
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun CatalogCollectionHeaderMolecule(
    title: String,
    modifier: Modifier = Modifier,
    onMenuClick: () -> Unit = {},
    onSearchClick: () -> Unit = {},
) {
    val s = AppTheme.spacing
    val colors = AppTheme.colors
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = s.sm),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AppIconButton(
            imageVector = Icons.Outlined.Menu,
            contentDescription = "Menu",
            onClick = onMenuClick,
            variant = AppIconButtonVariant.Ghost,
        )
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = s.sm),
            contentAlignment = Alignment.Center,
        ) {
            AppText(
                text = title,
                style = AppTheme.typography.headlineSmall,
                color = colors.onBackground,
            )
        }
        AppIconButton(
            imageVector = Icons.Outlined.Search,
            contentDescription = "Search",
            onClick = onSearchClick,
            variant = AppIconButtonVariant.Ghost,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun CatalogCollectionHeaderMoleculePreview() {
    DesignSystemPreviewSurface {
        CatalogCollectionHeaderMolecule(title = "Collection")
    }
}
