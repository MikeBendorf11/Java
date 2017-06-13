package f_CardGames;

public class BlackjackPlay2 {
	static Hand dealerHand = new BlackjackHand();
	static Hand userHand = new BlackjackHand();
	static Deck deck = new Deck();
	static int userCount;
	static int dealerCount;
	static int userScore;
	static int dealerScore;
	static boolean isUserPlaying=true;
	public static void main(String[]args){
		boolean itsOn = true;
		deck.shuffle();
		
		while(itsOn){		// start of game loop
		// Static variable initialization 89every time user restarts the game
		dealerCount=0; userCount=0;
		dealerHand.clear(); userHand.clear();isUserPlaying=true;
		int dealerWins= dealerScore; int userWins=userScore; // winner variables
		
		/*Deals two cards to each player. The addCard method receives the user or dealer input value
		 * to decide to how it will deal the card*/
		for (int i=0;i<2;i++){
			addCard("user");
			addCard("dealer");
		}
		/*Checks if there are any winners so far and executes print methods
		 *Special case for this if: has to jump getWinner(0)and terminate program to not
		 * ask for hit/stand, stupid otherwise if user has got 21 already*/
		if (userCount==21&&dealerCount<21){
			getWinner(1);					 
			printCards(1);
		}
		else{
			getWinner(0);
		}
		/*If no winners have been found so far it will be the users turn to
		 * hit or stand for cards, at any position in time isUserPlaying 
		 * can be modified, depending on the user desicions
		 * so the dealer jumps into the game and finishes it*/
		while(isUserPlaying){
			printCards(0);
			TextIO.put("\nh for Hit, s for Stand:");
			char hitstand = TextIO.getlnChar();
			if (hitstand=='h'){
				addCard("user");
				if(userCount!=21){
					getWinner(0);
					printCards(1);
					}
				}
			if (hitstand=='s'||userCount==21){
				/*This dealer rule was modified because it didnt make to much sense
				 * for the dealer to wait at 16 if the user is got around 20, in real
				 * world the dealer at least will try one more card, its got anything to loose
				 * anyhows */
				while(dealerCount<=17){
					addCard("dealer");
				}
				getWinner(1);	
			}
		
		} // end of While isUserPlaying
		
		if (userWins<userScore){TextIO.putln("YOU WIN!!!");}
		if (dealerWins<dealerScore){TextIO.putln("YOU LOOSE!!!");}
		if (dealerWins==dealerScore&&userWins==userScore){TextIO.putln("MATCH!!!");}
		TextIO.putln("Do you want to play again? ");
		itsOn=TextIO.getBoolean();
		
	}	// end of game loop														
	
}
	/*This process was repeated many times during the main method coding so
	 * i decided to separate it to a different method
	 * For some reason I had to specify that the userHand or dealerHand should be
	 * considered on there BlackjackHand form instead of just
	 * userCount= userHand.getBlackjackValue();
	 * Weird because when i created the Hands I did it:
	 * Hand userHand = new BlackjackHand(); */ 
	static void addCard(String player){
		if (player.equals("user")){
			Card card=new Card();
			card=deck.dealCard();
			userHand.addCard(card);
			userCount= ((BlackjackHand) userHand).getBlackjackValue();
		}
		if (player.equals("dealer")){
			Card card=new Card();
			card=deck.dealCard();
			dealerHand.addCard(card);
			dealerCount= ((BlackjackHand) dealerHand).getBlackjackValue();
		}
	}
	static void getWinner(int a){
		
		/*There are two methods to obtain the winners one when only two cards
		 * for each player are dealt and the second to check for user a dealer decisions
		 * Every possible outcome was considered (almost) For the first method only reaching 
		 * 21 was considered while for the second method also going over 21
		 * Each scenario of conclusion will deactivate the user turn and proceed with
		 * the dealers <17 method*/
		if (a==0){ //after two initial deals and if any 21 has been obtained
			if (userCount==21&&dealerCount==21){
				isUserPlaying= false;
				}
			if (dealerCount==21){
				dealerScore++;
				isUserPlaying= false;
				}
			if (userCount>21){
				dealerScore++;
				isUserPlaying=false;
				}	
			}
		if (a==1){ // also in use when user stands or reaches 21 
			//after two initial card deals "special case"
			if (userCount>dealerCount){
				userScore++;
				isUserPlaying=false;
				}
			if (userCount<dealerCount&&dealerCount<=21){
				dealerScore++;
				isUserPlaying=false;
				}
			if (dealerCount>21){
				userScore++;
				isUserPlaying=false;
				}
			if (userCount==dealerCount){
				isUserPlaying= false;
				}
			printCards(1);
			}				
	}
	/* THERE ARE TWO PRINTING METHODS, same as obtaining the winners
	 * one for the two first initial deals.  */
	public static void printCards(int x){
		int userCardsNum = userHand.getCardCount();
		int dealerCardsNum = dealerHand.getCardCount();
		if (x==0){
			TextIO.put("\n\n\n\n\n\n\n\n\n\n");
			if (deck.cardsLeft()<5){deck.shuffle();TextIO.putln("Deck was shuffled");} 	//shuffle if no
			TextIO.putln("Cards left on this deck: " + deck.cardsLeft());						//more cards
			TextIO.putln("$$$$$$$$$$$$****************************************$$$$$$$$$$$$");
			TextIO.putln("***************** CASINO 'THE UMBETEABLE' V 1.0 ****************");
			TextIO.putln("----------------------------------------------------------------");
			TextIO.putln("USER						DEALER");
			TextIO.putln("----------------------------------------------------------------");
			TextIO.putln(userHand.getCard(0)+"					"+ dealerHand.getCard(0));
			for (int i=1;i<userCardsNum;i++){
				TextIO.putln(userHand.getCard(i));
			}
			TextIO.putln("Count: "+userCount);
			TextIO.putln("----------------------------------------------------------------");
			TextIO.putln("Score: "+userScore+"					"+"Score: "+ dealerScore);
		}
		/*This is the second printing method and it calculates the tabulations to
		 * the right or the left given the number of cards that have been dealt to the users
		 * . if userCardsNum != dealerCardsNum
			- print both scores for (minimum CardsNum) times
			- then print scores for the player with (maximum CardsNum) for CardsNum[difference] times
					tabs to the left if userCardsNum minimum
					tabs to the right if dealerCardsNum minimum*/
		if (x==1){
			int min = Math.min(userCardsNum, dealerCardsNum);
			int differece = Math.abs(userCardsNum-dealerCardsNum);
			TextIO.put("\n\n\n\n\n\n\n\n\n\n");
			if (deck.cardsLeft()<5){deck.shuffle();TextIO.putln("Deck was shuffled");} 	//shuffle if no
			TextIO.putln("Cards left on this deck: " + deck.cardsLeft());						//more cards
			TextIO.putln("$$$$$$$$$$$$****************************************$$$$$$$$$$$$");
			TextIO.putln("***************** CASINO 'THE UMBETEABLE' **********************");
			TextIO.putln("----------------------------------------------------------------");
			TextIO.putln("USER						DEALER");
			TextIO.putln("----------------------------------------------------------------");
			for (int i=0;i<min;i++){
				TextIO.putln(userHand.getCard(i)+"					"+ dealerHand.getCard(i));
			}
			if (userCardsNum<dealerCardsNum){
				for (int i=0;i<differece;i++){
					TextIO.putln("						"+ dealerHand.getCard(i));
				}
			}
			if (userCardsNum>dealerCardsNum){
				for (int i=0;i<differece;i++){
					TextIO.putln(userHand.getCard(i));
				}
			}
			TextIO.putln("Count: "+userCount+"					"+"Count: "+ dealerCount);
			TextIO.putln("----------------------$$$$$$$$$$--------------------------------");
			TextIO.putln("Score: "+userScore+"					"+"Score: "+ dealerScore);
			TextIO.putln("----------------------$$$$$$$$$$--------------------------------");
		}
		
	}
}