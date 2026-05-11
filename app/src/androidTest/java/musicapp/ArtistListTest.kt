package musicapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipeUp
import com.example.musicapp.MainActivity
import org.junit.Rule
import org.junit.Test

class ArtistListTest {

    @get:Rule
    var composeTestRule = createAndroidComposeRule<MainActivity>()

    private fun goToArtistsTab() {
        composeTestRule.waitUntil(timeoutMillis = 15000) {
            composeTestRule
                .onAllNodesWithText("ARTISTS")
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule
            .onNodeWithText("ARTISTS")
            .performClick()

        composeTestRule.waitUntil(timeoutMillis = 15000) {
            composeTestRule
                .onAllNodesWithTag("artist_list_item")
                .fetchSemanticsNodes()
                .isNotEmpty()
        }
    }

    // Test para HU03
    @Test
    fun test1_seMuestraPantallaDeListadoDeArtistas() {
        goToArtistsTab()

        composeTestRule
            .onNodeWithText("Artists")
            .assertIsDisplayed()
    }

    // Test para HU03
    @Test
    fun test2_seMuestraAlMenosUnArtistaEnLaLista() {
        goToArtistsTab()

        composeTestRule
            .onAllNodesWithTag("artist_list_item")[0]
            .assertIsDisplayed()
    }

    // Test para HU03
    @Test
    fun test3_cadaArtistaSeMuestraEnUnaTarjetaSeleccionable() {
        goToArtistsTab()

        composeTestRule
            .onAllNodesWithTag("artist_list_item")[0]
            .assertIsDisplayed()
            .performClick()

        composeTestRule.waitUntil(timeoutMillis = 15000) {
            composeTestRule
                .onAllNodesWithText("FEATURED ARTIST")
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule
            .onNodeWithText("FEATURED ARTIST")
            .assertIsDisplayed()
    }

    // Test para HU03
    @Test
    fun test4_laListaDeArtistasPermiteScrollVertical() {
        goToArtistsTab()

        composeTestRule
            .onAllNodesWithTag("artist_list_item")[0]
            .assertIsDisplayed()

        composeTestRule
            .onAllNodesWithTag("artist_list_item")[0]
            .performTouchInput {
                swipeUp()
            }
    }

    // Test para HU03
    @Test
    fun test5_seMuestraContenidoVisualDelListadoDeArtistas() {
        goToArtistsTab()

        composeTestRule
            .onNodeWithText("Legendary")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Voices")
            .assertIsDisplayed()

        composeTestRule
            .onAllNodesWithTag("artist_list_item")[0]
            .assertIsDisplayed()
    }
}