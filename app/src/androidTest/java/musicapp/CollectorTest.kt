package musicapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.performClick
import com.example.musicapp.MainActivity
import org.junit.Rule
import org.junit.Test

class CollectorTest {

    @get:Rule
    var composeTestRule = createAndroidComposeRule<MainActivity>()

    private fun goToCollectorsTab() {
        composeTestRule.waitUntil(timeoutMillis = 15000) {
            composeTestRule
                .onAllNodesWithText("COLLECTORS", useUnmergedTree = true)
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule
            .onAllNodesWithText("COLLECTORS", useUnmergedTree = true)[0]
            .performClick()

        composeTestRule.waitUntil(timeoutMillis = 15000) {
            composeTestRule
                .onAllNodesWithTag("collector_tile", useUnmergedTree = true)
                .fetchSemanticsNodes()
                .isNotEmpty()
        }
    }

    // Test para HU05
    @Test
    fun test1_seMuestraPantallaDeColeccionistas() {
        goToCollectorsTab()

        composeTestRule
            .onAllNodesWithText("COLLECTORS", useUnmergedTree = true)[0]
            .assertIsDisplayed()
    }

    // Test para HU05
    @Test
    fun test2_seCarganColeccionistasDesdeBackend() {
        goToCollectorsTab()

        composeTestRule
            .onAllNodesWithTag("collector_tile", useUnmergedTree = true)[0]
            .assertIsDisplayed()
    }

    // Test para HU05
    @Test
    fun test3_seMuestraInformacionDelColeccionista() {
        goToCollectorsTab()

        composeTestRule.waitUntil(timeoutMillis = 15000) {
            composeTestRule
                .onAllNodesWithText("Manolo Bellon", useUnmergedTree = true)
                .fetchSemanticsNodes()
                .isNotEmpty()
        }

        composeTestRule
            .onAllNodesWithText("Manolo Bellon", useUnmergedTree = true)[0]
            .assertIsDisplayed()

        composeTestRule
            .onAllNodesWithText("1 LPs in Crate", useUnmergedTree = true)[0]
            .assertIsDisplayed()

        composeTestRule
            .onAllNodesWithText("ELITE", useUnmergedTree = true)[0]
            .assertIsDisplayed()
    }

    // Test para HU05
    @Test
    fun test4_sePuedeSeleccionarUnColeccionista() {
        goToCollectorsTab()

        composeTestRule
            .onAllNodesWithTag("collector_tile", useUnmergedTree = true)[0]
            .assertIsDisplayed()
            .performClick()
    }
}