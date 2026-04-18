package com.example.musicapp.ui.screens.catalog

data class CatalogAlbum(
    val title: String,
    val artist: String,
    val coverVariantIndex: Int,
    val showAccentStar: Boolean = false,
    /** Fecha de lanzamiento para mostrar en catálogo (texto acordado con API futura). */
    val releaseDate: String,
)

val catalogAlbumMockList: List<CatalogAlbum> = listOf(
    CatalogAlbum("Midnight Parade", "Synthetic Echoes", 0, releaseDate = "2021-03-12"),
    CatalogAlbum("Blue Note Session", "The Velvet Quartet", 1, releaseDate = "2019-11-05"),
    CatalogAlbum("Retrograde Flow", "Analog Dreamscape", 2, releaseDate = "2018-07-20"),
    CatalogAlbum("Silence & Void", "Mono Theory", 3, releaseDate = "2020-01-30"),
    CatalogAlbum("Dust & Diamond", "The Outlaws", 4, showAccentStar = true, releaseDate = "1982-09-14"),
    CatalogAlbum("Lucid State", "Frequencies", 5, releaseDate = "2022-06-01"),
    CatalogAlbum("Groove Theory", "Master Cut", 6, releaseDate = "2017-12-08"),
    CatalogAlbum("Night Crawler", "Urban Pulse", 7, releaseDate = "2023-04-22"),
)
