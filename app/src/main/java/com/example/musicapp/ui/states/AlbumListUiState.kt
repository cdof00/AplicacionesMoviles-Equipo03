package com.example.musicapp.ui.states

import com.example.musicapp.models.Album

data class AlbumListUiState (
    val albums: List<Album> = emptyList()
)