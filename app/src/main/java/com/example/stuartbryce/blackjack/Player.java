package com.example.stuartbryce.blackjack;

import java.util.ArrayList;

import cards.CardValue;

/**
 * Created by stuartbryce on 2017-06-23.
 */

public abstract class Player {

    private ArrayList<Card> hand;

    public Player(){

    }

    public int handTotal(){
        int total = 0;
        for(Card card : hand){
            total += card.getValue();
        }
        return total;
    }


//    calls best score which finds the optimal hand; if they can make a hand under 21, they are not bust
    public boolean isBust(){
        return (bestScore() > 21);
//       return (total > 21 );
    }

    public void takeCard(Deck deck){
        hand.add(deck.removeCard());
    }

    public void offeredCard(Deck deck){}

    public ArrayList<Integer> possibleScores(){
        ArrayList<Integer> results = new ArrayList<Integer>();
        int numAces = 0;
        for (Card card : hand){
            if (card.getEnumValue() == CardValue.ACE){
                numAces++;
            }
        }
        results.add(handTotal());

        while (numAces > 0){
            int score = handTotal() - (numAces * 10);
            results.add(score);
            numAces--;
        }
        return results;
    }

    public int bestScore(){
        ArrayList<Integer> scores = possibleScores();
        int best = 21;
        while(best > 0){
            for (int score : scores){
                if (score == best){
                    return score;
                }

            }
            best--;
        }
//        if the best gets to 0, it must be bust. 99 indicates busted.
        return 99;
    }







}
