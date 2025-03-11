package no.ntnu.idatx2003.oblig4.cardgame.controller;

import no.ntnu.idatx2003.oblig4.cardgame.model.DeckOfCards;
import no.ntnu.idatx2003.oblig4.cardgame.model.Hand;
import no.ntnu.idatx2003.oblig4.cardgame.model.PlayingCard;

import java.util.List;

/**
 * Controls the game logic for the card game.
 * This class manages the deck of cards and the current hand,
 * providing methods to deal new hands and retrieve the current hand.
 */
public class GameController {

    private DeckOfCards deck;
    private Hand currentHand;

    /**
     * Creates a new game controller with a fresh deck of cards.
     */
    public GameController() {
        this.deck = new DeckOfCards();
    }

    /**
     * Deals a new hand of 5 cards from the deck.
     * Updates the current hand with the newly dealt cards.
     */
    public void dealHand(){
        List<PlayingCard> cards = deck.dealHand(5);
        currentHand = new Hand(cards);
    }

    /**
     * Returns the current hand of cards.
     *
     * @return the current hand, or null if no hand has been dealt
     */
    public Hand getCurrentHand() {
        return currentHand;
    }
}
