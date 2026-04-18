package com.example.musicapp.ui.components.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.components.atoms.AppButton
import com.example.musicapp.ui.components.atoms.AppButtonVariant
import com.example.musicapp.ui.components.atoms.AppIconButton
import com.example.musicapp.ui.components.atoms.AppIconButtonVariant
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.theme.theme.AppTheme

@Composable
fun CollectorActionsRowOrganism(
    followLabel: String,
    onFollowClick: () -> Unit,
    onMessageClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val s = AppTheme.spacing
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = s.lg),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(s.md),
    ) {
        AppButton(
            text = followLabel,
            onClick = onFollowClick,
            variant = AppButtonVariant.Primary,
            modifier = Modifier.weight(1f),
        )
        AppIconButton(
            imageVector = Icons.Outlined.MailOutline,
            contentDescription = "Message",
            onClick = onMessageClick,
            variant = AppIconButtonVariant.Secondary,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A)
@Composable
private fun CollectorActionsRowOrganismPreview() {
    DesignSystemPreviewSurface {
        CollectorActionsRowOrganism(
            followLabel = "Follow",
            onFollowClick = {},
            onMessageClick = {},
        )
    }
}
