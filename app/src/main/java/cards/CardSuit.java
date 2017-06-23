package cards;

/**
 * Created by stuartbryce on 2017-06-22.
 */

public enum CardSuit {

    HEARTS ("Hearts"),
    DIAMONDS ("Diamonds"),
    JACKS ("Jacks"),
    SPADES ("Spades");

    private String name;

    CardSuit(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
