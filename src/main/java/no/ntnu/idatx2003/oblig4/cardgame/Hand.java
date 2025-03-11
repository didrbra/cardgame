package no.ntnu.idatx2003.oblig4.cardgame;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Hand {

    public List<PlayingCard> cards;

    public Hand(List<PlayingCard> cards) {
        this.cards = cards;
    }

    public int getTotalValue(){
        return cards.stream().mapToInt(PlayingCard::getFace).sum();
    }

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

    public boolean findQueenOfSpades(){
        return cards.stream().anyMatch(card -> card.getSuit() == 'S' && card.getFace() == 12);
    }

    public boolean hasFlush(){
        Map<Character, Long> suitCounts = cards.stream().collect(Collectors.groupingBy(PlayingCard::getSuit, Collectors.counting()));

        return suitCounts.values().stream().anyMatch(count -> count >= 5);
    }








}
