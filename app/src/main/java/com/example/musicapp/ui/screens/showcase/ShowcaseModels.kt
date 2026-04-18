package com.example.musicapp.ui.screens.showcase

object ShowcaseModels {
    val settingsRows: List<Pair<String, String>> = listOf(
        "Theme" to "Dark (default)",
        "Density" to "Default",
        "Motion" to "System",
    )

    val filterLabels: List<String> = listOf("All", "Atoms", "Molecules", "Organisms")

    val buttonGroupOptions: List<String> = listOf("A", "B", "C")

    val tokenCards: List<Pair<String, String>> = listOf(
        "spacing.md" to "Vertical rhythm between blocks.",
        "radius.lg" to "Cards and inputs share rounded geometry.",
        "elevation.card" to "Diffuse shadow spec for elevated surfaces.",
    )
}
