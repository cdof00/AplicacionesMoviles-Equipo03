package com.example.musicapp.models

data class Musician(
    val musicianId: Int,
    val name: String,
    val image: String,
    val description: String,
    val birthDate: String,
    val albums: List<Album> = emptyList(),
    val performerPrizes: List<PerformerPrize> = emptyList()
)

data class PerformerPrize(
    val prizeId: Int,
    val premiationDate: String
)