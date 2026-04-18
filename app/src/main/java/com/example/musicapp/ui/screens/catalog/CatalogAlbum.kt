package com.example.musicapp.ui.screens.catalog

data class CatalogAlbum(
    /** Identificador estable para navegación al detalle (HU02) y futura API. */
    val id: String,
    val title: String,
    val artist: String,
    val coverVariantIndex: Int,
    val showAccentStar: Boolean = false,
    /** Fecha de lanzamiento para mostrar en catálogo (texto acordado con API futura). */
    val releaseDate: String,
)

val catalogAlbumMockList: List<CatalogAlbum> = listOf(
    CatalogAlbum("cat-01", "Midnight Parade", "Synthetic Echoes", 0, releaseDate = "2021-03-12"),
    CatalogAlbum("cat-02", "Blue Note Session", "The Velvet Quartet", 1, releaseDate = "2019-11-05"),
    CatalogAlbum("cat-03", "Retrograde Flow", "Analog Dreamscape", 2, releaseDate = "2018-07-20"),
    CatalogAlbum("cat-04", "Silence & Void", "Mono Theory", 3, releaseDate = "2020-01-30"),
    CatalogAlbum("cat-05", "Dust & Diamond", "The Outlaws", 4, showAccentStar = true, releaseDate = "1982-09-14"),
    CatalogAlbum("cat-06", "Lucid State", "Frequencies", 5, releaseDate = "2022-06-01"),
    CatalogAlbum("cat-07", "Groove Theory", "Master Cut", 6, releaseDate = "2017-12-08"),
    CatalogAlbum("cat-08", "Night Crawler", "Urban Pulse", 7, releaseDate = "2023-04-22"),
)
