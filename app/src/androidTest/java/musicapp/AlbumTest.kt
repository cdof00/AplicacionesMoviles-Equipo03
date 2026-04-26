package musicapp

import android.util.Log
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.semantics.getOrNull
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import com.example.musicapp.MainActivity
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import org.junit.Rule
import org.junit.Test

class AlbumTest {

    @get:Rule
    var composeTestRule = createAndroidComposeRule<MainActivity>()

    //Test para HU01
    @Test
    fun test1_seMuestranDatosPantallaInicial() {

        composeTestRule.waitUntil(timeoutMillis = 10000) {
            composeTestRule
                .onAllNodesWithText("Album Catalog")
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule
            .onNodeWithText("Album Catalog")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Collection")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Curated Vault")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Recently Spun")
            .assertIsDisplayed()
    }

    //Test para HU01
    @Test
    fun test2_seCarganAlbumesEnPantallaInicial() {

        composeTestRule.waitUntil(timeoutMillis = 10000) {
            composeTestRule
                .onAllNodesWithTag("album_tile")
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule
            .onAllNodesWithTag("album_tile")[0]
            .assertIsDisplayed()
    }

    //Test para HU02
    @Test
    fun test3_seCargaListaDeCancionesEnPantallaDetalles() {

        composeTestRule.waitUntil(timeoutMillis = 10000) {
            composeTestRule
                .onAllNodesWithTag("album_tile")
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule
            .onAllNodesWithTag("album_tile")[0]
            .assertIsDisplayed()
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

    //Test para HU02
    @Test
    fun test4_tituloDeAlbumEsIgualEnPantallaDetallesYEnPantallaLista() {
        composeTestRule.waitUntil(timeoutMillis = 10000) {
            composeTestRule
                .onAllNodesWithTag("album_tile", useUnmergedTree = true)
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule.waitUntil(timeoutMillis = 10000) {
            composeTestRule
                .onAllNodesWithTag("album_meta_footer", useUnmergedTree = true)
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        val albumNameFromFooter = composeTestRule
            .onAllNodesWithTag("album_meta_footer", useUnmergedTree = true)[0]
            .fetchSemanticsNode()
            .config
            .getOrNull(SemanticsProperties.ContentDescription)
            ?.firstOrNull()

        assertNotNull(
            "Expected AlbumMetaFooterMolecule to expose the album name through ContentDescription",
            albumNameFromFooter
        )

        composeTestRule
            .onAllNodesWithTag("album_tile")[0]
            .assertIsDisplayed()
            .performClick()

        composeTestRule.waitUntil(timeoutMillis = 20000) {
            composeTestRule
                .onAllNodesWithTag("album_detail_header_title", useUnmergedTree = true)
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule
            .onAllNodesWithTag("album_detail_header_title", useUnmergedTree = true)[0]
            .performScrollTo()
            .assertIsDisplayed()

        val albumNameFromHeader = composeTestRule
            .onAllNodesWithTag("album_detail_header_title", useUnmergedTree = true)[0]
            .fetchSemanticsNode()
            .config
            .getOrNull(SemanticsProperties.ContentDescription)
            ?.firstOrNull()

        assertNotNull(
            "Expected AlbumMetaHeaderMolecule to expose the album name through ContentDescription",
            albumNameFromHeader
        )

        assertEquals(
            "Album name from AlbumMetaFooterMolecule should match AlbumMetaHeaderMolecule after opening details",
            albumNameFromFooter,
            albumNameFromHeader
        )
    }
}