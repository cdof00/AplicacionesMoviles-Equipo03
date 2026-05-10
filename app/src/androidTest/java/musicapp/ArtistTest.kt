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
}