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

    private fun goToCollectorDetail() {
        goToCollectorsTab()
        composeTestRule
            .onAllNodesWithTag("collector_tile", useUnmergedTree = true)[0]
            .performClick()
        composeTestRule.waitUntil(timeoutMillis = 15000) {
            composeTestRule
                .onAllNodesWithText("Collector Detail")
                .fetchSemanticsNodes()
                .isNotEmpty()
        }
    }

    // Tests para HU05
    @Test
    fun test1_seMuestraPantallaDeColeccionistas() {
        goToCollectorsTab()
        composeTestRule
            .onAllNodesWithText("COLLECTORS", useUnmergedTree = true)[0]
            .assertIsDisplayed()
    }

    @Test
    fun test2_seCarganColeccionistasDesdeBackend() {
        goToCollectorsTab()
        composeTestRule
            .onAllNodesWithTag("collector_tile", useUnmergedTree = true)[0]
            .assertIsDisplayed()
    }

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

    @Test
    fun test4_sePuedeSeleccionarUnColeccionista() {
        goToCollectorsTab()
        composeTestRule
            .onAllNodesWithTag("collector_tile", useUnmergedTree = true)[0]
            .assertIsDisplayed()
            .performClick()
    }

    // Tests para HU06
    @Test
    fun test5_seMuestraNombreDelColeccionista() {
        goToCollectorDetail()
        composeTestRule
            .onNodeWithText("Collector Detail")
            .assertIsDisplayed()
    }

    @Test
    fun test6_seMuestraInsigniaDelColeccionista() {
        goToCollectorDetail()
        composeTestRule.waitUntil(timeoutMillis = 15000) {
            composeTestRule
                .onAllNodesWithText("COLLECTOR")
                .fetchSemanticsNodes()
                .isNotEmpty()
        }
        composeTestRule
            .onAllNodesWithText("COLLECTOR")[0]
            .assertIsDisplayed()
    }

    @Test
    fun test7_seMuestraSeccionMusicalTaste() {
        goToCollectorDetail()
        composeTestRule.waitUntil(timeoutMillis = 15000) {
            composeTestRule
                .onAllNodesWithText("Musical Taste")
                .fetchSemanticsNodes()
                .isNotEmpty()
        }
        composeTestRule
            .onNodeWithText("Musical Taste")
            .assertIsDisplayed()
    }

    @Test
    fun test8_seMuestraSeccionArtistasFavoritos() {
        goToCollectorDetail()
        composeTestRule.waitUntil(timeoutMillis = 15000) {
            composeTestRule
                .onAllNodesWithText("Favorite Artists")
                .fetchSemanticsNodes()
                .isNotEmpty()
        }
        composeTestRule
            .onNodeWithText("Favorite Artists")
            .assertIsDisplayed()
    }

    @Test
    fun test9_seMuestraSeccionRecentlyAdded() {
        goToCollectorDetail()
        composeTestRule.waitUntil(timeoutMillis = 15000) {
            composeTestRule
                .onAllNodesWithText("Recently Added")
                .fetchSemanticsNodes()
                .isNotEmpty()
        }
        composeTestRule
            .onNodeWithText("Recently Added")
            .assertIsDisplayed()
    }

    @Test
    fun test10_seMuestraBotonFollow() {
        goToCollectorDetail()
        composeTestRule.waitUntil(timeoutMillis = 15000) {
            composeTestRule
                .onAllNodesWithText("Follow")
                .fetchSemanticsNodes()
                .isNotEmpty()
        }
        composeTestRule
            .onNodeWithText("Follow")
            .assertIsDisplayed()
    }
}