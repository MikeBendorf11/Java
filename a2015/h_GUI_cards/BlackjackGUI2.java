package h_GUI_cards;

import java.awt.*;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.*;

public class BlackjackGUI2 extends JApplet {

	int bet;
	String pointsMsg, cardsLeftMsg;                                                
	JButton hit,stand,applyBet;
	JTextField UserBet;
	JLabel Message, PointsMsg, CardsLeftMsg, MoneyLeft;
	
	public void init(){
		// image goes on the .class file path
		
		ImageIcon icon = new ImageIcon("title_blackjack.jpg");
		dealerTable chechoTable = new dealerTable();
		JPanel container = new JPanel(new GridLayout(1,2,6,6));
		container.setBackground(Color.black);
	
		 // everything for the game data
		JPanel gameData = new JPanel(new GridLayout(8,1,10,10));
		gameData.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		JLabel betText = new JLabel("Enter your bet: ");
		UserBet = new JTextField("100", 15);
		UserBet.selectAll();
		bet = Integer.parseInt(UserBet.getText());
		Message = new JLabel("Classic Version 2.0" );
		PointsMsg = new JLabel(pointsMsg);
		CardsLeftMsg = new JLabel(cardsLeftMsg);
		JLabel empty = new JLabel();
		MoneyLeft = new JLabel("You start with 10,000$");
		JLabel titlePic = new JLabel();
		titlePic.setIcon(icon);
		JPanel betInfo = new JPanel(new GridLayout(1,2,10,10)); 
		betInfo.add(betText);
		betInfo.add(UserBet);
		UserBet.selectAll();		
		gameData.add(titlePic);
		gameData.add(empty);
		gameData.add(Message);
		gameData.add(CardsLeftMsg);
		gameData.add(new JSeparator(JSeparator.HORIZONTAL));
		gameData.add(PointsMsg);
		gameData.add(betInfo);
		gameData.add(MoneyLeft);
			
		container.add(chechoTable);
		container.add(gameData);
		setBackground( new Color(130,50,40));
	    
	    getContentPane().add(container, BorderLayout.CENTER);
	      
	    JPanel buttonPanel = new JPanel();
	    buttonPanel.setBackground( new Color(220,200,180) );
	    getContentPane().add(buttonPanel, BorderLayout.SOUTH);
	      
	    hit = new JButton( "Hit" );
	    hit.addActionListener(chechoTable);
	    buttonPanel.add(hit);
	    
	    stand = new JButton( "Stand" );
	    stand.addActionListener(chechoTable);
	    buttonPanel.add(stand);

	    applyBet = new JButton( "BET!!!" );
	    applyBet.addActionListener(chechoTable);
	    buttonPanel.add(applyBet);      
	   } 	
	
	class dealerTable extends JPanel implements ActionListener {
	    int userCount, dealerCount, gameCount, money; 
		Deck deck;     
	     Hand userHand, dealerHand;    
		 boolean gameInProgress, hideDealerCard, 
		 		dealerWins, userWins, userStands;  	 
		 String message, moneyLeft, cardsLeftMSg;
		 
