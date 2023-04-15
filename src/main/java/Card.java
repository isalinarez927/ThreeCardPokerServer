import java.util.ArrayList;
import java.util.Collections;

public class Card {
    private String rank,suit;

    public Card(String suit, String rank) {
        this.rank = rank;
        this.suit = suit;
    }


    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public String readCard(){
        return rank + " of " + suit;
    }





}