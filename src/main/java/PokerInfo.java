import java.io.Serializable;
import java.util.ArrayList;

public class PokerInfo implements Serializable {
    Integer numConnections;
    Player player;
    ArrayList<Card> playerHand;

    ArrayList<Card> dealerHand;



}
