import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class MyTest {
	public static ThreeCardLogic logic;
	public static Deck deck;
	public static Player player;
	public static ArrayList<Card> none;
	public static ArrayList<Card> pair;
	public static ArrayList<Card> str;
	public static ArrayList<Card> flush;
	public static ArrayList<Card> strFlush;
	public static ArrayList<Card> threeOfAKind;



	@BeforeAll
	static void setUpVariables(){

		pair = new ArrayList<Card>();
		none = new ArrayList<Card>();
		flush = new ArrayList<Card>();
		strFlush = new ArrayList<Card>();
		logic = new ThreeCardLogic();
		//todo: might have to update later
		player = new Player(1);
	}
	@BeforeAll
	static void setupForNone() {
		none.add(new Card("Hearts", "5"));
		none.add(new Card("Diamonds", "8"));
		none.add(new Card("Spades", "9"));
	}
	@BeforeAll
	static void setupForPair() {
		pair.add(new Card("Hearts", "8"));
		pair.add(new Card("Diamonds", "8"));
		pair.add(new Card("Diamonds", "9"));
	}
	@BeforeAll
	static void setupForStraight() {
		str = new ArrayList<Card>();
		str.add(new Card("Hearts", "8"));
		str.add(new Card("Diamonds", "7"));
		str.add(new Card("Clubs", "6"));
	}
	@BeforeAll
	static void setupForFlush() {
		flush.add(new Card("Hearts", "6"));
		flush.add(new Card("Hearts", "9"));
		flush.add(new Card("Hearts", "3"));
	}
	@BeforeAll
	static void setupForThreeOfAKind() {
			threeOfAKind = new ArrayList<Card>();
			threeOfAKind.add(new Card("Spades", "8"));
			threeOfAKind.add(new Card("Diamonds", "8"));
			threeOfAKind.add(new Card("Clubs", "8"));
	}
	@BeforeAll
	static void setupForStraightFlush() {
		strFlush = new ArrayList<Card>();
		strFlush.add(new Card("Diamonds", "6"));
		strFlush.add(new Card("Diamonds", "7"));
		strFlush.add(new Card("Diamonds", "8"));
	}




	@Test
	void pairTest1() {
		assertEquals(true,logic.pair(pair));
	}
	@Test
	void pairTest2() {
		ArrayList<Card> pair2 = new ArrayList<>();
		pair2.add(new Card("Hearts", "8"));
		pair2.add(new Card("Diamonds", "9"));
		pair2.add(new Card("Diamonds", "9"));
		assertEquals(true,logic.pair(pair2));
	}
	@Test
	void pairTest3() {
		ArrayList<Card> pair3 = new ArrayList<>();
		pair3.add(new Card("Hearts", "9"));
		pair3.add(new Card("Diamonds", "7"));
		pair3.add(new Card("Diamonds", "9"));
		assertEquals(true,logic.pair(pair3));
	}
	@Test
	void pairTest4() {

		assertEquals(false,logic.pair(none));
	}




	@Test
	void straightTest1() {
		assertEquals(true,logic.straight(str));
	}
	@Test
	void straightTest2() {
		ArrayList<Card> str2 = new ArrayList<Card>();
		str2.add(new Card("Hearts", "10"));
		str2.add(new Card("Diamonds", "9"));
		str2.add(new Card("Clubs", "Jack"));
		assertEquals(true,logic.straight(str2));
	}
	@Test
	void straightTest3() {
		ArrayList<Card> str2 = new ArrayList<Card>();
		str2.add(new Card("Hearts", "Queen"));
		str2.add(new Card("Diamonds", "King"));
		str2.add(new Card("Clubs", "Jack"));
		assertEquals(true,logic.straight(str2));
	}
	@Test
	void straightTest4() { assertEquals(false,logic.straight(none));}




	@Test
	void flushTest1() {
		assertEquals(true,logic.flush(flush));
	}
	@Test
	void flushTest2() {
		ArrayList<Card> flush2 = new ArrayList<>();
		flush2.add(new Card("Diamonds", "Ace"));
		flush2.add(new Card("Diamonds", "4"));
		flush2.add(new Card("Diamonds", "King"));
		assertEquals(true,logic.flush(flush2));
	}
	@Test
	void flushTest3() {
		ArrayList<Card> flush2 = new ArrayList<>();
		flush2.add(new Card("Spades", "Ace"));
		flush2.add(new Card("Spades", "4"));
		flush2.add(new Card("Spades", "King"));
		assertEquals(true,logic.flush(flush2));
	}
	@Test
	void flushTest4() {
		ArrayList<Card> flush2 = new ArrayList<>();
		flush2.add(new Card("Clubs", "Ace"));
		flush2.add(new Card("Clubs", "4"));
		flush2.add(new Card("Clubs", "King"));
		assertEquals(true,logic.flush(flush2));
	}
	@Test
	void flushTest5() { assertEquals(false,logic.flush(none));}




	@Test
	void straightFlushTest1() {
		assertEquals(true,logic.straightFlush(strFlush));
	}
	@Test
	void straightFlushTest2() {
		ArrayList<Card> strFlush2 = new ArrayList<>();
		strFlush2.add(new Card("Diamonds", "King"));
		strFlush2.add(new Card("Diamonds", "Ace"));
		strFlush2.add(new Card("Diamonds", "Queen"));
		assertEquals(true,logic.straightFlush(strFlush2));
	}
	@Test
	void straightFlushTest3() { assertEquals(false,logic.straightFlush(none)); }



	@Test
	void threeOfAKindTest1() {
		assertEquals(true,logic.threeOfAKind(threeOfAKind));
	}
	@Test
	void threeOfAKindTest2() {
		ArrayList<Card> threeOfAKind2 = new ArrayList<>();
		threeOfAKind2.add(new Card("Spades", "Jack"));
		threeOfAKind2.add(new Card("Clubs", "Jack"));
		threeOfAKind2.add(new Card("Hearts", "Jack"));
		assertEquals(true,logic.threeOfAKind(threeOfAKind2));
	}
	@Test
	void threeOfAKindTest3() {
		assertEquals(false,logic.threeOfAKind(none));}




	@Test
	public void testGetHighCard1() {
		ArrayList<Card> hand = new ArrayList<>();
		hand.add(new Card("hearts", "5"));
		hand.add(new Card("spades", "Ace"));
		hand.add(new Card("hearts", "King"));

		// Verify that the high card is correct
		assertEquals(14, logic.getHighCard(hand));

	}
	@Test
	public void testGetHighCard2() {
		// Create a hand of cards without an ace
		ArrayList<Card> hand = new ArrayList<>();
		hand.add(new Card("hearts", "5"));
		hand.add(new Card("diamonds", "9"));
		hand.add(new Card("clubs", "Jack"));

		assertEquals(11, logic.getHighCard(hand));
	}
	@Test
	public void testGetHighCard3() {
		// Create a hand of cards without an ace
		ArrayList<Card> hand = new ArrayList<>();
		hand.add(new Card("hearts", "5"));
		hand.add(new Card("diamonds", "9"));
		hand.add(new Card("clubs", "6"));

		assertEquals(9, logic.getHighCard(hand));
	}





	@Test
	public void testGetPairValue1() {
		// Create a hand of cards with a pair of twos
		ArrayList<Card> hand = new ArrayList<>();
		hand.add(new Card("hearts", "2"));
		hand.add(new Card("diamonds", "9"));
		hand.add(new Card("spades", "2"));

		// Verify that the pair value is correct
		assertEquals(2, logic.getPairValue(hand));
	}
	@Test
	public void testGetPairValue2() {
		// Create a hand of cards with a pair of aces
		ArrayList<Card> hand = new ArrayList<>();
		hand.add(new Card("hearts", "5"));
		hand.add(new Card("diamonds", "Ace"));
		hand.add(new Card("spades", "Ace"));

		// Verify that the pair value is correct
		assertEquals(14, logic.getPairValue(hand));
	}




	@Test
	public void testGetNonPairValue1() {
		// Create a hand of cards with a pair of twos
		ArrayList<Card> hand = new ArrayList<>();
		hand.add(new Card("hearts", "2"));
		hand.add(new Card("diamonds", "Ace"));
		hand.add(new Card("clubs", "2"));
		// Verify that the non-pair value is correct
		assertEquals(14, logic.getNonPairValue(hand));
	}
	@Test
	public void testGetNonPairValue2() {
		// Create a hand of cards with a pair of Jacks
		ArrayList<Card> hand = new ArrayList<>();
		hand.add(new Card("hearts", "5"));
		hand.add(new Card("clubs", "Jack"));
		hand.add(new Card("spades", "Jack"));

		// Verify that the non-pair value is correct
		assertEquals(5, logic.getNonPairValue(hand));
	}




	@Test
	public void testEvalHandNone(){
		// Test for a hand with high card only
		ArrayList<Card> hand1 = new ArrayList<>();
		hand1.add(new Card("Hearts", "2"));
		hand1.add(new Card("Spades", "4"));
		hand1.add(new Card("Diamonds", "8"));
		assertEquals(8, logic.evalHand(hand1));
	}
	@Test
	public void testEvalHandPair(){
		// Test for a hand with a pair
		ArrayList<Card> hand6 = new ArrayList<>();
		hand6.add(new Card("Hearts", "9"));
		hand6.add(new Card("Spades", "9"));
		hand6.add(new Card("Diamonds", "Ace"));
		assertEquals(20, logic.evalHand(hand6));
	}
	@Test
	public void testEvalHandFlush(){
		// Test for a hand with a flush
		ArrayList<Card> hand5 = new ArrayList<>();
		hand5.add(new Card("Diamonds", "2"));
		hand5.add(new Card("Diamonds", "4"));
		hand5.add(new Card("Diamonds", "Ace"));
		assertEquals(54, logic.evalHand(hand5));
	}
	@Test
	public void testEvalHandStraight(){
		// Test for a hand with a straight
		ArrayList<Card> hand4 = new ArrayList<>();
		hand4.add(new Card("Hearts", "6"));
		hand4.add(new Card("Spades", "7"));
		hand4.add(new Card("Diamonds", "8"));
		assertEquals(68, logic.evalHand(hand4));}
	@Test
	public void testEvalHandThreeOfKind(){
		// Test for a hand with three of a kind
		ArrayList<Card> hand3 = new ArrayList<>();
		hand3.add(new Card("Hearts", "5"));
		hand3.add(new Card("Spades", "5"));
		hand3.add(new Card("Diamonds", "5"));
		assertEquals(85, logic.evalHand(hand3));}
	@Test
	public void testEvalHandStrFlush(){
		// Test for a hand with a straight flush
		ArrayList<Card> hand2 = new ArrayList<>();
		hand2.add(new Card("Hearts", "10"));
		hand2.add(new Card("Hearts", "Jack"));
		hand2.add(new Card("Hearts", "Queen"));
		assertEquals(112, logic.evalHand(hand2));
	}




	@Test
	void testEvalPPWinningsWithStraightFlush() {
		assertEquals(400, logic.evalPPWinnings(strFlush, 10));
	}
	@Test
	void testEvalPPWinningsWithThreeOfAKind() {
		assertEquals(300, logic.evalPPWinnings(threeOfAKind, 10));
	}
	@Test
	void testEvalPPWinningsWithStraight() {
		assertEquals(60, logic.evalPPWinnings(str, 10));
	}
	@Test
	void testEvalPPWinningsWithFlush() {
		assertEquals(30, logic.evalPPWinnings(flush, 10));
	}
	@Test
	void testEvalPPWinningsWithPair() {
		assertEquals(10, logic.evalPPWinnings(pair, 10));
	}
	@Test
	void testEvalPPWinningsWithNone() {
		assertEquals(-10, logic.evalPPWinnings(none, 10));
	}


	@Test
	public void testCompareHands_DealerWins() {
		ArrayList<Card> dealerHand = new ArrayList<>();
		ArrayList<Card> playerHand = new ArrayList<>();

		dealerHand.add(new Card("Clubs", "Ace"));
		dealerHand.add(new Card("Diamonds", "Queen"));
		dealerHand.add(new Card("Hearts", "Jack"));

		playerHand.add(new Card("Hearts", "King"));
		playerHand.add(new Card("Spades", "Queen"));
		playerHand.add(new Card("Clubs", "10"));


		assertEquals(0, logic.compareHands(dealerHand, playerHand));
	}

	@Test
	public void testCompareHands_PlayerWins() {
		ArrayList<Card> dealerHand = new ArrayList<>();
		ArrayList<Card> playerHand = new ArrayList<>();
		dealerHand.add(new Card("Clubs", "Ace"));
		dealerHand.add(new Card("Clubs", "Queen"));
		dealerHand.add(new Card("Clubs", "Jack"));

		playerHand.add(new Card("Hearts", "King"));
		playerHand.add(new Card("Spades", "Queen"));
		playerHand.add(new Card("Clubs", "Jack"));

		assertEquals(1, logic.compareHands(dealerHand, playerHand));
	}

	@Test
	public void testCompareHands_Draw() {
		ArrayList<Card> dealerHand = new ArrayList<>();
		ArrayList<Card> playerHand = new ArrayList<>();
		dealerHand.add(new Card("Clubs", "Ace"));
		dealerHand.add(new Card("Diamonds", "Queen"));
		dealerHand.add(new Card("Hearts", "Jack"));

		playerHand.add(new Card("Clubs", "Ace"));
		playerHand.add(new Card("Diamonds", "Queen"));
		playerHand.add(new Card("Hearts", "Jack"));

		assertEquals(2, logic.compareHands(dealerHand, playerHand));
	}


	@Test
	public void testCompareHands_PairDraw() {
		ArrayList<Card> dealerHand = new ArrayList<>();
		ArrayList<Card> playerHand = new ArrayList<>();
		dealerHand.add(new Card("Clubs", "Ace"));
		dealerHand.add(new Card("Diamonds", "Ace"));
		dealerHand.add(new Card("Hearts", "Jack"));

		playerHand.add(new Card("Clubs", "Ace"));
		playerHand.add(new Card("Diamonds", "Ace"));
		playerHand.add(new Card("Hearts", "Jack"));

		assertEquals(2, logic.compareHands(dealerHand, playerHand));
	}

	@Test
	public void testCompareHands_PlayerNonPairWin() {
		ArrayList<Card> dealerHand = new ArrayList<>();
		ArrayList<Card> playerHand = new ArrayList<>();
		dealerHand.add(new Card("Clubs", "Ace"));
		dealerHand.add(new Card("Diamonds", "Ace"));
		dealerHand.add(new Card("Hearts", "2"));

		playerHand.add(new Card("Clubs", "Ace"));
		playerHand.add(new Card("Diamonds", "Ace"));
		playerHand.add(new Card("Hearts", "Jack"));

		assertEquals(1, logic.compareHands(dealerHand, playerHand));
	}

	@Test
	public void testCompareHands_PlayerPairWin() {
		ArrayList<Card> dealerHand = new ArrayList<>();
		ArrayList<Card> playerHand = new ArrayList<>();
		dealerHand.add(new Card("Clubs", "5"));
		dealerHand.add(new Card("Diamonds", "5"));
		dealerHand.add(new Card("Hearts", "King"));

		playerHand.add(new Card("Clubs", "Ace"));
		playerHand.add(new Card("Diamonds", "Ace"));
		playerHand.add(new Card("Hearts", "Jack"));

		assertEquals(1, logic.compareHands(dealerHand, playerHand));
	}


	@Test
	void testMakeDeck() {
		deck = new Deck();
		int expectedSize = 52;
		int actualSize = deck.deck.size();
		assertEquals(expectedSize, actualSize);
	}

	@Test
	void testDeckContainsCards() {
		deck = new Deck();

		String hA = deck.deck.get(0).readCard();
		String d2 = deck.deck.get(14).readCard();
		String c3 = deck.deck.get(28).readCard();
		String sK = deck.deck.get(51).readCard();

		assertEquals("Ace of Hearts",hA);
		assertEquals("2 of Diamonds",d2);
		assertEquals("3 of Clubs",c3);
		assertEquals("King of Spades",sK);
	}




	@Test
	void testShuffle1() {
		deck = new Deck();
		Deck shuffled = new Deck();
		shuffled.shuffle();
		assertFalse(deck.deck.equals(shuffled));
	}

	@Test
	void testDraw1() {
		deck = new Deck();
		int initialSize = deck.deck.size();
		deck.draw();
		assertEquals(initialSize - 1, deck.deck.size());
	}


	@Test
	void testDraw2() {
		deck = new Deck();
		int initialSize = deck.deck.size();
		deck.draw(); deck.draw(); deck.draw();
		assertEquals(initialSize - 3, deck.deck.size());
	}


	@Test
	void testConstructorAndGetters() {
		String expectedSuit = "Hearts";
		String expectedRank = "Ace";
		Card card = new Card(expectedSuit, expectedRank);
		assertEquals(expectedSuit, card.getSuit());
		assertEquals(expectedRank, card.getRank());
	}

	@Test
	void testReadCard1() {
		String expectedString = "Ace of Hearts";
		Card card = new Card("Hearts", "Ace");
		assertEquals(expectedString, card.readCard());
	}

	@Test
	void testReadCard2() {
		String expectedString = "King of Spades";
		Card card = new Card("Spades", "King");
		assertEquals(expectedString, card.readCard());
	}


	@Test
	void dealerQualifyTest1() {
		ArrayList<Card> hand1 = new ArrayList<>();
		hand1.add(new Card("Diamonds", "2"));
		hand1.add(new Card("Clubs", "7"));
		hand1.add(new Card("Hearts", "4"));


		// Testing the method with the edge case where dealer hand is a Q-7-2 (does not qualify)
		boolean result1 = ThreeCardLogic.dealerQualify(hand1);
		assertFalse(result1);

	}

	@Test
	void dealerQualifyTest2() {
		ArrayList<Card> hand2 = new ArrayList<>();
		hand2.add(new Card("Diamonds", "2"));
		hand2.add(new Card("Clubs", "3"));
		hand2.add(new Card("Hearts", "4"));

		// Testing the method with the edge case where dealer hand is a A-K-Q (qualifies)
		boolean result2 = ThreeCardLogic.dealerQualify(hand2);
		assertTrue(result2);
	}




	@Test
	void updateWinningsTest1() {
		// create a player with a losing hand
		Player player = new Player(1);
		player.setAnteBet(10);
		player.setPlayBet(20);
		player.setPPBet(5);
		ArrayList<Card> playerHand = new ArrayList<>();
		playerHand.add(new Card("Hearts", "Queen"));
		playerHand.add(new Card("Clubs", "Jack"));
		playerHand.add(new Card("Clubs", "3"));
		player.setHand(playerHand);

		// create a dealer with a winning hand
		ArrayList<Card> dealerHand = new ArrayList<>();
		dealerHand.add(new Card("Spades", "Queen"));
		dealerHand.add(new Card("Spades", "Ace"));
		dealerHand.add(new Card("Diamonds", "King"));

		int expectedWinnings = 0 + logic.evalPPWinnings(playerHand, player.getPPBet());//-5;//todo check this
		int actualWinnings = logic.updateWinnings(player, dealerHand);

		assertEquals(expectedWinnings, actualWinnings);
	}


	@Test //todo
	void updateWinningsTest2() {
		// create a player with a winning hand
		Player player = new Player(1);
		player.setAnteBet(10);
		player.setPlayBet(20);
		player.setPPBet(5);
		ArrayList<Card> playerHand = new ArrayList<>();
		playerHand.add(new Card("Spades", "Queen"));
		playerHand.add(new Card("Spades", "Ace"));
		playerHand.add(new Card("Diamonds", "King"));
		player.setHand(playerHand);

		// create a dealer with a losing hand
		ArrayList<Card> dealerHand = new ArrayList<>();
		dealerHand.add(new Card("Hearts", "Queen"));
		dealerHand.add(new Card("Clubs", "Jack"));
		dealerHand.add(new Card("Clubs", "Queen"));

		int expectedWinnings = 10*2 + 20*2 + logic.evalPPWinnings(playerHand, player.getPPBet());
		int actualWinnings = logic.updateWinnings(player, dealerHand);

		assertEquals(expectedWinnings, actualWinnings);

	}



	@Test
	void updateWinningsTest3() {
		// create a player with a winning hand
		Player player = new Player(1);
		player.setAnteBet(10);
		player.setPlayBet(20);
		player.setPPBet(5);
		ArrayList<Card> playerHand = new ArrayList<>();
		playerHand.add(new Card("Spades", "Queen"));
		playerHand.add(new Card("Spades", "Ace"));
		playerHand.add(new Card("Diamonds", "King"));
		player.setHand(playerHand);

		// create a dealer with a losing hand
		ArrayList<Card> dealerHand = new ArrayList<>();
		dealerHand.add(new Card("Diamonds", "Queen"));
		dealerHand.add(new Card("Diamonds", "Ace"));
		dealerHand.add(new Card("Clubs", "King"));

		int expectedWinnings = 10 + 20 + logic.evalPPWinnings(playerHand, player.getPPBet());
		int actualWinnings = logic.updateWinnings(player, dealerHand);

		assertEquals(expectedWinnings, actualWinnings);
	}

	@Test
	void updateWinningsTest4() {
		// create a player with a winning hand
		Player player = new Player(1);
		player.setAnteBet(10);
		player.setPlayBet(20);
		player.setPPBet(5);
		ArrayList<Card> playerHand = new ArrayList<>();
		playerHand.add(new Card("Spades", "Queen"));
		playerHand.add(new Card("Spades", "Ace"));
		playerHand.add(new Card("Diamonds", "King"));
		player.setHand(playerHand);

		// create a dealer no qyalify
		ArrayList<Card> dealerHand = new ArrayList<>();
		dealerHand.add(new Card("Diamonds", "5"));
		dealerHand.add(new Card("Diamonds", "3"));
		dealerHand.add(new Card("Clubs", "2"));

		int expectedWinnings = 20 + logic.evalPPWinnings(playerHand, player.getPPBet());
		int actualWinnings = logic.updateWinnings(player, dealerHand);

		assertEquals(expectedWinnings, actualWinnings);
	}


	@Test
	public void testGetNumberID() {
		Player player = new Player(1);
		assertEquals(1, player.getNumberID());
	}

	@Test
	public void testGetBalance() {
		Player player = new Player(1);
		assertEquals(150, player.getBalance());
	}

	@Test
	public void testSetAndGetAnteBet() {
		Player player = new Player(1);
		player.setAnteBet(10);
		assertEquals(10, player.getAnteBet());
	}

	@Test
	public void testSetAndGetPPBet() {
		Player player = new Player(1);
		player.setPPBet(5);
		assertEquals(5, player.getPPBet());
	}

	@Test
	public void testSetAndGetPlayBet() {
		Player player = new Player(1);
		player.setPlayBet(20);
		assertEquals(20, player.getPlayBet());
	}

	@Test
	public void testSetAndGetHand() {
		Player player = new Player(1);
		ArrayList<Card> hand = new ArrayList<>();
		hand.add(new Card("Spades", "Ace"));
		hand.add(new Card("Hearts", "King"));
		hand.add(new Card("Diamonds", "3"));
		player.setHand(hand);
		assertEquals(hand, player.getHand());
	}








}










