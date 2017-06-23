package com.example.stuartbryce.blackjack;

import java.util.ArrayList;

/**
 * Created by stuartbryce on 2017-06-23.
 */

public class Game {

    ArrayList<User> users;
    Dealer dealer;
    Deck deck;

    public Game(ArrayList<User> users, Dealer dealer){
        this.users = users;
        this.dealer = dealer;
        this.deck = new Deck();
    }

    public void initialDeal(){
        for (int i = 2; i > 0; i--){
            dealer.takeCard(deck);
            for (User user : users){
                user.takeCard(deck);
            }
        }
    }

//    check for first two cards equalling bj.
    public boolean checkForBlackJack(Player player){
        return player.bestScore() == 21;
        }

    public void offerCards(Player player){
        player.offeredCard(deck);
    }



    public void run(){

    }



}
