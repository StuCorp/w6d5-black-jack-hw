package com.example.stuartbryce.blackjack;
import java.util.Scanner;

import static android.R.id.input;


/**
 * Created by stuartbryce on 2017-06-23.
 */

public class User extends Player {

    private String name;
    private Scanner sc;

    public User(String name){

        this.name = name;
        this.sc = new Scanner(System.in);
    }

    public String getName() {
        return name;
    }

    public void offeredCard(Deck deck){
        displayUserHand();
        String answer = userTwistOrStick();

        if (answer.equals("stick")){
            System.out.println();
            return;
        }
        if (answer.equals("twist")){
            takeCard(deck);
            System.out.println(String.format("%s draws a %s!", this.name, getHand().get(getHand().size()-1).printCard()));

            if (isBust()) {
                System.out.println("Uh-oh!");
                System.out.println();

                return;
            } else
                offeredCard(deck);
        }
    }

    public String userGetInput() {
        String answer = sc.nextLine().toLowerCase();
        return answer;
    }

    public String userTwistOrStick(){
        System.out.println();
        System.out.println(String.format("Would you like to stick or twist?", this.name));
        String answer = "placeholder";
        do {
             answer = userGetInput();
        } while(!(answer.equals("stick") || answer.equals("twist")));
        return answer;
    }



    public String formatHand(){
        String fullHand = "";
        for (Card card : getHand()){
            fullHand += card.printCard() + ", ";
        }
        return fullHand;
    }

    public void displayUserHand(){
        String fullHand = formatHand();
        System.out.println(String.format("%s, you have %s", getName(), fullHand));
    }

}
