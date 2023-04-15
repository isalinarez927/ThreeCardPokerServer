import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> deck;

    //MAKE DECK OF CARDS
    public void MakeDeck() {
        deck = new ArrayList<Card>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        for (String suit : suits) {
            for (String rank : ranks) {
                Card card = new Card(suit, rank);
                deck.add(card);
            }
        }
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
