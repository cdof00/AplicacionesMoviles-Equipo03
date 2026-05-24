package musicapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.performTextInput
import com.example.musicapp.MainActivity
import com.example.musicapp.R
import junit.framework.TestCase.assertTrue
import org.junit.Rule
import org.junit.Test

class TrackAssociationTest {

    @get:Rule
    var composeTestRule = createAndroidComposeRule<MainActivity>()

    private fun openFirstAlbumDetail() {
        composeTestRule.waitUntil(timeoutMillis = 15000) {
            composeTestRule
                .onAllNodesWithTag("album_tile", useUnmergedTree = true)
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule
            .onAllNodesWithTag("album_tile", useUnmergedTree = true)[0]
            .performClick()
    }

    private fun waitForAddTrackForm() {
        composeTestRule.waitUntil(timeoutMillis = 15000) {
            composeTestRule
                .onAllNodesWithTag("add_track_form", useUnmergedTree = true)
                .fetchSemanticsNodes()
                .isNotEmpty()
        }
    }

    @Test
    fun test1_seMuestraFormularioParaAgregarTrackEnDetalleAlbum() {
        openFirstAlbumDetail()
        waitForAddTrackForm()

        composeTestRule
            .onAllNodesWithTag("tracklist_card", useUnmergedTree = true)[0]
            .assertIsDisplayed()

        composeTestRule
            .onAllNodesWithTag("track_name_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .assertIsDisplayed()

        composeTestRule
            .onAllNodesWithTag("track_duration_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .assertIsDisplayed()

        composeTestRule
            .onAllNodesWithTag("add_track_button", useUnmergedTree = true)[0]
            .performScrollTo()
            .assertIsDisplayed()
    }

    @Test
    fun test2_seMuestraListaDeTracksDelAlbum() {
        openFirstAlbumDetail()

        composeTestRule.waitUntil(timeoutMillis = 15000) {
            composeTestRule
                .onAllNodesWithTag("track_tile", useUnmergedTree = true)
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule
            .onAllNodesWithTag("track_tile", useUnmergedTree = true)[0]
            .assertIsDisplayed()
    }

    @Test
    fun test3_noPermiteCrearTrackSinNombre() {
        val expectedError = composeTestRule.activity.getString(
            R.string.track_name_required_error
        )

        openFirstAlbumDetail()
        waitForAddTrackForm()

        composeTestRule
            .onAllNodesWithTag("track_duration_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performTextInput("3:45")

        composeTestRule
            .onAllNodesWithTag("add_track_button", useUnmergedTree = true)[0]
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
    fun test4_noPermiteCrearTrackConDuracionInvalida() {
        val expectedError = composeTestRule.activity.getString(
            R.string.track_duration_format_error
        )

        openFirstAlbumDetail()
        waitForAddTrackForm()

        composeTestRule
            .onAllNodesWithTag("track_name_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performTextInput("Track duración inválida")

        composeTestRule
            .onAllNodesWithTag("track_duration_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performTextInput("345")

        composeTestRule
            .onAllNodesWithTag("add_track_button", useUnmergedTree = true)[0]
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
    fun test5_creaTrackYLoMuestraEnLaLista() {
        val trackName = "Track HU08 Test ${System.currentTimeMillis()}"

        openFirstAlbumDetail()
        waitForAddTrackForm()

        composeTestRule
            .onAllNodesWithTag("track_name_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performTextInput(trackName)

        composeTestRule
            .onAllNodesWithTag("track_duration_input", useUnmergedTree = true)[0]
            .performScrollTo()
            .performTextInput("3:45")

        composeTestRule
            .onAllNodesWithTag("add_track_button", useUnmergedTree = true)[0]
            .performScrollTo()
            .performClick()

        composeTestRule.waitUntil(timeoutMillis = 20000) {
            composeTestRule
                .onAllNodesWithText(trackName, useUnmergedTree = true)
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        val createdTrackNodes = composeTestRule
            .onAllNodesWithText(trackName, useUnmergedTree = true)
            .fetchSemanticsNodes()

        assertTrue(
            "El track creado debe aparecer en la lista del álbum",
            createdTrackNodes.isNotEmpty()
        )
    }
}