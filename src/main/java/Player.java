import java.util.ArrayList;

public class Player {
    public ArrayList<Card> hand;
    public Integer numberID;

    public Integer balance;

    public Integer anteBet;
    public Integer ppBet;
    public Integer playBet;


    public Player(Integer id){
        this.balance = 150;
        this.numberID = id;


    }

    //setter method for hand
    public void setHand(ArrayList<Card> dealtHand){ hand = dealtHand; }
    //getter method for hand
    public ArrayList<Card> getHand(){ return hand; }

    //getter method for number ID
    public Integer getNumberID(){ return numberID; }


    //getter method for Balance
    public Integer getBalance(){ return balance; }
}
