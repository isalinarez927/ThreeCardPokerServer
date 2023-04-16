import java.util.ArrayList;

public class Player {
    public ArrayList<Card> hand;
    public Integer numberID;

    public Integer balance;

    public Integer anteBet;
    public Integer ppBet;
    public Integer playBet;

    //todo: test all


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


    public int getAnteBet()
    {
        return anteBet;
    }
    public void setAnteBet(int ante)
    {
        this.anteBet = ante;
    }
    public int getPPBet()
    {
        return ppBet;
    }
    public void setPPBet(int pp)
    {
        this.ppBet = pp;
    }
    public int getPlayBet()
    {
        return playBet;
    }
    public void setPlayBet(int play)
    {
        this.playBet = play;
    }

}