		dealerTable(){				
			setBackground( new Color(0,120,0) );
	        setForeground( Color.green ); 
	        
	        hideDealerCard=true;
	        deck = new Deck();
	        money=10000;	        
	        bet();      
		}
		public void paintComponent(Graphics g){
			 Font bigFont = new Font("Serif", Font.BOLD, 14);
		     super.paintComponent(g);
		     if(dealerWins){
					UserBet.setEnabled(true);
	        	 money=money-bet;
	         }
	         else if(userWins){
	        	 UserBet.setEnabled(true);
	        	 money=money+bet+bet/2;
	         }
		     bet = Integer.parseInt(UserBet.getText());// has to come after the paint component to validate TextField
		     g.setFont(bigFont);	     
	         g.drawString("Dealer Cards",20,40); 
	         g.drawString("User Cards",20,190);	      
	         enableButtons();
	         if (gameCount>0){
	        	 moneyLeft = "You have: " 
	        		 	+ NumberFormat.getNumberInstance(Locale.US).format( money)+"$";
		         cardsLeftMsg = "Cards Left: "+ " " 
		         				+ String.valueOf(deck.cardsLeft()); 
		           // disable this to go back to messaging system
		 
		         if (deck.cardsLeft()<5){ // shuffle when cards run out 
						deck.shuffle();
					}
		         if (hideDealerCard){
		        	 drawCard(g,dealerHand.getCard(0),20,60 );
			         drawCard(g,null,75,60 );
			         for (int i = 0; i < userHand.getCardCount(); i++)	
			 	            drawCard(g, userHand.getCard(i), 20 + i * 55, 210);         
		         }
		         else{
		        	 for (int i = 0; i < dealerHand.getCardCount(); i++)	
		 	            drawCard(g, dealerHand.getCard(i), 20 + i * 55, 60);
		        	 for (int i = 0; i < userHand.getCardCount(); i++)	
			 	            drawCard(g, userHand.getCard(i), 20 + i * 55, 210);		         
		         }	   
				Message.setText(message);
				PointsMsg.setText(pointsMsg);
				CardsLeftMsg.setText(cardsLeftMsg);
				MoneyLeft.setText(moneyLeft);
				UserBet.selectAll();	 
	         }
	         else {
	        	 for (int i = 0; i<5;i++){
	        		 drawCard(g,null,20+i*55,60 );
	        		 drawCard(g,null,20+i*55,210 );
	        	 }   
	         }        
		}
		void bet(){	
			if (bet>0&&bet<=money){
				UserBet.setEnabled(false);
				newGame();
				gameCount++;
			}			
		}
		void hit(){
		
			if (userCount<21){
				userHand.addCard(deck.dealCard());
				pointsCounter();
				repaint();	// add cards user
			}
		}						
		void stand(){
			userStands=true;
			hideDealerCard=false;		
			while (dealerCount<18){
				dealerHand.addCard(deck.dealCard());
				pointsCounter(); 
			}
			pointsCounter(); 
			repaint();		
		}
		void newGame(){							
			userStands=false;hideDealerCard=true;
			if (gameCount==0){ // shuffles game first time is loaded
				deck.shuffle();
			}
			userHand = new BlackjackHand(); //two cards each
			userHand.addCard(deck.dealCard());
			userHand.addCard(deck.dealCard());
			dealerHand = new BlackjackHand();
			dealerHand.addCard(deck.dealCard());
			dealerHand.addCard(deck.dealCard());			
			if (gameCount==0){ // msg for first time program opens
				message = " Game started ** Deck has been shuffled **";
			} else	message = "** Game started **" ;			
			pointsCounter();																							
		}
		void pointsCounter(){
			dealerWins = false; // needed for when the game finishes
			userWins = false;
			userCount= ((BlackjackHand) userHand).getBlackjackValue();
			dealerCount= ((BlackjackHand) dealerHand).getBlackjackValue();			
			dealerWinTest(); userWinTest();
			if (!dealerWins && !userWins){ // if nobody wins
				gameInProgress=true;		// games continues
			} 
			else{
				gameInProgress=false; hideDealerCard=false; 
				gameCount++;	
			}
			if (hideDealerCard){			// printing scores variable change
				pointsMsg = "User Count: " + userCount 
				+" "+" "+" "+" "+ " Dealer Count: " + "???";
			} else
			pointsMsg = "User Count: " + userCount 
				+" "+" "+" "+" "+ " Dealer Count: " + dealerCount;
			repaint();					
		}
		boolean dealerWinTest(){
			if (dealerCount==21 && userCount<21){ // when dealer reaches 21
				message = "Dealer Wins at 21";			
				return dealerWins = true;
			}
			if (dealerCount==21 && userCount==21){ // ties
				message = "You loose on Ties";	
				return dealerWins = true;
			}
			if (userCount>21){					//  user goes busted
				message = "You went over 21";
				return dealerWins = true;
			}
			if (dealerCount>userCount && dealerCount<21 && userStands){ 	// user stands dealer ends < 21
				message= "Dealer Wins by Sum";
				return dealerWins = true;
			}
			if (dealerCount==userCount && userStands){ // when user stands only
				message= "Dealer Wins on Ties";		
				return dealerWins = true;
			}
			else{
				return dealerWins = false; 
			}			
		}
		boolean userWinTest(){
			if (userCount==21 && dealerCount<21){ // When user reaches 21
				message = "User Wins at 21";
				return userWins = true;
			}
			if (dealerCount>21){ 				// dealer goes busted
				message = "Dealer went over 21";
				return userWins = true;
			}
			if (userCount>dealerCount && userCount<21 && userStands){	// only when user stands
				message = "User wins by Sum";
				return userWins = true;
			}
			else return userWins=false;			
		}
		void enableButtons(){ // disable this to go back to messaging system
			if (gameInProgress){
				applyBet.setEnabled(false);
				hit.setEnabled(true);
				stand.setEnabled(true);
			}
			else if (!gameInProgress){ // default
				applyBet.setEnabled(true);
				hit.setEnabled(false);
				stand.setEnabled(false);
			}
		}
		void drawCard(Graphics g, Card card, int x, int y) {
		Image cardImages = getImage( getCodeBase(), "http://www.quitofurnishedapartments.com/java/applets/smallcards.gif" );
	      if (card == null) {  
	             // Draw a face-down card
	         g.setColor(Color.blue);
	         g.fillRect(x,y,40,60);
	         g.setColor(Color.white);
	         g.drawRect(x+3,y+3,33,53);
	         g.drawRect(x+4,y+4,31,51);
	      }
	      else {
	         int row = 0;  // Which of the four rows contains this card?
	         switch (card.getSuit()) {
	            case Card.CLUBS:    row = 0;  break;
	            case Card.HEARTS:   row = 1;  break;
	            case Card.SPADES:   row = 2;  break;
	            case Card.DIAMONDS: row = 3;  break;
	         }
	         int sx, sy;  // Coords of upper left corner in the source image.
	         sx = 40*(card.getValue() - 1);
	         sy = 60*row;
	         g.drawImage(cardImages, x,  y,  x+40,  y+60,
	                                 sx, sy, sx+40, sy+60, this);
	      }
	   }  // end drawCard()
		 public void actionPerformed(ActionEvent evt) {
			   String command = evt.getActionCommand();
		         if (command.equals("Hit"))
		            hit();
		         else if (command.equals("Stand"))
		            stand();
		         else if (command.equals("BET!!!")&&Integer.parseInt(UserBet.getText())<=money
		        		 &&Integer.parseInt(UserBet.getText())>0&&money>0)//fuck fuck fuck
		        
		           bet();
		      } 
		 public Insets getInsets() {
	          return new Insets(3,3,3,3);
	   }	
	}

}