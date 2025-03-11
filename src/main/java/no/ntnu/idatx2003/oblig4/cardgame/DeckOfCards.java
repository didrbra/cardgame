package no.ntnu.idatx2003.oblig4.cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Represents a deck of playing cards.
 * The deck contains 52 cards, with suits Spades (S), Hearts (H), Diamonds (D), and Clubs (C),
 * and face values from 1 to 13 for each suit.
 */
public class DeckOfCards {

    private List <PlayingCard> cards = new ArrayList<>();
    private final char[] suits = {'S', 'H', 'D', 'C'};

    /**
     * Creates a new deck of 52 cards and shuffles them.
     */
   public DeckOfCards() {
       for (char suit : suits) {
           for (int face = 1; face <= 13; face++) {
               cards.add(new PlayingCard(suit, face));
           }
       }
       shuffleDeck();
   }

    /**
     * Shuffles all cards in the deck.
     */
   private void shuffleDeck() {
       Collections.shuffle(cards);
   }

    /**
     * Deals a hand of cards from the deck.
     *
     * @param n the number of cards to deal
     * @return a list of randomly selected cards
     * @throws IllegalArgumentException if n is less than 1 or greater than 52
     */
   public List<PlayingCard> dealHand(int n){
       if (n < 1 || n > 52) {
           throw new IllegalArgumentException("Number of cards must be between 1 and 52");
       }

       List<PlayingCard> hand = new ArrayList<>();
       Random rand = new Random();
       for (int i = 0; i < n; i++) {
           hand.add(cards.get(rand.nextInt(cards.size())));
       }
       return hand;
   }


}
