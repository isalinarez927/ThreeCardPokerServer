import java.util.ArrayList;

public class Game {
    private Deck deck;
    private ArrayList<Player> players;

    private ArrayList<Card> dealerHand;

    private ThreeCardLogic logic;

    private int pot;

    public Game(){
        logic = new ThreeCardLogic();
        deck = new Deck();
        deck.MakeDeck();
        dealerHand = new ArrayList<>();
        deal(dealerHand);
        players = new ArrayList<>();
    }


    public void addPlayer(Player player) {
        players.add(player);
    }

    public boolean dealerQualify(){
        return (logic.evalHand(dealerHand) > 11);

    }


    //deals three cards and assigns to player
    public void deal(Player player) {
        // Deal 3 cards to player
            ArrayList<Card> hand = new ArrayList<Card>();
            for (int i = 0; i < 3; i++) {
                Card card = deck.draw();
                hand.add(card);
            }
            player.setHand(hand);
    }

    //deals three cards and assigns to ArrayList (used for dealer)
    public void deal(ArrayList<Card> dH) {
        // Deal 3 cards to player
        ArrayList<Card> hand = new ArrayList<Card>();
        for (int i = 0; i < 3; i++) {
            Card card = deck.draw();
            hand.add(card);
        }
        dH = hand;
    }






}
