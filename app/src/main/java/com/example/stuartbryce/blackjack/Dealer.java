package com.example.stuartbryce.blackjack;

/**
 * Created by stuartbryce on 2017-06-23.
 */

public class Dealer extends Player {



    public void offeredCard(Deck deck){
        while (bestScore() < 17){
            takeCard(deck);
            System.out.println(String.format("Dealer draws a %s!", getHand().get(getHand().size()-1).printCard()));

        }
    }


}
