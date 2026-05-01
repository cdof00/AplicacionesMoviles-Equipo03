package com.example.musicapp.ui.screens.artists

data class ArtistListEntry(
    val artistId: Int,
    val name: String,
    val albumCount: Int,
    val avatarGradientIndex: Int,
)

val artistsMockList: List<ArtistListEntry> = listOf(
    ArtistListEntry(100, "Rubén Blades Bellido de Luna", 5, 0),
    ArtistListEntry(2, "Adele Laurie Blue Adkins", 0, 1),
    ArtistListEntry(5, "Carlos Vives", 2, 2),
    ArtistListEntry(4, "Freddie Mercury", 0, 3),
    ArtistListEntry(6, "Juanes", 10, 4),
    ArtistListEntry(7, "Gilberto Santa Rosa", 6, 5),
)
