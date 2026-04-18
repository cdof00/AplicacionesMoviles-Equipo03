package com.example.musicapp.ui.screens.artists

data class ArtistListEntry(
    val name: String,
    val albumCount: Int,
    val avatarGradientIndex: Int,
)

val artistsMockList: List<ArtistListEntry> = listOf(
    ArtistListEntry("Miles Davis", 14, 0),
    ArtistListEntry("Nina Simone", 8, 1),
    ArtistListEntry("Pink Floyd", 21, 2),
    ArtistListEntry("Daft Punk", 5, 3),
    ArtistListEntry("Joni Mitchell", 12, 4),
    ArtistListEntry("John Coltrane", 19, 5),
)
