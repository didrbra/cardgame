package no.ntnu.idatx2003.oblig4.cardgame;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for GameController.
 */
class GameControllerTest {

    @Test
    void constructorInitializesDeck() {
        GameController controller = new GameController();
        assertNotNull(controller);
    }

    @Test
    void getCurrentHandBeforeDealingIsNull() {
        GameController controller = new GameController();
        assertNull(controller.getCurrentHand());
    }

    @Test
    void dealHandCreatesFiveCards() {
        GameController controller = new GameController();
        controller.dealHand();
        Hand hand = controller.getCurrentHand();

        assertNotNull(hand);
        assertEquals(5, hand.cards.size());
    }

    @Test
    void dealHandCreatesValidCards() {
        GameController controller = new GameController();
        controller.dealHand();
        Hand hand = controller.getCurrentHand();

        for (PlayingCard card : hand.cards) {
            assertTrue("SHDC".indexOf(card.getSuit()) >= 0);
            assertTrue(card.getFace() >= 1 && card.getFace() <= 13);
        }
    }

    @Test
    void dealHandCreatesDifferentHands() {
        GameController controller = new GameController();
        controller.dealHand();
        String firstHand = controller.getCurrentHand().getHandAsString();

        controller.dealHand();
        String secondHand = controller.getCurrentHand().getHandAsString();

        assertNotEquals(firstHand, secondHand);
    }
}