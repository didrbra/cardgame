package no.ntnu.idatx2003.oblig4.cardgame;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

/**
 * Test class for DeckOfCards.
 */
class DeckOfCardsTest {

    @Test
    void constructorCreatesFiftyTwoCards() {
        DeckOfCards deck = new DeckOfCards();
        List<PlayingCard> hand = deck.dealHand(52);
        assertEquals(52, hand.size());
    }

    @Test
    void dealHandValidAmount() {
        DeckOfCards deck = new DeckOfCards();
        List<PlayingCard> hand = deck.dealHand(5);
        assertEquals(5, hand.size());
    }

    @Test
    void dealHandTooMany() {
        DeckOfCards deck = new DeckOfCards();
        assertThrows(IllegalArgumentException.class, () -> {deck.dealHand(53);});
    }

    @Test
    void dealHandTooFew() {
        DeckOfCards deck = new DeckOfCards();
        assertThrows(IllegalArgumentException.class, () -> {deck.dealHand(0);});
    }

    @Test
    void dealHandContainsValidCards() {
        DeckOfCards deck = new DeckOfCards();
        List<PlayingCard> hand = deck.dealHand(5);

        for (PlayingCard card : hand) {
            assertTrue("SHDC".indexOf(card.getSuit()) >= 0);
            assertTrue(card.getFace() >= 1 && card.getFace() <= 13);
        }
    }

}