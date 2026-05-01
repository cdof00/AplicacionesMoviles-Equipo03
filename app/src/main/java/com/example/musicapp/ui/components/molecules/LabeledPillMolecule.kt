package com.example.musicapp.ui.components.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.Icons
import com.example.musicapp.ui.components.atoms.AppChip
import com.example.musicapp.ui.components.atoms.AppChipVariant
import com.example.musicapp.ui.components.atoms.AppIcon
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.components.atoms.IconSizeKey
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import androidx.compose.material.icons.automirrored.outlined.Label
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun LabeledPillMolecule(
    label: String,
    pillLabel: String,
    onPillClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
) {
    val s = AppTheme.spacing
    Row(
        modifier = modifier.padding(vertical = s.xs),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(s.sm),
    ) {
        if (icon != null) {
            AppIcon(icon, contentDescription = null, sizeKey = IconSizeKey.Small)
        }
        AppText(label, style = AppTheme.typography.titleSmall)
        AppChip(pillLabel, onPillClick, variant = AppChipVariant.Accent)
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun LabeledPillPreview() {
    DesignSystemPreviewSurface {
        LabeledPillMolecule("Genre", "Jazz", {}, icon = Icons.AutoMirrored.Outlined.Label)
    }
}
