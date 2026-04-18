package com.example.musicapp.ui.screens.collectors

data class CollectorListEntry(
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
        name = "Marcus Vane",
        lpCount = 1_240,
        tierLabel = "ELITE",
        highlightAvatarBadge = true,
        avatarGradientIndex = 0,
    ),
    CollectorListEntry(
        name = "Elena Thorne",
        lpCount = 856,
        tierLabel = "PRO",
        highlightAvatarBadge = false,
        avatarGradientIndex = 1,
    ),
    CollectorListEntry(
        name = "Julian Black",
        lpCount = 2_410,
        tierLabel = "ARCHIVIST",
        highlightAvatarBadge = false,
        avatarGradientIndex = 2,
    ),
    CollectorListEntry(
        name = "Sarah K.",
        lpCount = 112,
        tierLabel = "EMERGING",
        highlightAvatarBadge = false,
        avatarGradientIndex = 3,
    ),
    CollectorListEntry(
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
