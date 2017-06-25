package com.example.stuartbryce.blackjack;

import java.util.ArrayList;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by stuartbryce on 2017-06-25.
 */

public class Viewer {

    ArrayList<User> users;
    Dealer dealer;

    public Viewer(ArrayList<User> users, Dealer dealer) {
        this.users = users;
        this.dealer = dealer;
    }

    public String formatHand(Player player){
        String fullHand = "";
        for (Card card : player.getHand()){
            fullHand += card.printCard() + ", ";
        }
        return fullHand;
    }

    public void displayUserHand(User user){
        String fullHand = formatHand(user);
        System.out.println(String.format("%s has %s", user.getName(), fullHand));
    }

    public void displayUserHands(){
        for (User user : users){
            displayUserHand(user);
        }
    }

    public void displayerDealerHand(){
        String fullHand = formatHand(dealer);
        System.out.println(String.format("Dealer has %s", fullHand));
    }

    public void displayerDealerFirstCard(){
        String firstCard= dealer.getHand().get(0).printCard();
        System.out.println(String.format("Dealer has %s and a MYSTERY CARD!", firstCard));
        System.out.println();
    }

    public void displayNewCard(User user){
        System.out.println(String.format("%s draws a %s!", user.getName(), user.getHand().get(user.getHand().size()-1).printCard()));
    }
}

