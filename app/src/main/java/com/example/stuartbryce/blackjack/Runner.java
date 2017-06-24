package com.example.stuartbryce.blackjack;

import java.util.ArrayList;

/**
 * Created by stuartbryce on 2017-06-24.
 */

public class Runner {

    public static void main(String[] args) {
        User user = new User("stu");
        User user2 = new User("mary");
        Dealer dealer = new Dealer();
        ArrayList<User> users = new ArrayList<User>();
        users.add(user);
        users.add(user2);
        Game game = new Game(users, dealer);
        game.run();
    }



}
