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

//    return 1 for user win, 0 for draw, -1 for dealer win
    public int assessResult(User user){

        if (user.bestScore() == dealer.bestScore()){
            return 0;
        }

        return user.bestScore() > dealer.bestScore() ? 1 : -1;
    }


    public void displayResults(int result, User user) {
        String verb = "";
        switch (result) {
            case 0:
                verb = "draws with";
                break;
            case 1:
                verb = "beats";
                break;
            case -1:
                verb = "loses to";
                break;
        }
        System.out.println(String.format("%s %s to the dealer!", user.getName(), verb));
    }

    public void run(){

    }



}
