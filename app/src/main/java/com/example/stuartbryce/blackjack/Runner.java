package com.example.stuartbryce.blackjack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by stuartbryce on 2017-06-24.
 */

public class Runner {



    public static void main(String[] args) {
//        User user = new User("stu");
//        User user2 = new User("mary");
//        users.add(user);
//        users.add(user2);
        Dealer dealer = new Dealer();
//        Scanner sc = new Scanner(System.in);
        ArrayList<User> users = setup();
        Game game = new Game(users, dealer);
        game.run();
    }

    public static ArrayList<User> setup() {
        ArrayList<User> users = new ArrayList<User>();
        int numPlayers = askNumPlayers();
        setupPlayers(numPlayers, users);
        return users;
    }

    public static int askNumPlayers() {
        System.out.println("Welcome to BJ Supreme");
        System.out.println("How many players? 1 - 10");
        int answer;
        do {
            answer = Integer.parseInt(userGetInput());
        } while (!(answer > 0 && answer < 10));
        return answer;
    }

    public static String userGetInput() {
        return new Scanner(System.in).nextLine();
    }

    public static void setupPlayers(int numPlayers, ArrayList<User> users) {
        int currentPlayer = 1;
        while (numPlayers > 0) {
            System.out.println(String.format("Player %d, please enter your name!", currentPlayer));
            String name = askName();
            User user = new User(name);
            users.add(user);
            currentPlayer++;
            numPlayers--;
        }
    }

    public static String askName() {
        String answer;
        do {
            answer = userGetInput();
        } while (!(answer.length() > 0 && answer.length() < 20));
        return answer;
    }



}


