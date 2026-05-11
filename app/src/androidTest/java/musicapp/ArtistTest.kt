package musicapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.musicapp.MainActivity
import org.junit.Rule
import org.junit.Test

class ArtistTest {

    @get:Rule
    var composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun test5_seNavegaAlDetalleDeArtista() {
        composeTestRule.waitUntil(timeoutMillis = 10000) {
            composeTestRule
                .onAllNodesWithText("ARTISTS")
                .fetchSemanticsNodes()
                .isNotEmpty()
        }
        composeTestRule.onNodeWithText("ARTISTS").performClick()

        composeTestRule.waitUntil(timeoutMillis = 10000) {
            composeTestRule
                .onAllNodesWithTag("artist_list_item")
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule
            .onAllNodesWithTag("artist_list_item")[0]
            .assertIsDisplayed()
            .performClick()

        composeTestRule.waitUntil(timeoutMillis = 10000) {
            composeTestRule
                .onAllNodesWithText("FEATURED ARTIST")
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule
            .onNodeWithText("FEATURED ARTIST")
            .assertIsDisplayed()
    }

    @Test
    fun test6_seMuestraBioDeArtista() {
        composeTestRule.onNodeWithText("ARTISTS").performClick()

        composeTestRule.waitUntil(timeoutMillis = 10000) {
            composeTestRule
                .onAllNodesWithTag("artist_list_item")
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule
            .onAllNodesWithTag("artist_list_item")[0]
            .performClick()

        composeTestRule.waitUntil(timeoutMillis = 10000) {
            composeTestRule
                .onAllNodesWithText("Artist Bio")
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule
            .onNodeWithText("Artist Bio")
            .assertIsDisplayed()
    }

    @Test
    fun test7_seMuestraOrigenDelArtista() {
        composeTestRule.onNodeWithText("ARTISTS").performClick()

        composeTestRule.waitUntil(timeoutMillis = 10000) {
            composeTestRule
                .onAllNodesWithTag("artist_list_item")
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule
            .onAllNodesWithTag("artist_list_item")[0]
            .performClick()

        composeTestRule.waitUntil(timeoutMillis = 10000) {
            composeTestRule
                .onAllNodesWithText("ORIGIN")
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule
            .onNodeWithText("ORIGIN")
            .assertIsDisplayed()
    }

    @Test
    fun test8_seMuestraGeneroDelArtista() {
        composeTestRule.onNodeWithText("ARTISTS").performClick()

        composeTestRule.waitUntil(timeoutMillis = 10000) {
            composeTestRule
                .onAllNodesWithTag("artist_list_item")
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule
            .onAllNodesWithTag("artist_list_item")[0]
            .performClick()

        composeTestRule.waitUntil(timeoutMillis = 10000) {
            composeTestRule
                .onAllNodesWithText("GENRE")
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule
            .onNodeWithText("GENRE")
            .assertIsDisplayed()
    }

    @Test
    fun test9_seMuestraNominacionesDelArtista() {
        composeTestRule.onNodeWithText("ARTISTS").performClick()

        composeTestRule.waitUntil(timeoutMillis = 10000) {
            composeTestRule
                .onAllNodesWithTag("artist_list_item")
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule
            .onAllNodesWithTag("artist_list_item")[0]
            .performClick()

        composeTestRule.waitUntil(timeoutMillis = 10000) {
            composeTestRule
                .onAllNodesWithText("Awards")
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule
            .onNodeWithText("Awards")
            .assertIsDisplayed()
    }

    @Test
    fun test10_seMuestraSeccionDeAlbumesTop() {
        composeTestRule.onNodeWithText("ARTISTS").performClick()

        composeTestRule.waitUntil(timeoutMillis = 10000) {
            composeTestRule
                .onAllNodesWithTag("artist_list_item")
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule
            .onAllNodesWithTag("artist_list_item")[0]
            .performClick()

        composeTestRule.waitUntil(timeoutMillis = 10000) {
            composeTestRule
                .onAllNodesWithText("Top Albums")
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule
            .onNodeWithText("Top Albums")
            .assertIsDisplayed()
    }

    @Test
    fun test11_alTocarAlbumNavegaADetalle() {
        composeTestRule.onNodeWithText("ARTISTS").performClick()

        composeTestRule.waitUntil(timeoutMillis = 10000) {
            composeTestRule
                .onAllNodesWithTag("artist_list_item")
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule
            .onAllNodesWithTag("artist_list_item")[0]
            .performClick()

        composeTestRule.waitUntil(timeoutMillis = 10000) {
            composeTestRule
                .onAllNodesWithTag("artist_top_album")
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule
            .onAllNodesWithTag("artist_top_album")[0]
            .performClick()

        composeTestRule.waitUntil(timeoutMillis = 10000) {
            composeTestRule
                .onAllNodesWithTag("track_tile")
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule
            .onAllNodesWithTag("track_tile")[0]
            .assertIsDisplayed()
    }
}