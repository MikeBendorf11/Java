package f_CardGames;

public class testBlackjack {
	public static void main(String[]args){
		Deck deck = new Deck();
		deck.shuffle();
		Card card = new Card();
		card = deck.dealCard();
		TextIO.put("Regular card dealed: "+ card + ", value: " + card.getValue());
	
		
		Hand myhand=new BlackjackHand();
		int value = 0;
		int value2 = 0;
		TextIO.put("\n\nBLACKJACK TEST\n" );
		for (int i=0;i<8;i++){
			Card mycard = deck.dealCard();
						myhand.addCard(mycard);
			TextIO.put("\n" + mycard + "= " + ((BlackjackHand) myhand).getBlackjackValue());
			value=((BlackjackHand) myhand).getBlackjackValue();
			
			if (value<21){value2=value;}
			if (value==21){
				TextIO.put("\nYou WIN at 21!!!");
				break;
			}
			if (value>21){
				TextIO.put("\nLast valid Blackjack Value: " + value2);
				TextIO.put("\nYou lost Blackjack Value: " + value);
				break;	
			}
		}
		TextIO.put("\nNumber of cards dealed: " + myhand.getCardCount());
	}
}
