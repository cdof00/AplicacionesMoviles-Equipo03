package com.example.musicapp.ui.screens.collector

import com.example.musicapp.models.Album

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
    val recentAlbums: List<Album>,
)

data class FavoriteArtistMock(
    val name: String,
    val gradientVariantIndex: Int,
    val imageUrl: String = "",
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

val collectorRecentlyAddedAlbums: List<Album> = listOf(
    Album(100, "Buscando América", "https://i.pinimg.com/564x/aa/5f/ed/aa5fed7fac61cc8f41d1e79db917a7cd.jpg", "1984-08-01T00:00:00.000Z","Buscando América es el primer álbum de la banda de Rubén Blades y Seis del Solar lanzado en 1984. La producción, bajo el sello Elektra, fusiona diferentes ritmos musicales tales como la salsa, reggae, rock, y el jazz latino. El disco fue grabado en Eurosound Studios en Nueva York entre mayo y agosto de 1983.","Salsa","Elektra"),
    Album(101,"Poeta del pueblo","https://cdn.shopify.com/s/files/1/0275/3095/products/image_4931268b-7acf-4702-9c55-b2b3a03ed999_1024x1024.jpg","1984-08-01T00:00:00.000Z","Recopilación de 27 composiciones del cosmos Blades que los bailadores y melómanos han hecho suyas en estos 40 años de presencia de los ritmos y concordias afrocaribeños en múltiples escenarios internacionales. Grabaciones de Blades para la Fania con las orquestas de Pete Rodríguez, Ray Barreto, Fania All Stars y, sobre todo, los grandes éxitos con la Banda de Willie Colón","Salsa","Elektra"),
    Album(102,"A Night at the Opera","https://upload.wikimedia.org/wikipedia/en/4/4d/Queen_A_Night_At_The_Opera.png", "1975-11-21T00:00:00.000Z","Es el cuarto álbum de estudio de la banda británica de rock Queen, publicado originalmente en 1975. Coproducido por Roy Thomas Baker y Queen, A Night at the Opera fue, en el tiempo de su lanzamiento, la producción más cara realizada.1​ Un éxito comercial, el álbum fue votado por el público y citado por publicaciones musicales como uno de los mejores trabajos de Queen y de la historia del rock.","Rock","EMI"),
    Album(103,"A Day at the Races","https://www.udiscovermusic.com/wp-content/uploads/2019/11/a-day-at-the-races.jpg","1976-12-10T00:00:00.000Z","El álbum fue grabado en los Estudios Sarm West, The Manor and Wessex en Inglaterra y con el ingeniero Mike Stone. El título del álbum es una referencia directa al anterior, A Night at the Opera. Ambos álbumes están titulados como películas de los hermanos Marx.","Rock","EMI")
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
