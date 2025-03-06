package no.ntnu.idatx2003.oblig4.cardgame;

import java.util.List;


public class Hand {

    private List<PlayingCard> cards;

    public Hand(List<PlayingCard> cards) {
        this.cards = cards;
    }

    public int getTotalValue(){
        return cards.stream().mapToInt(PlayingCard::getFace).sum();
    }




}
