package com.example.musicapp.ui.screens.collector

import com.example.musicapp.ui.screens.catalog.CatalogAlbum

data class CollectorDetailUiModel(
    val screenTitle: String,
    val collectorName: String,
    val metadata: String,
    val avatarInitials: String,
    val eliteBadgeLabel: String,
    val followLabel: String,
    val heroAvatarGradientIndex: Int,
    val genres: List<String>,
    val artists: List<FavoriteArtistMock>,
    val recentAlbums: List<CatalogAlbum>,
)

data class FavoriteArtistMock(
    val name: String,
    val gradientVariantIndex: Int,
)

val collectorDetailGenres: List<String> = listOf(
    "Modern Jazz",
    "Post-Punk",
    "Ambient Techno",
    "Neo-Soul",
    "Psych Rock",
)

val collectorFavoriteArtists: List<FavoriteArtistMock> = listOf(
    FavoriteArtistMock("Miles Davis", 0),
    FavoriteArtistMock("Radiohead", 1),
    FavoriteArtistMock("Bonobo", 2),
    FavoriteArtistMock("Tame Impala", 3),
    FavoriteArtistMock("Massive Attack", 4),
)

val collectorRecentlyAddedAlbums: List<CatalogAlbum> = listOf(
    CatalogAlbum("Visions of Light", "The Sun Ra Arkestra", 5, releaseDate = "1978-05-01"),
    CatalogAlbum("Floating Points", "Crush", 6, releaseDate = "2019-10-18"),
    CatalogAlbum("Selected Works", "Aphex Twin", 7, releaseDate = "2002-03-11"),
    CatalogAlbum("Blue Train", "John Coltrane", 0, releaseDate = "1957-09-15"),
)

val collectorDetailUiMock: CollectorDetailUiModel = CollectorDetailUiModel(
    screenTitle = "Collector Detail",
    collectorName = "Audiophile Elite",
    metadata = "1,240 LP's in Crate • Portland, OR",
    avatarInitials = "AE",
    eliteBadgeLabel = "ELITE",
    followLabel = "Follow",
    heroAvatarGradientIndex = 3,
    genres = collectorDetailGenres,
    artists = collectorFavoriteArtists,
    recentAlbums = collectorRecentlyAddedAlbums,
)
