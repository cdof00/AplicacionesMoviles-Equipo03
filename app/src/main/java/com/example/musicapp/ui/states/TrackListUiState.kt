package com.example.musicapp.ui.states

import com.example.musicapp.models.Album
import com.example.musicapp.models.Track

data class TrackListUiState (
    val tracks: List<Track> = emptyList()
)

data class TrackAlbumUiState (
    val album: Album = Album(0,"","","","","","")
)