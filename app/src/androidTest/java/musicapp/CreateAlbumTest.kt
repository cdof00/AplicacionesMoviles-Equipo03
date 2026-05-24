package musicapp

import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.semantics.getOrNull
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.performTextInput
import com.example.musicapp.MainActivity
import com.example.musicapp.R
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import org.junit.Rule
import org.junit.Test

class CreateAlbumTest {

    @get:Rule
    var composeTestRule = createAndroidComposeRule<MainActivity>()

    private fun openCreateAlbumScreen() {
        composeTestRule.waitUntil(timeoutMillis = 10000) {
            composeTestRule
                .onAllNodesWithText("ADD")
                .fetchSemanticsNodes()
                .isNotEmpty()
        }
        composeTestRule.onNodeWithText("ADD").performClick()

    }

    private fun waitForAddAlbumForm() {
        composeTestRule.waitUntil(timeoutMillis = 15000) {
            composeTestRule
                .onAllNodesWithTag("album_title_input", useUnmergedTree = true)
                .fetchSemanticsNodes()
                .isNotEmpty()
        }
    }

    @Test
    fun test1_seMuestraFormularioParaAgregarAlbum() {
        openCreateAlbumScreen()
        waitForAddAlbumForm()

        composeTestRule
            .onAllNodesWithTag("album_title_input", useUnmergedTree = true)[0]
            .assertIsDisplayed()

        composeTestRule
            .onAllNodesWithTag("album_description_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .assertIsDisplayed()

        composeTestRule
            .onAllNodesWithTag("album_artist_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .assertIsDisplayed()

        composeTestRule
            .onAllNodesWithTag("album_year_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .assertIsDisplayed()

        composeTestRule
            .onAllNodesWithTag("album_genre_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .assertIsDisplayed()

        composeTestRule
            .onAllNodesWithTag("album_artwork_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .assertIsDisplayed()

        composeTestRule
            .onAllNodesWithTag("album_label_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .assertIsDisplayed()
    }

    @Test
    fun test2_noPermiteCrearAlbumSinTitulo() {
        val expectedError = composeTestRule.activity.getString(
            R.string.album_title_required_error
        )

        openCreateAlbumScreen()
        waitForAddAlbumForm()

        composeTestRule
            .onAllNodesWithTag("create_album_button", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule.waitUntil(timeoutMillis = 5000) {
            composeTestRule
                .onAllNodesWithText(expectedError, useUnmergedTree = true)
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule
            .onAllNodesWithText(expectedError, useUnmergedTree = true)[0]
            .assertIsDisplayed()
    }

    @Test
    fun test3_noPermiteCrearAlbumSinDescripcion() {
        val expectedError = composeTestRule.activity.getString(
            R.string.album_description_required_error
        )

        openCreateAlbumScreen()
        waitForAddAlbumForm()

        composeTestRule
            .onAllNodesWithTag("album_title_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performTextInput("Album Prueba 1")

        composeTestRule
            .onAllNodesWithTag("create_album_button", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule.waitUntil(timeoutMillis = 5000) {
            composeTestRule
                .onAllNodesWithText(expectedError, useUnmergedTree = true)
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule
            .onAllNodesWithText(expectedError, useUnmergedTree = true)[0]
            .assertIsDisplayed()
    }

    @Test
    fun test4_noPermiteCrearAlbumSinArtista() {
        val expectedError = composeTestRule.activity.getString(
            R.string.album_artist_required_error
        )

        openCreateAlbumScreen()
        waitForAddAlbumForm()

        composeTestRule
            .onAllNodesWithTag("album_title_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performTextInput("Album Prueba 1")

        composeTestRule
            .onAllNodesWithTag("album_description_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performTextInput("Descripcion Prueba 1")

        composeTestRule
            .onAllNodesWithTag("create_album_button", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule.waitUntil(timeoutMillis = 5000) {
            composeTestRule
                .onAllNodesWithText(expectedError, useUnmergedTree = true)
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule
            .onAllNodesWithText(expectedError, useUnmergedTree = true)[0]
            .assertIsDisplayed()
    }

    @Test
    fun test5_noPermiteCrearAlbumSinAnio() {
        val expectedError = composeTestRule.activity.getString(
            R.string.album_year_required_error
        )

        openCreateAlbumScreen()
        waitForAddAlbumForm()

        composeTestRule
            .onAllNodesWithTag("album_title_input", useUnmergedTree = true)[0]
                .performScrollTo()
                .performTextInput("Album Prueba 1")

        composeTestRule
            .onAllNodesWithTag("album_description_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performTextInput("Descripcion Prueba 1")

        composeTestRule
            .onAllNodesWithTag("album_artist_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule
            .onAllNodesWithTag("artist_dropdown_item", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule
            .onAllNodesWithTag("create_album_button", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule.waitUntil(timeoutMillis = 5000) {
            composeTestRule
                .onAllNodesWithText(expectedError, useUnmergedTree = true)
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule
            .onAllNodesWithText(expectedError, useUnmergedTree = true)[0]
            .assertIsDisplayed()
    }

    @Test
    fun test6_noPermiteCrearAlbumSinGenero() {
        val expectedError = composeTestRule.activity.getString(
            R.string.album_genre_required_error
        )

        openCreateAlbumScreen()
        waitForAddAlbumForm()

        composeTestRule
            .onAllNodesWithTag("album_title_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performTextInput("Album Prueba 1")

        composeTestRule
            .onAllNodesWithTag("album_description_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performTextInput("Descripcion Prueba 1")

        composeTestRule
            .onAllNodesWithTag("album_artist_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule
            .onAllNodesWithTag("artist_dropdown_item", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule
            .onAllNodesWithTag("album_year_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performTextInput("2026")

        composeTestRule
            .onAllNodesWithTag("create_album_button", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule.waitUntil(timeoutMillis = 5000) {
            composeTestRule
                .onAllNodesWithText(expectedError, useUnmergedTree = true)
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule
            .onAllNodesWithText(expectedError, useUnmergedTree = true)[0]
            .assertIsDisplayed()
    }

    @Test
    fun test7_noPermiteCrearAlbumSinCaratula() {
        val expectedError = composeTestRule.activity.getString(
            R.string.album_cover_required_error
        )

        openCreateAlbumScreen()
        waitForAddAlbumForm()

        composeTestRule
            .onAllNodesWithTag("album_title_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performTextInput("Album Prueba 1")

        composeTestRule
            .onAllNodesWithTag("album_description_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performTextInput("Descripcion Prueba 1")

        composeTestRule
            .onAllNodesWithTag("album_artist_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule
            .onAllNodesWithTag("artist_dropdown_item", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule
            .onAllNodesWithTag("album_year_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performTextInput("2026")

        composeTestRule
            .onAllNodesWithTag("album_genre_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule
            .onAllNodesWithTag("dropdown_item", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule
            .onAllNodesWithTag("create_album_button", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule.waitUntil(timeoutMillis = 5000) {
            composeTestRule
                .onAllNodesWithText(expectedError, useUnmergedTree = true)
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule
            .onAllNodesWithText(expectedError, useUnmergedTree = true)[0]
            .assertIsDisplayed()
    }

    @Test
    fun test8_noPermiteCrearAlbumConUrlErrada() {
        val expectedError = composeTestRule.activity.getString(
            R.string.album_url_required_error
        )

        openCreateAlbumScreen()
        waitForAddAlbumForm()

        composeTestRule
            .onAllNodesWithTag("album_title_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performTextInput("Album Prueba 1")

        composeTestRule
            .onAllNodesWithTag("album_description_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performTextInput("Descripcion Prueba 1")

        composeTestRule
            .onAllNodesWithTag("album_artist_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule
            .onAllNodesWithTag("artist_dropdown_item", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule
            .onAllNodesWithTag("album_year_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performTextInput("2026")

        composeTestRule
            .onAllNodesWithTag("album_genre_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule
            .onAllNodesWithTag("dropdown_item", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule
            .onAllNodesWithTag("album_artwork_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performTextInput("URL Mala")

        composeTestRule
            .onAllNodesWithTag("create_album_button", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule.waitUntil(timeoutMillis = 5000) {
            composeTestRule
                .onAllNodesWithText(expectedError, useUnmergedTree = true)
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule
            .onAllNodesWithText(expectedError, useUnmergedTree = true)[0]
            .assertIsDisplayed()
    }

    @Test
    fun test9_noPermiteCrearAlbumSinDisquera() {
        val expectedError = composeTestRule.activity.getString(
            R.string.album_label_required_error
        )

        openCreateAlbumScreen()
        waitForAddAlbumForm()

        composeTestRule
            .onAllNodesWithTag("album_title_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performTextInput("Album Prueba 1")

        composeTestRule
            .onAllNodesWithTag("album_description_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performTextInput("Descripcion Prueba 1")

        composeTestRule
            .onAllNodesWithTag("album_artist_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule
            .onAllNodesWithTag("artist_dropdown_item", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule
            .onAllNodesWithTag("album_year_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performTextInput("2026")

        composeTestRule
            .onAllNodesWithTag("album_genre_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule
            .onAllNodesWithTag("dropdown_item", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule
            .onAllNodesWithTag("album_artwork_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performTextInput("https://www.udiscovermusic.com/behind-the-albums/queen-sheer-heart-attack/")

        composeTestRule
            .onAllNodesWithTag("create_album_button", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule.waitUntil(timeoutMillis = 5000) {
            composeTestRule
                .onAllNodesWithText(expectedError, useUnmergedTree = true)
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule
            .onAllNodesWithText(expectedError, useUnmergedTree = true)[0]
            .assertIsDisplayed()
    }

    @Test
    fun test10_muestraVentanaDeCreacionDeAlbum() {
        val expectedError = composeTestRule.activity.getString(
            R.string.album_created_success_message
        )

        openCreateAlbumScreen()
        waitForAddAlbumForm()

        composeTestRule
            .onAllNodesWithTag("album_title_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performTextInput("Album Prueba 1")

        composeTestRule
            .onAllNodesWithTag("album_description_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performTextInput("Descripcion Prueba 1")

        composeTestRule
            .onAllNodesWithTag("album_artist_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule
            .onAllNodesWithTag("artist_dropdown_item", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule
            .onAllNodesWithTag("album_year_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performTextInput("2026")

        composeTestRule
            .onAllNodesWithTag("album_genre_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule
            .onAllNodesWithTag("dropdown_item", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule
            .onAllNodesWithTag("album_artwork_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performTextInput("https://www.udiscovermusic.com/behind-the-albums/queen-sheer-heart-attack/")

        composeTestRule
            .onAllNodesWithTag("album_label_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule
            .onAllNodesWithTag("dropdown_item", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule
            .onAllNodesWithTag("create_album_button", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule.waitUntil(timeoutMillis = 5000) {
            composeTestRule
                .onAllNodesWithText(expectedError, useUnmergedTree = true)
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule
            .onAllNodesWithText(expectedError, useUnmergedTree = true)[0]
            .assertIsDisplayed()
    }

    @Test
    fun test11_botonLlevaAAlbumCreado() {
        val expectedResponse = composeTestRule.activity.getString(
            R.string.confirm
        )

        openCreateAlbumScreen()
        waitForAddAlbumForm()

        composeTestRule
            .onAllNodesWithTag("album_title_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performTextInput("Album Prueba 1")

        composeTestRule
            .onAllNodesWithTag("album_description_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performTextInput("Descripcion Prueba 1")

        composeTestRule
            .onAllNodesWithTag("album_artist_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule
            .onAllNodesWithTag("artist_dropdown_item", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule
            .onAllNodesWithTag("album_year_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performTextInput("2026")

        composeTestRule
            .onAllNodesWithTag("album_genre_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule
            .onAllNodesWithTag("dropdown_item", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule
            .onAllNodesWithTag("album_artwork_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performTextInput("https://www.udiscovermusic.com/behind-the-albums/queen-sheer-heart-attack/")

        composeTestRule
            .onAllNodesWithTag("album_label_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule
            .onAllNodesWithTag("dropdown_item", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule
            .onAllNodesWithTag("create_album_button", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule.waitUntil(timeoutMillis = 5000) {
            composeTestRule
                .onAllNodesWithText(expectedResponse, useUnmergedTree = true)
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule
            .onAllNodesWithTag("error_confirm_button", useUnmergedTree = true)[0]
            .performClick()

        composeTestRule.waitUntil(timeoutMillis = 20000) {
            composeTestRule
                .onAllNodesWithTag("album_detail_detail_title", useUnmergedTree = true)
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        val albumNameFromHeader = composeTestRule
            .onAllNodesWithTag("album_detail_detail_title", useUnmergedTree = true)[0]
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
            "Album Prueba 1",
            albumNameFromHeader
        )

    }


}