package com.example.musicapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.musicapp.ui.components.organisms.CatalogBottomNavBarOrganism
import com.example.musicapp.ui.components.organisms.FloatingAddButtonOrganism
import com.example.musicapp.ui.components.templates.CatalogScreenTemplate
import com.example.musicapp.ui.preview.DesignSystemPreviewSurface
import com.example.musicapp.ui.screens.AlbumCatalogScreen
import com.example.musicapp.ui.screens.AlbumDetailScreen
import com.example.musicapp.ui.screens.ArtistDetailScreen
import com.example.musicapp.ui.screens.ArtistsScreen
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.PersonAdd
import com.example.musicapp.ui.screens.CollectorDetailScreen
import com.example.musicapp.ui.screens.CollectorsScreen
import com.example.musicapp.ui.screens.NewReleaseScreen

private const val ROUTE_MAIN = "main"
private const val ROUTE_COLLECTOR_DETAIL = "collector_detail"
private const val ROUTE_ALBUM_DETAIL = "album_detail/{albumId}"
private const val ROUTE_ARTIST_DETAIL = "artist_detail"

@Composable
fun MusicAppRoot(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    var selectedTab by rememberSaveable { mutableIntStateOf(0) }

    NavHost(
        navController = navController,
        startDestination = ROUTE_MAIN,
        modifier = modifier,
    ) {
        composable(ROUTE_MAIN) {
            MainTabScaffold(
                modifier = Modifier.fillMaxSize(),
                selectedTab = selectedTab,
                onTabSelected = { selectedTab = it },
                onOpenAlbumDetail = { albumId ->
                    navController.navigate("album_detail/$albumId") {
                        launchSingleTop = true
                    }
                },
                onOpenCollectorDetail = {
                    navController.navigate(ROUTE_COLLECTOR_DETAIL) {
                        launchSingleTop = true
                    }
                },
                onOpenArtistDetail = {
                    navController.navigate(ROUTE_ARTIST_DETAIL) {
                        launchSingleTop = true
                    }
                },
            )
        }
        composable(ROUTE_ARTIST_DETAIL) {
            ArtistDetailScreen(
                modifier = Modifier.fillMaxSize(),
                onBack = { navController.popBackStack() },
                onTabSelected = { index ->
                    selectedTab = index
                    navController.popBackStack(ROUTE_MAIN, inclusive = false)
                },
                onAlbumClick = { albumId ->
                    navController.navigate("album_detail/$albumId") {
                        launchSingleTop = true
                    }
                },
            )
        }
        composable(
            route = ROUTE_ALBUM_DETAIL,
            arguments = listOf(
                navArgument("albumId") { type = NavType.IntType },
            ),
        ) { backStackEntry ->
            val album = backStackEntry.arguments?.getInt("albumId")
            val albumId: Int = album ?: 0
            AlbumDetailScreen(
                albumId = albumId,
                modifier = Modifier.fillMaxSize(),
                onBack = { navController.popBackStack() },
                onTabSelected = { index ->
                    selectedTab = index
                    navController.popBackStack(ROUTE_MAIN, inclusive = false)
                },
            )
        }
        composable(ROUTE_COLLECTOR_DETAIL) {
            CollectorDetailScreen(
                modifier = Modifier.fillMaxSize(),
                onBack = { navController.popBackStack() },
                onShare = {},
                onTabSelected = { index ->
                    selectedTab = index
                    navController.popBackStack(ROUTE_MAIN, inclusive = false)
                },
            )
        }
    }
}

@Composable
private fun MainTabScaffold(
    selectedTab: Int,
    onTabSelected: (Int) -> Unit,
    onOpenAlbumDetail: (Int) -> Unit,
    onOpenCollectorDetail: () -> Unit,
    onOpenArtistDetail: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val bottomBar: @Composable () -> Unit = {
        CatalogBottomNavBarOrganism(
            selectedIndex = selectedTab,
            onSelect = onTabSelected,
        )
    }
    val fab: @Composable () -> Unit = {
        when (selectedTab) {
            0, 1 -> FloatingAddButtonOrganism(onClick = {})
            2 -> FloatingAddButtonOrganism(
                onClick = {},
                imageVector = Icons.Filled.PersonAdd,
                contentDescription = "Add collector",
            )
            3 -> FloatingAddButtonOrganism(
                onClick = {},
                imageVector = Icons.Filled.Check,
                contentDescription = "Confirm",
            )
            else -> {}
        }
    }

    CatalogScreenTemplate(
        modifier = modifier,
        bottomBar = bottomBar,
        floatingActionButton = fab,
    ) { innerPadding ->
        when (selectedTab) {
            0 -> AlbumCatalogScreen(
                innerPadding = innerPadding,
                onAlbumClick = onOpenAlbumDetail,
            )
            1 -> ArtistsScreen(
                innerPadding = innerPadding,
                onArtistClick = onOpenArtistDetail,
            )
            2 -> CollectorsScreen(
                innerPadding = innerPadding,
                onOpenCollectorDetail = onOpenCollectorDetail,
            )
            else -> NewReleaseScreen(
                innerPadding = innerPadding,
                onClose = { onTabSelected(0) },
                onSave = {},
                onUploadArtworkClick = {},
                onAddTrackClick = {},
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0A0A0A, heightDp = 900)
@Composable
private fun MusicAppRootPreview() {
    DesignSystemPreviewSurface {
        MusicAppRoot(modifier = Modifier.fillMaxSize())
    }
}
