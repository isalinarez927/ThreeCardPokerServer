import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards {
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
    public ArrayList<Card> draw() {
        ArrayList<Card> playerCards = new ArrayList<Card>();
        for (int i = 0; i < 3; i++) {
            Card card = drawNewDeck(playerCards);
            playerCards.add(card);
        }
        return playerCards;
    }

    //RETURNS CARD THAT IS NOT PART OF ARRAYLIST OF CARD PARAMETER
    //      USED TO NOT REPEAT A DRAW
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