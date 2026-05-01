package com.example.musicapp.models

data class Collector(
    val collectorId: Int,
    val name: String,
    val telephone: String,
    val email: String,
    val favoritePerformers: List<Performer> = emptyList(),
    val collectorAlbums: List<CollectorAlbum> = emptyList()
)

data class Performer(
    val performerId: Int,
    val name: String,
    val image: String,
    val description: String
)

data class CollectorAlbum(
    val collectorAlbumId: Int,
    val price: Int,
    val status: String
)