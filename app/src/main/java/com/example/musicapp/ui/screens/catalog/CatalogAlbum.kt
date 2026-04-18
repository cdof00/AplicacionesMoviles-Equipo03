package com.example.musicapp.ui.screens.catalog

data class CatalogAlbum(
    val title: String,
    val artist: String,
    val coverVariantIndex: Int,
    val showAccentStar: Boolean = false,
)

val catalogAlbumMockList: List<CatalogAlbum> = listOf(
    CatalogAlbum("Midnight Parade", "Synthetic Echoes", 0),
    CatalogAlbum("Blue Note Session", "The Velvet Quartet", 1),
    CatalogAlbum("Retrograde Flow", "Analog Dreamscape", 2),
    CatalogAlbum("Silence & Void", "Mono Theory", 3),
    CatalogAlbum("Dust & Diamond", "The Outlaws", 4, showAccentStar = true),
    CatalogAlbum("Lucid State", "Frequencies", 5),
    CatalogAlbum("Groove Theory", "Master Cut", 6),
    CatalogAlbum("Night Crawler", "Urban Pulse", 7),
)
