package no.ntnu.idatx2003.oblig4.cardgame;

import java.security.PublicKey;
import java.util.List;

public class gameController {

    private DeckOfCards deck;
    private Hand currentHand;

    public gameController() {
        this.deck = deck;
    }

    public void dealHand(){
        List<PlayingCard> cards = deck.dealHand(5);
        currentHand = new Hand(cards);
    }

    public Hand getCurrentHand() {
        return currentHand;
    }
}
