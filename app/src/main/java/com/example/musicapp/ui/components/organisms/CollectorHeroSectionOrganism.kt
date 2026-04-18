package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.atoms.AppAvatar
import com.example.musicapp.ui.components.atoms.AppAvatarSize
import com.example.musicapp.ui.components.atoms.AppText
import com.example.musicapp.ui.components.molecules.EliteStatusBadgeMolecule
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun CollectorHeroSectionOrganism(
    collectorName: String,
    metadata: String,
    avatarInitials: String,
    eliteBadgeLabel: String,
    modifier: Modifier = Modifier,
    avatarGradientIndex: Int = 3,
) {
    val s = AppTheme.spacing
    val colors = AppTheme.colors
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box {
            AppAvatar(
                initials = avatarInitials,
                size = AppAvatarSize.Large,
                accentRing = true,
                gradientVariantIndex = avatarGradientIndex,
            )
            EliteStatusBadgeMolecule(
                label = eliteBadgeLabel,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .offset(x = s.sm, y = s.sm),
            )
        }
        AppText(
            text = collectorName,
            style = AppTheme.typography.headlineLarge,
            color = colors.onBackground,
            modifier = Modifier.padding(top = s.lg),
        )
        AppText(
            text = metadata,
            style = AppTheme.typography.bodySmall,
            color = colors.onSurfaceVariant,
            modifier = Modifier.padding(top = s.xs),
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun CollectorHeroSectionOrganismPreview() {
    DesignSystemPreviewSurface {
        CollectorHeroSectionOrganism(
            collectorName = "Audiophile Elite",
            metadata = "1,240 LP's in Crate • Portland, OR",
            avatarInitials = "AE",
            eliteBadgeLabel = "ELITE",
        )
    }
}
