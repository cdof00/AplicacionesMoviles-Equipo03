package com.example.musicapp.ui.screens.album

data class AlbumDetailTrack(
    val number: Int,
    val title: String,
    val subtitle: String,
    val duration: String,
)

data class AlbumDetailUiModel(
    val screenTitle: String,
    val title: String,
    val artist: String,
    val year: String,
    val format: String,
    val tracks: List<AlbumDetailTrack>,
    val totalTracksLabel: String,
    val totalDurationLabel: String,
    val matrixCode: String,
    val condition: String,
    val coverVariantIndex: Int,
)

private val albumDetailTracksMock: List<AlbumDetailTrack> = listOf(
    AlbumDetailTrack(1, "Pulse Width Highway", "Side A — Analog Synth", "4:12"),
    AlbumDetailTrack(2, "Chrome Mirage", "Instrumental", "5:01"),
    AlbumDetailTrack(3, "Digital Sunset", "Vocal", "4:48"),
    AlbumDetailTrack(4, "Neon Rain", "Extended Mix", "6:22"),
    AlbumDetailTrack(5, "Voltage Dreams", "Outro", "3:59"),
)

val albumDetailUiMock: AlbumDetailUiModel = AlbumDetailUiModel(
    screenTitle = "Album Detail",
    title = "Midnight Neon",
    artist = "SYNTHETIX WAVE",
    year = "1984",
    format = "180g Virgin Vinyl",
    tracks = albumDetailTracksMock,
    totalTracksLabel = "12",
    totalDurationLabel = "48:22",
    matrixCode = "SYNTH-WX-84-A1",
    condition = "MINT",
    coverVariantIndex = 2,
)
