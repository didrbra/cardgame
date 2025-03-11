package no.ntnu.idatx2003.oblig4.cardgame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Test class for Hand.
 */
class HandTest {
    private List<PlayingCard> testCards;

    @BeforeEach
    void setUp() {
        testCards = new ArrayList<>();
        testCards.add(new PlayingCard('S', 12));
        testCards.add(new PlayingCard('H', 5));
        testCards.add(new PlayingCard('H', 10));
        testCards.add(new PlayingCard('D', 7));
        testCards.add(new PlayingCard('C', 1));
    }

    @Test
    void getHandAsString() {
        Hand hand = new Hand(testCards);
        String expected = "S12 H5 H10 D7 C1";
        assertEquals(expected, hand.getHandAsString());
    }

    @Test
    void getTotalValue() {
        Hand hand = new Hand(testCards);
        int expected = 12 + 5 + 10 + 7 + 1;
        assertEquals(expected, hand.getTotalValue());
    }

    @Test
    void getHeartsWithHearts() {
        Hand hand = new Hand(testCards);
        String expected = "H5 H10";
        assertEquals(expected, hand.getHearts());
    }

    @Test
    void getHeartsWithNoHearts() {
        List<PlayingCard> noHearts = new ArrayList<>();
        noHearts.add(new PlayingCard('S', 1));
        noHearts.add(new PlayingCard('D', 2));
        Hand hand = new Hand(noHearts);
        assertEquals("No Hearts", hand.getHearts());
    }

    @Test
    void findQueenOfSpadesPresent() {
        Hand hand = new Hand(testCards);
        assertTrue(hand.findQueenOfSpades());
    }

    @Test
    void findQueenOfSpadesNotPresent() {
        List<PlayingCard> noQueen = new ArrayList<>();
        noQueen.add(new PlayingCard('S', 11));
        noQueen.add(new PlayingCard('H', 12));
        Hand hand = new Hand(noQueen);
        assertFalse(hand.findQueenOfSpades());
    }

    @Test
    void hasFlushTrue() {
        List<PlayingCard> flushCards = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            flushCards.add(new PlayingCard('H', i));
        }
        Hand hand = new Hand(flushCards);
        assertTrue(hand.hasFlush());
    }

    @Test
    void hasFlushFalse() {
        Hand hand = new Hand(testCards);
        assertFalse(hand.hasFlush());
    }
}