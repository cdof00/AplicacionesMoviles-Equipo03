package com.example.musicapp.ui.components.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.musicapp.models.Musician
import com.example.musicapp.ui.theme.theme.AppTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppArtistDropdown(
    label: String,
    search: String,
    value: Musician?,
    artists: List<Musician>,
    onValueChange: (Musician) -> Unit,
    error: String = "",
    onFieldFocusChange: () -> Unit = {},
    onFieldFocusLoss: () -> Unit = {}
) {
    var expanded by remember { mutableStateOf(false) }
    var searchQuery by remember(search) { mutableStateOf(search) }
    var lastValidValue by remember(search) { mutableStateOf(search) }
    var hasFocus by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current
    val s = AppTheme.spacing
    val colors = AppTheme.colors

    val filteredList = remember(searchQuery, artists) {
        if (searchQuery.isEmpty()) artists
        else artists.filter { it.name.contains(searchQuery, ignoreCase = true) }
    }

    Column {
        AppText(
            text = label,
            style = AppTheme.typography.labelSmall,
            color = colors.onSurfaceVariant,
        )
        Text(
            text = "",
            fontSize = 14.sp,
            color = AppTheme.colors.onSurfaceVariant,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(bottom = 6.dp)
        )

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { shouldExpand ->
                if (shouldExpand) {
                    expanded = true
                } else if (!hasFocus) {
                    expanded = false
                }
            }
        ) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = {
                    searchQuery = it
                    expanded = true
                },
                placeholder = {
                    Text(
                        "",
                        color = AppTheme.colors.onSurfaceVariant.copy(alpha = 0.6f)
                    )
                },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor(MenuAnchorType.PrimaryEditable, enabled = true)
                    .onFocusChanged { focusState ->
                        hasFocus = focusState.isFocused
                        if (focusState.isFocused) {
                            onFieldFocusChange()
                            expanded = true
                        } else {
                            onFieldFocusLoss()
                            expanded = false

                            if (searchQuery.isNotEmpty() && !artists.any{ it.name == searchQuery}) {
                                searchQuery = lastValidValue
                            } else if (artists.any{ it.name == searchQuery}) {
                                lastValidValue = searchQuery
                            }
                        }
                    },
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = if (error.isNotEmpty()) AppTheme.colors.error else AppTheme.colors.outline.copy(alpha = 0.5f),
                    focusedBorderColor = if (error.isNotEmpty()) AppTheme.colors.error else AppTheme.colors.primary,
                    unfocusedContainerColor = AppTheme.colors.surface,
                    focusedContainerColor = AppTheme.colors.surface
                ),
                isError = error.isNotEmpty()
            )
            ExposedDropdownMenu(
                expanded = expanded && filteredList.isNotEmpty(),
                onDismissRequest = { expanded = false },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(
                        AppTheme.colors.surface,
                        RoundedCornerShape(12.dp)
                    )
                    .border(
                        width = 1.dp,
                        color = AppTheme.colors.outlineVariant.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(12.dp)
                    )
            ) {
                filteredList.forEach { artist ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                artist.name,
                                fontSize = 15.sp,
                                color = AppTheme.colors.onSurface
                            )
                        },
                        onClick = {
                            val rawFloor: Any =
                                artists.find { it.name == artist.name }?.musicianId
                                    ?: artist.name
                            searchQuery = artist.name
                            lastValidValue = artist.name
                            onValueChange(artist)
                            expanded = false
                            focusManager.clearFocus()
                        },
                        modifier = Modifier
                            .padding(horizontal = 8.dp, vertical = 2.dp),
                        colors = androidx.compose.material3.MenuDefaults.itemColors(
                            textColor = AppTheme.colors.onSurface,
                            leadingIconColor = AppTheme.colors.primary,
                            trailingIconColor = AppTheme.colors.onSurfaceVariant
                        )
                    )
                }
            }
        }
        if (error.isNotEmpty()) {
            Text(
                text = error,
                fontSize = 12.sp,
                color = AppTheme.colors.error,
                modifier = Modifier.padding(top = 4.dp, start = 4.dp)
            )
        }
    }
}
