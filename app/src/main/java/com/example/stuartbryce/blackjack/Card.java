package com.example.stuartbryce.blackjack;

import cards.CardSuit;
import cards.CardValue;

/**
 * Created by stuartbryce on 2017-06-22.
 */

public class Card {

    private CardSuit cardSuit;
    private CardValue cardValue;

    public Card(CardSuit cardSuit, CardValue cardValue){
        this.cardSuit = cardSuit;
        this.cardValue = cardValue;
    }

    public int getValue(){

        return this.cardValue.getValue();
    }

    public String getSuit(){

        return this.cardSuit.getName();
    }

    public CardValue getEnumValue(){
        return this.cardValue;
    }

    public String printCard(){
        return String.format("%d of %s", getValue(), getSuit());
    }
}
