package com.example.musicapp.ui.screens.artists

data class ArtistListEntry(
    val artistId: Int,
    val name: String,
    val description: String,
    val imageUrl: String,
    val avatarGradientIndex: Int,
)

val artistsMockList: List<ArtistListEntry> = listOf(
    ArtistListEntry(100, "Rubén Blades Bellido de Luna", "Panamanian salsa singer and songwriter.", "", 0),
    ArtistListEntry(2, "Adele Laurie Blue Adkins", "British soul and pop artist known for powerful ballads.", "", 1),
    ArtistListEntry(5, "Carlos Vives", "Colombian vallenato and rock fusion artist.", "", 2),
    ArtistListEntry(4, "Freddie Mercury", "Lead vocalist and co-founder of Queen.", "", 3),
    ArtistListEntry(6, "Juanes", "Colombian rock musician and activist.", "", 4),
    ArtistListEntry(7, "Gilberto Santa Rosa", "Puerto Rican salsa romantic singer.", "", 5),
)
