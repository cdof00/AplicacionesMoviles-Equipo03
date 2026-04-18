package com.example.musicapp.ui.components.molecules

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.atoms.AppIconButton
import com.example.musicapp.ui.components.atoms.AppIconButtonVariant
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun DetailTopBarMolecule(
    title: String,
    onBackClick: () -> Unit,
    onTrailingClick: () -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: ImageVector = Icons.AutoMirrored.Outlined.ArrowBack,
    leadingContentDescription: String? = "Back",
    trailingIcon: ImageVector = Icons.Outlined.Share,
    trailingContentDescription: String? = "Share",
    /** To the left of [trailingIcon] when set (e.g. search before overflow). */
    leadingTrailingIcon: ImageVector? = null,
    leadingTrailingContentDescription: String? = null,
    onLeadingTrailingClick: () -> Unit = {},
    /** When set, replaces the trailing icon row (Search/More/Share). */
    customTrailing: (@Composable () -> Unit)? = null,
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
            imageVector = leadingIcon,
            contentDescription = leadingContentDescription,
            onClick = onBackClick,
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
                style = AppTheme.typography.titleMedium,
                color = colors.onBackground,
            )
        }
        if (customTrailing != null) {
            customTrailing()
        } else {
            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (leadingTrailingIcon != null) {
                    AppIconButton(
                        imageVector = leadingTrailingIcon,
                        contentDescription = leadingTrailingContentDescription,
                        onClick = onLeadingTrailingClick,
                        variant = AppIconButtonVariant.Ghost,
                    )
                }
                AppIconButton(
                    imageVector = trailingIcon,
                    contentDescription = trailingContentDescription,
                    onClick = onTrailingClick,
                    variant = AppIconButtonVariant.Ghost,
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun DetailTopBarMoleculePreview() {
    DesignSystemPreviewSurface {
        DetailTopBarMolecule(
            title = "Collector Detail",
            onBackClick = {},
            onTrailingClick = {},
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun DetailTopBarMoleculeSavePreview() {
    DesignSystemPreviewSurface {
        val colors = AppTheme.colors
        DetailTopBarMolecule(
            title = "New Release",
            onBackClick = {},
            onTrailingClick = {},
            leadingIcon = Icons.Outlined.Close,
            leadingContentDescription = "Close",
            customTrailing = {
                AppText(
                    text = "SAVE",
                    style = AppTheme.typography.labelLarge,
                    color = colors.primary,
                    modifier = Modifier
                        .padding(end = AppTheme.spacing.sm)
                        .clickable(onClick = {}),
                )
            },
        )
    }
}
