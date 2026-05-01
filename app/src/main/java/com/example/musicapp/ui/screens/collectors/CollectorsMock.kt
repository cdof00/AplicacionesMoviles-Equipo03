package com.example.musicapp.ui.screens.collectors

data class CollectorListEntry(
    val collectorId: Int,
    val name: String,
    val lpCount: Int,
    val tierLabel: String,
    val highlightAvatarBadge: Boolean,
    val avatarGradientIndex: Int,
)

val collectorsFilterChipLabels: List<String> = listOf(
    "All Circles",
    "Jazz Purists",
    "Analog Heads",
    "Deep Crate",
    "Private Press",
)

val collectorsMockList: List<CollectorListEntry> = listOf(
    CollectorListEntry(
        collectorId = 1,
        name = "Marcus Vane",
        lpCount = 1_240,
        tierLabel = "ELITE",
        highlightAvatarBadge = true,
        avatarGradientIndex = 0,
    ),
    CollectorListEntry(
        collectorId = 2,
        name = "Elena Thorne",
        lpCount = 856,
        tierLabel = "PRO",
        highlightAvatarBadge = false,
        avatarGradientIndex = 1,
    ),
    CollectorListEntry(
        collectorId = 3,
        name = "Julian Black",
        lpCount = 2_410,
        tierLabel = "ARCHIVIST",
        highlightAvatarBadge = false,
        avatarGradientIndex = 2,
    ),
    CollectorListEntry(
        collectorId = 4,
        name = "Sarah K.",
        lpCount = 112,
        tierLabel = "EMERGING",
        highlightAvatarBadge = false,
        avatarGradientIndex = 3,
    ),
    CollectorListEntry(
        collectorId = 5,
        name = "Dr. Low-Fi",
        lpCount = 5_900,
        tierLabel = "LEGEND",
        highlightAvatarBadge = false,
        avatarGradientIndex = 4,
    ),
)

fun collectorTierUsesPrimaryAccent(label: String): Boolean {
    return when (label.uppercase()) {
        "ELITE", "ARCHIVIST", "LEGEND" -> true
        else -> false
    }
}
