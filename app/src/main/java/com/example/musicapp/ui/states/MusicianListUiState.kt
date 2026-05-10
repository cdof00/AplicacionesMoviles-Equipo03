package com.example.musicapp.ui.states

import com.example.musicapp.models.Musician

data class MusicianListUiState(
    val musicians: List<Musician> = emptyList()
)
