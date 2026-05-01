package com.example.musicapp.ui.screens.collectors

data class CollectorListEntry(
    val collectorId: Int,
    val name: String,
    val lpCount: Int,
    val tierLabel: String,
    val highlightAvatarBadge: Boolean,
    val avatarGradientIndex: Int,
    val genres: List<String> = emptyList(),
)

val collectorsMockList: List<CollectorListEntry> = listOf(
    CollectorListEntry(
        collectorId = 100,
        name = "Manolo Bellon",
        lpCount = 1,
        tierLabel = "ELITE",
        highlightAvatarBadge = true,
        avatarGradientIndex = 0,
        genres = listOf("Salsa", "Jazz", "Bolero"),
    ),
    CollectorListEntry(
        collectorId = 101,
        name = "Jaime Monsalve",
        lpCount = 1,
        tierLabel = "PRO",
        highlightAvatarBadge = false,
        avatarGradientIndex = 1,
        genres = listOf("Rock", "Classic Rock", "Blues"),
    ),
    CollectorListEntry(
        collectorId = 1,
        name = "Andrea Mina",
        lpCount = 6,
        tierLabel = "ARCHIVIST",
        highlightAvatarBadge = false,
        avatarGradientIndex = 2,
        genres = listOf("Modern Jazz", "Post-Punk", "Neo-Soul"),
    ),
    CollectorListEntry(
        collectorId = 2,
        name = "Camila Zuluaga",
        lpCount = 0,
        tierLabel = "EMERGING",
        highlightAvatarBadge = false,
        avatarGradientIndex = 3,
        genres = listOf("Pop", "R&B", "Indie"),
    ),
    CollectorListEntry(
        collectorId = 5,
        name = "Jose Ortegon",
        lpCount = 1,
        tierLabel = "LEGEND",
        highlightAvatarBadge = false,
        avatarGradientIndex = 4,
        genres = listOf("Salsa", "Vallenato", "Cumbia"),
    ),
)

fun collectorTierUsesPrimaryAccent(label: String): Boolean {
    return when (label.uppercase()) {
        "ELITE", "ARCHIVIST", "LEGEND" -> true
        else -> false
    }
}

val collectorsFilterChipLabels: List<String> = listOf(
    "All Circles",
    "Jazz Purists",
    "Analog Heads",
    "Deep Crate",
    "Private Press",
)