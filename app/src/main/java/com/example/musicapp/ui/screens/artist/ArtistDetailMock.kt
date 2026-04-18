package com.example.musicapp.ui.screens.artist

data class ArtistDetailAward(
    val numberLabel: String,
    val title: String,
    val subtitle: String,
)

data class ArtistDetailTopAlbum(
    val albumId: String,
    val title: String,
    val metaLine: String,
    val coverVariantIndex: Int,
)

data class ArtistDetailUiModel(
    val screenTitle: String,
    val featuredLabel: String,
    val name: String,
    val curatorRatingLabel: String,
    val vaultLabel: String,
    val heroCoverVariantIndex: Int,
    val bioTitle: String,
    val bioBody: String,
    val originLabel: String,
    val originValue: String,
    val genreLabel: String,
    val genreValue: String,
    val awardsTitle: String,
    val awards: List<ArtistDetailAward>,
    val viewArchiveLabel: String,
    val topAlbumsSectionTitle: String,
    val seeAllLabel: String,
    val topAlbums: List<ArtistDetailTopAlbum>,
)

val artistDetailUiMock: ArtistDetailUiModel = ArtistDetailUiModel(
    screenTitle = "Collection",
    featuredLabel = "FEATURED ARTIST",
    name = "Miles Davis",
    curatorRatingLabel = "9.2 Curator Rating",
    vaultLabel = "54 LP's in Vault",
    heroCoverVariantIndex = 0,
    bioTitle = "Artist Bio",
    bioBody = "The architect of Cool Jazz and a perennial innovator, Miles Dewey Davis III was an American trumpeter, bandleader, and composer. His career spanned five decades, during which he was at the forefront of major stylistic developments in jazz, including bebop, cool jazz, hard bop, modal jazz, and jazz fusion.",
    originLabel = "ORIGIN",
    originValue = "Alton, Illinois, U.S.",
    genreLabel = "GENRE",
    genreValue = "Modal Jazz, Fusion",
    awardsTitle = "Awards",
    awards = listOf(
        ArtistDetailAward(
            numberLabel = "08",
            title = "Grammy Awards",
            subtitle = "Best Jazz Performance",
        ),
        ArtistDetailAward(
            numberLabel = "01",
            title = "Lifetime Achievement",
            subtitle = "Grammy Foundation",
        ),
    ),
    viewArchiveLabel = "View Archive ↗",
    topAlbumsSectionTitle = "Top Albums",
    seeAllLabel = "See All",
    topAlbums = listOf(
        ArtistDetailTopAlbum("art-kob", "Kind of Blue", "1959 • 5 Tracks", 1),
        ArtistDetailTopAlbum("art-bb", "Bitches Brew", "1970 • 6 Tracks", 2),
        ArtistDetailTopAlbum("art-iasw", "In a Silent Way", "1969 • 2 Tracks", 3),
        ArtistDetailTopAlbum("art-sos", "Sketches of Spain", "1960 • 5 Tracks", 4),
    ),
)
