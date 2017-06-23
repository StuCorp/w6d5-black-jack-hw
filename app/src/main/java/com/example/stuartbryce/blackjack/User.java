package com.example.stuartbryce.blackjack;

/**
 * Created by stuartbryce on 2017-06-23.
 */

public class User extends Player {

    public void offeredCard(Deck deck){
        String answer = userTwistOrStick();

        if (answer == "no"){
            return;
        }
        if (answer == "yes"){
            takeCard(deck);
            if (isBust()) {
                return;
            } else
                offeredCard(deck);
        }
    }

    public String userTwistOrStick(){

    }


}
