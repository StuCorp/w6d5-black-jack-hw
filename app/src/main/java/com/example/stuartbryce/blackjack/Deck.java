package com.example.stuartbryce.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import cards.CardSuit;
import cards.CardValue;

/**
 * Created by stuartbryce on 2017-06-22.
 */

public class Deck {

    private ArrayList<Card> cards;

    public Deck(){
        this.cards = new ArrayList<Card>();

    }

    public void fillDeck(){
        for (CardSuit suit : CardSuit.values()){
            for (CardValue value : CardValue.values()){
                Card card = new Card(suit, value);
                card.printCard();
                cards.add(card);

            }
        }
    }

    public void shuffleDeck(){
        Collections.shuffle(cards);
    }

    public Card removeCard(){
        return cards.remove(0);
    }


    public Card popRandomCard(){
        Random random = new Random();
        int index = random.nextInt(cards.size());
        return cards.remove(index);
    }



}
