package k_console;

public class BlackjackConsole extends ConsoleApplet {
	static Hand dealerHand = new BlackjackHand();
	static Hand userHand = new BlackjackHand();
	static Deck deck = new Deck();
	static int userCount;
	static int dealerCount;
	static int userScore;
	static int dealerScore;
	static boolean isUserPlaying=true;
   protected String getTitle() {
      return "Sample program \"BlackJack 1.0\"";
   }

   protected void program() {

	
	
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
			console.put("\nh for Hit, s for Stand:");
			char hitstand = console.getlnChar();
			if (hitstand=='h'){
				addCard("user");
				if(userCount!=21){
					getWinner(0);
					
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
		
		if (userWins<userScore){console.putln("\nYOU WIN!!!");}
		if (dealerWins<dealerScore){console.putln("\nYOU LOOSE!!!");}
		if (dealerWins==dealerScore&&userWins==userScore){console.putln("\nMATCH!!!");}
		console.putln("\nDo you want to play again? ");
		itsOn=console.getBoolean();
		
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
	 void getWinner(int a){
		
		/*There are two methods to obtain the winners one when only two cards
		 * for each player are dealt and the second to check for user a dealer decisions
		 * Every possible outcome was considered (almost) For the first method only reaching 
		 * 21 was considered while for the second method also going over 21
		 * Each scenario of conclusion will deactivate the user turn and proceed with
		 * the dealers <17 method*/
		if (a==0){ //after two initial deals and if any 21 has been obtained
			if (userCount==21&&dealerCount==21){
				isUserPlaying= false;
				printCards(1);
				}
			if (dealerCount==21){
				dealerScore++;
				isUserPlaying= false;
				printCards(1);
				}
			if (userCount>21){
				dealerScore++;
				isUserPlaying=false;
				printCards(1);
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
	public  void printCards(int x){
		int userCardsNum = userHand.getCardCount();
		int dealerCardsNum = dealerHand.getCardCount();
		if (x==0){
			
			if (deck.cardsLeft()<5){deck.shuffle();console.putln("Deck was shuffled");} 	//shuffle if no
			console.putln("Cards left on this deck: " + deck.cardsLeft());						//more cards
			console.putln("$$$$$$$$$$$$*****************************");
			console.putln("**************************** CASINO V 1.0");
			console.putln("-----------------------------------------");
			console.putln("USER DATA");
			console.putln(userHand.getCard(0)+ "");
			for (int i=1;i<userCardsNum;i++){
				console.putln(userHand.getCard(i)+"");
			}
			console.putln("Count: "+userCount);
			console.putln("Score: "+userScore);
			console.putln("------------------------------------------");
			console.putln("DEALER DATA");			
			console.putln(dealerHand.getCard(0)+"");
			console.putln("Score: "+ dealerScore);
		}
		/*This is the second printing method and it calculates the tabulations to
		 * the right or the left given the number of cards that have been dealt to the users
		 * . if userCardsNum != dealerCardsNum
			- print both scores for (minimum CardsNum) times
			- then print scores for the player with (maximum CardsNum) for CardsNum[difference] times
					tabs to the left if userCardsNum minimum
					tabs to the right if dealerCardsNum minimum*/
		if (x==1){
			
			if (deck.cardsLeft()<5){deck.shuffle();console.putln("Deck was shuffled");} 	//shuffle if no
			console.putln("Cards left on this deck: " + deck.cardsLeft());						//more cards
			console.putln("$$$$$$$$$$$$*****************************");
			console.putln("*****************************CASINO V 1.0");
			console.putln("-----------------------------------------");
			console.putln("USER DATA");
			console.putln(userHand.getCard(0)+ "");
			for (int i=1;i<userCardsNum;i++){
				console.putln(userHand.getCard(i)+"");
			}
			console.putln("Count: "+userCount);
			console.putln("Score: "+userScore);
			console.putln("------------------------------------------");
			console.putln("DEALER DATA");			
			console.putln(dealerHand.getCard(0)+"");
			for (int i=1;i<dealerCardsNum;i++){
				console.putln(dealerHand.getCard(i)+"");
			}
			console.putln("Count: "+dealerCount);
			console.putln("Score: "+ dealerScore);
		}
		
	}
}