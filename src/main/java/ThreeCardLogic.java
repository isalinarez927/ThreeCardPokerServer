import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ThreeCardLogic {
    static Map<String, Integer> cardRankVals;

  static{
        cardRankVals =new HashMap<>();
        cardRankVals.put("2",2);
        cardRankVals.put("3",3);
        cardRankVals.put("4",4);
        cardRankVals.put("5",5);
        cardRankVals.put("6",6);
        cardRankVals.put("7",7);
        cardRankVals.put("8",8);
        cardRankVals.put("9",9);
        cardRankVals.put("10",10);
        cardRankVals.put("Jack",11);
        cardRankVals.put("Queen",12);
        cardRankVals.put("King",13);
        cardRankVals.put("Ace",14);
    }


    // RETURNS TRUE IF PAIR IS FOUND
    public static boolean pair(ArrayList<Card> hand){
                //Checks if second and third cards have same rank and that the first is different
        if ((hand.get(1).getRank() == hand.get(2).getRank() && hand.get(1).getRank() != hand.get(0).getRank())
                //Checks if first and third cards have same rank and that the second is different
                || (hand.get(0).getRank() == hand.get(2).getRank() && hand.get(0).getRank() != hand.get(1).getRank())
                //Checks if first and second cards have same rank and that the third is different
                || (hand.get(0).getRank() == hand.get(1).getRank() && hand.get(0).getRank() != hand.get(2).getRank())) {
            return true;}
        return false;
    };


    //RETURNS TRUE IF ALL CARD SUITS ARE THE SAME
    public static boolean flush(ArrayList<Card> hand){
        String suit = hand.get(0).getSuit(); //initializes suit
        //compares other card suits to the first one
        if (hand.get(1).getSuit() == suit && hand.get(2).getSuit() == suit){ return true;}
        return false;
    };


    //RETURNS TRUE IF ALL CARD RANKS ARE CONSECUTIVE
    public static boolean straight(ArrayList<Card> hand){
        ArrayList<Integer> nums = new ArrayList<>();
        for(Card c: hand){
            nums.add(cardRankVals.get(c.getRank()));
        }
        Collections.sort(nums);
        Integer inc = nums.get(0);
        if (nums.get(1) != inc+1 || nums.get(2)!=inc+2){ return false; }
        return true;
    };


    //RETURNS TRUE IF ALL CARD RANKS ARE THE SAME
    public static boolean threeOfAKind(ArrayList<Card> hand){
        String rank = hand.get(0).getRank(); //initializes rank
        //compares other card ranks to the first one
        if (hand.get(1).getRank() == rank && hand.get(2).getRank() == rank){ return true;}
        return false;

    };


    //RETURNS TRUE IF CARD RANKS ARE THE SAME AND CARDS ARE CONSECUTIVE
    public static boolean straightFlush(ArrayList<Card> hand){
        return (straight(hand) && flush(hand));
    };


    //RETURNS HIGHEST RANK IN HAND
    public static Integer getHighCard(ArrayList<Card> hand) {
        //will range from 2-14(ace high card = 14)
        ArrayList<Integer> nums = new ArrayList<>();
        for(Card c: hand){
            nums.add(cardRankVals.get(c.getRank()));
        } Collections.sort(nums); //sort in ascending order
        return nums.get(2); //returns last(MAX) int value in array list
    }


    //TAKES IN HAND THAT IS PAIR AND RETURNS RANK OF PAIR
    public static Integer getPairValue(ArrayList<Card> hand) {
        //will range from 2-14(ace high card = 14)
        ArrayList<Integer> nums = new ArrayList<>();
        for(Card c: hand){
            nums.add(cardRankVals.get(c.getRank()));
        } Collections.sort(nums); //sort in ascending order
        return nums.get(1); //returns from index 1 because it will always hold pair val
    }


    //TAKES IN HAND THAT IS PAIR AND RETURNS RANK OF NON PAIR CARD
    public static Integer getNonPairValue(ArrayList<Card> hand) {
        //will range from 2-14(ace high card = 14)
        ArrayList<Integer> nums = new ArrayList<>();
        for(Card c: hand){
            nums.add(cardRankVals.get(c.getRank()));
        } Collections.sort(nums); //sort in ascending order
        if(nums.get(1)!=nums.get(0)){
            return nums.get(0);
        }
        return nums.get(2);
    }


    //evaluates score for hand of three cards
    public static Integer evalHand(ArrayList<Card> hand){
        Integer score = getHighCard(hand);
        if(straightFlush(hand)){score +=100;} //add with high card
        else if (threeOfAKind(hand)) {score +=80;} //add with high card
        else if(straight(hand)){score +=60;} //add with high card
        else if(flush(hand)){score +=40;} //add with high card
        else if(pair(hand)){score = 20;} //do not add with high card
        return score;
    };


    //returns integer based on if player or dealer has higher score
    public static int compareHands(ArrayList<Card>dealer, ArrayList<Card>player){
        //, 0 if dealer wins, 2 for draw
        Integer dealerScore = evalHand(dealer);
        Integer playerScore = evalHand(player);

        if(dealerScore == playerScore && dealerScore == 20){ // if both got pairs
            if(getPairValue(dealer)==getPairValue(player)){ // if high card of pairs are same
                if(getNonPairValue(dealer) == getNonPairValue(player)){ // if high card of non pair are same
                    return 2; //2 for draw
                }
                dealerScore+=getNonPairValue(dealer);
                playerScore+=getNonPairValue(player); }
            dealerScore+=getPairValue(dealer);
            playerScore+=getPairValue(player); }

        else if (dealerScore == playerScore){
            return 2; // 2 for draw
        }

        if(playerScore > dealerScore){ return 1;} //1 if player wins

        return 0; // 0 if dealer wins
    };


    //evaluates bet for pair plus given three card hand
    public static int evalPPWinnings(ArrayList<Card>hand, int bet){
        Integer betMultiplier = 0;
        if(straightFlush(hand)){betMultiplier = bet * 40;}
        else if (threeOfAKind(hand)) {betMultiplier = bet * 30;}
        else if(straight(hand)){betMultiplier = bet * 6;}
        else if(flush(hand)){betMultiplier = bet * 3;}
        else if(pair(hand)){betMultiplier = bet;}
        return betMultiplier;
    };
}
