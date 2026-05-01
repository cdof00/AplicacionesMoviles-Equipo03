package com.example.musicapp.ui.states

import com.example.musicapp.models.Musician

data class MusicianDetailUiState(
    val musician: Musician = Musician(0, "", "", "", "")
)