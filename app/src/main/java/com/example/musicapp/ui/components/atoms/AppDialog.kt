package com.example.musicapp.ui.components.atoms

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import com.example.musicapp.R

@Composable
fun AppDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    modifier: Modifier = Modifier,
) {
    val textConfirm = stringResource(R.string.confirm)
    val textDismiss = stringResource(R.string.dismiss)

    AlertDialog(
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText)
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                },
                modifier = Modifier
                    .testTag("error_confirm_button")
                    .semantics {
                        contentDescription = textConfirm
                    }
            ) {
                Text(textConfirm)
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                },
                modifier = Modifier
                    .testTag("error_dismiss_button")
                    .semantics {
                        contentDescription = textDismiss
                    }
            ) {
                Text(textDismiss)
            }
        }
    )
}