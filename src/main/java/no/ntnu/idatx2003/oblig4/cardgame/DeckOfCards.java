package no.ntnu.idatx2003.oblig4.cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DeckOfCards {

    private List <PlayingCard> cards = new ArrayList<>();
    private final char[] suits = {'S', 'H', 'D', 'C'};

   public DeckOfCards() {
       for (char suit : suits) {
           for (int face = 1; face <= 13; face++) {
               cards.add(new PlayingCard(suit, face));
           }
       }
       shuffleDeck();
   }

   private void shuffleDeck() {
       Collections.shuffle(cards);
   }

   public List<PlayingCard> dealHand(int n){
       if (n < 1 || n > cards.size()) {
           throw new IllegalArgumentException("Number of cards must be between 1 and " + cards.size());
       }

       List<PlayingCard> hand = new ArrayList<>();
       Random rand = new Random();
       for (int i = 0; i < n; i++) {
           hand.add(cards.remove(rand.nextInt(cards.size())));
       }
       return hand;
   }


}
