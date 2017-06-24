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

    public String userGetInput() {
        String answer = sc.nextLine().toLowerCase();
        return answer;
    }

    public String userTwistOrStick(){
        System.out.println("Would you like to stick or twist?");
        String answer = "placeholder";
        do {
             answer = userGetInput();
        } while(!(answer.equals("stick") || answer.equals("twist")));
        return answer;
    }


}
