package no.ntnu.idatx2003.oblig4.cardgame;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Represents a hand of playing cards.
 * This class provides methods to analyze the cards in the hand,
 * such as calculating total value, finding hearts, checking for queen of spades,
 * and determining if the hand contains a flush.
 */
public class Hand {

    public List<PlayingCard> cards;

    /**
     * Creates a new hand with the specified list of cards.
     *
     * @param cards the list of cards to add to the hand
     */
    public Hand(List<PlayingCard> cards) {
        this.cards = cards;
    }

    /**
     * Returns a string representation of all cards in the hand.
     *
     * @return a space-separated string of cards
     */
    public String getHandAsString() {
        return cards.stream()
                .map(PlayingCard::getAsString)
                .collect(Collectors.joining(" "));
    }

    /**
     * Calculates the sum of all card face values in the hand.
     *
     * @return the total value of all cards
     */
    public int getTotalValue(){
        return cards.stream().mapToInt(PlayingCard::getFace).sum();
    }

    /**
     * Returns all hearts cards in the hand as a string.
     *
     * @return a space-separated string of hearts cards, or "No Hearts" if none present
     */
    public String getHearts(){
        String hearts = cards.stream().filter(card -> card.getSuit() == 'H')
                .map(PlayingCard::getAsString).
                collect(Collectors.joining(" "));

        if (hearts.isEmpty()) {
            return "No Hearts";
        } else {
            return hearts;
        }
    }

    /**
     * Checks if the queen of spades (S12) is present in the hand.
     *
     * @return true if the queen of spades is present, false otherwise
     */
    public boolean findQueenOfSpades(){
        return cards.stream().anyMatch(card -> card.getSuit() == 'S' && card.getFace() == 12);
    }

    /**
     * Checks if the hand contains a flush (5 or more cards of the same suit).
     *
     * @return true if a flush is present, false otherwise
     */
    public boolean hasFlush(){
        Map<Character, Long> suitCounts = cards.stream().collect(Collectors.groupingBy(PlayingCard::getSuit, Collectors.counting()));

        return suitCounts.values().stream().anyMatch(count -> count >= 5);
    }








}
