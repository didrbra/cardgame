package no.ntnu.idatx2003.oblig4.cardgame;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for PlayingCard.
 */
class PlayingCardTest {

    @Test
    void constructorValidInput() {
        PlayingCard card = new PlayingCard('H', 1);
        assertEquals('H', card.getSuit());
        assertEquals(1, card.getFace());
    }

    @Test
    void constructorInvalidSuit() {
        assertThrows(IllegalArgumentException.class, () -> {new PlayingCard('X', 1);});
    }

    @Test
    void constructorInvalidFaceLow() {
        assertThrows(IllegalArgumentException.class, () -> {new PlayingCard('H', 0);});
    }

    @Test
    void constructorInvalidFaceHigh() {
        assertThrows(IllegalArgumentException.class, () -> {new PlayingCard('H', 14);});
    }

    @Test
    void getAsString() {
        PlayingCard card = new PlayingCard('S', 12);
        assertEquals("S12", card.getAsString());
    }

    @Test
    void testEquals() {
        PlayingCard card1 = new PlayingCard('H', 1);
        PlayingCard card2 = new PlayingCard('H', 1);
        PlayingCard card3 = new PlayingCard('S', 1);

        assertTrue(card1.equals(card2));
        assertFalse(card1.equals(card3));
        assertFalse(card1.equals(null));
        assertFalse(card1.equals("Not a card"));
    }

}