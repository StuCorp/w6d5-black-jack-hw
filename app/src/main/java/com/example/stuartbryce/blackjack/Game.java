package com.example.stuartbryce.blackjack;

import java.util.ArrayList;

/**
 * Created by stuartbryce on 2017-06-23.
 */

public class Game {

    ArrayList<User> users;
    Dealer dealer;
    Deck deck;
    Viewer viewer;

    public Game(ArrayList<User> users, Dealer dealer){
        this.users = users;
        this.dealer = dealer;
        this.deck = new Deck();
        this.viewer = new Viewer(users, dealer);
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

    public void checkPlayerForBlackJack(User user, ArrayList<Integer> userIndexNums){
        if (checkForBlackJack(user)){
            System.out.println(String.format("%s has BlackJack!", user.getName()));
            displayResults(1, user);
//                users.remove(user);
            userIndexNums.add(users.indexOf(user));
        }
        }

    public void checkPlayersForBlackJack(){
        ArrayList<Integer> bjUsersIndexNum = new ArrayList<>();
        for (User user : users){
            checkPlayerForBlackJack(user, bjUsersIndexNum);
        }
        if (bjUsersIndexNum.size() > 0){
            for (int indexNum : bjUsersIndexNum){
                users.remove(indexNum);
            }
        }
    }


    public void checkDealerForBlackJack() {
        if (checkForBlackJack(dealer)) {
            for (User user : users) {
                System.out.println("Dealer has BlackJack!");
                displayResults(-1, user);
            }
            users.clear();
        }
    }



    public void offerCards(Player player){
        player.offeredCard(deck);
    }

    public void offerCardsToUsers(){
        for (User user : users){
            offerCards(user);
        }
    }

    public void checkAllResults() {
        if (users.size() > 0) {
            for (User user : users) {
                int result = assessResult(user);
                displayResults(result, user);
            }
        }
    }

//    return 1 for user win, 0 for draw, -1 for dealer win
    public int assessResult(User user){

//        user is bust scenario
        if (user.bestScore() == 99){
            return -1;
        }
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

    public void checkDealerForBust(){
        if (dealer.isBust()){
            for(User user : users){
                System.out.println("Dealer is bust!");
                displayResults(1, user);
            }
            users.clear();
            }
        }


    public void checkForUserBust(User user, ArrayList<Integer> indexCollector){
        if (user.isBust()){
            System.out.println(String.format("%s is bust!", user.getName()));
            displayResults(-1, user);
            indexCollector.add(users.indexOf(user));
        }
    }

    public void checkForPlayersBust(){
        ArrayList<Integer> busterUsersIndexNum = new ArrayList<>();
        for (User user : users){
            checkForUserBust(user, busterUsersIndexNum);
        }
        if (busterUsersIndexNum.size() > 0){
            for (int indexNum : busterUsersIndexNum){
                users.remove(indexNum);
            }
        }
    }


    public void run(){
        deck.fillDeck();
        initialDeal();
        viewer.displayUserHands();
        viewer.displayerDealerFirstCard();
        checkPlayersForBlackJack();

        offerCardsToUsers();
//        once players are offered cards, dealer reveals second card and we check again for BJ
//        then the dealer can take a card if doesn't have BJ
//        checkusersforBust
        checkForPlayersBust();
        viewer.displayerDealerHand();
        checkDealerForBlackJack();
//        need to add guards to stop these happening if all players are bust or dealer has BJ...and above for user BJ
        offerCards(dealer);
        checkDealerForBust();
        checkAllResults();
        return;
    }



}
