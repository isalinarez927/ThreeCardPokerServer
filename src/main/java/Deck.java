import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    //todo: test all
    public ArrayList<Card> deck;

    public Deck(){
        deck = new ArrayList<Card>();
        deck = MakeDeck();
    }

    //MAKE DECK OF CARDS
    private ArrayList<Card> MakeDeck() {
        ArrayList<Card> myDeck = new ArrayList<Card>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        for (String suit : suits) {
            for (String rank : ranks) {
                Card card = new Card(suit, rank);
                myDeck.add(card);}}
        return myDeck;
    }

    // SHUFFLE THE CARDS
    public void shuffle() {
        Collections.shuffle(deck);
    }


    // DRAW THREE CARDS
    public Card draw() {
            Card card = deck.get(0);
            deck.remove(0);
        return card;
    }


    //RETURNS CARD THAT IS NOT PART OF ARRAYLIST IN ORDER TO NOT REPEAT A DRAW
    private Card drawNewDeck(ArrayList<Card> excludedCards) {
        Card card;
        do {
            int index = (int) (Math.random() * deck.size());
            card = deck.get(index);
        } while (excludedCards.contains(card));
        deck.remove(card);
        return card;
    }
}
