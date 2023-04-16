import java.io.Serializable;
import java.util.ArrayList;

public class PokerInfo implements Serializable {


    Integer numConnections;

    Player player;

    ArrayList<Card> dealerHand;

    ArrayList<Card> hand;

    public Integer balance;

    public Integer anteBet;

    public Integer ppBet;

    public Integer playBet;

    int pot;

    //todo: test all
    // wins, loses
    // win pp, lose
    // dealer qualify
    // hands of both
    // number of clients connected, when client connects
    // PUT IN LIST VIEW




}
