package com.example.musicapp.ui.states

import com.example.musicapp.models.CreateTrack
import com.example.musicapp.models.Musician

class CreateAlbumUiState {
    var artwork: String = ""
    var albumTitle: String = ""
    var artist: Musician = Musician(0,"","","","")
    var year : String = ""
    var genre : String = ""
    var description : String = ""
    var recordLabel : String = ""
    var tracks: List<CreateTrack> = emptyList()
}
