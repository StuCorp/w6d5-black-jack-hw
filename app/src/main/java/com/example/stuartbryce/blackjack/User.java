package com.example.stuartbryce.blackjack;
import java.util.Scanner;

import static android.R.id.input;


/**
 * Created by stuartbryce on 2017-06-23.
 */

public class User extends Player {

    private Scanner sc;

    public User(){
        this.sc = new Scanner(System.in);
    }

    public void offeredCard(Deck deck){
        String answer = userTwistOrStick();

        if (answer.equals("stick")){
            return;
        }
        if (answer.equals("twist")){
            takeCard(deck);
            if (isBust()) {
                return;
            } else
                offeredCard(deck);
        }
    }

    public String userTwistOrStick(){
        System.out.println("Would you like to stick or twist?");
        String answer = "placeholder";
        do {
             answer = sc.nextLine().toLowerCase();
//            char choice = input.charAt(0);
        } while(!(answer.equals("stick") || answer.equals("twist")));
        return answer;
    }


}
