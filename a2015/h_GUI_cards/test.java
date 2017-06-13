package h_GUI_cards;

/*
   This applet is a simple card game.  The user sees a card and
   tries to predict whether the next card will be higher or 
   lower.  Aces are the lowest-valued cards.  If the user makes
   three correct predictions, the user wins.  If not, the
   user loses.
   
   The programming of this applet assumes that the applet is
   set up to be about 376 pixels wide and about 200 pixels high.
   That width is just big enough to show 4 cards, with spacing and
   borders.  The height is probably a little bigger than necessary,
   to allow for variations in the size of buttons from one platform
   to another.
   
   This file defines two class files, the applet class HighLowGUI.class
   and a nested class HighLowGUI$HighLowCanvas.class.  Both files
   are necessary to use the applet.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class test extends JApplet {

   public void init() {
         
      setBackground( new Color(130,50,40) );
      
      Canvas canvas = new Canvas();
      getContentPane().add(canvas, BorderLayout.CENTER);
      
      JPanel buttonPanel = new JPanel();
      buttonPanel.setBackground( new Color(220,200,180) );
      getContentPane().add(buttonPanel, BorderLayout.SOUTH);
      
      JButton higher = new JButton( "Higher" );
      higher.addActionListener(canvas);
      buttonPanel.add(higher);
      
      JButton lower = new JButton( "Lower" );
      lower.addActionListener(canvas);
      buttonPanel.add(lower);
      
      JButton newGame = new JButton( "New Game" );
      newGame.addActionListener(canvas);
      buttonPanel.add(newGame);
      
      canvas.setBackground( new Color(0,120,0) );
      setForeground( Color.green );
      canvas.smallFont = new Font("SansSerif", Font.PLAIN, 12);
      canvas.bigFont = new Font("Serif", Font.BOLD, 14);
      canvas.doNewGame();
      
   }  // end init()
   
   public Insets getInsets() {
         // Specify how much space to leave between the edges of
         // the applet and the components it contains.  The background
         // color shows through in this border.
      return new Insets(3,3,3,3);
   }


   class Canvas extends JPanel implements ActionListener {
      Deck deck;       // A deck of cards to be used in the game.
      Hand hand;       // The cards that have been dealt.
      String message;  // A message drawn on the canvas, which changes
      boolean gameInProgress;  // Set to true when a game begins and to false
      Font bigFont;      // Font that will be used to display the message.
      Font smallFont;    // Font that will be used to draw the cards.

      public void paintComponent(Graphics g) {
  
         super.paintComponent(g);
         g.setFont(bigFont);
         g.drawString(message,10,135);
         g.setFont(smallFont);
         int cardCt = hand.getCardCount();
         for (int i = 0; i < cardCt; i++)
            drawCard(g, hand.getCard(i), 10 + i * 90, 10);
         if (gameInProgress)
            drawCard(g, null, 10 + cardCt * 90, 10);
      } // end paintComponent()
     

      void doHigher() {
               // Called by actionPerformmed() when user clicks "Higher" button.
               // Check the user's prediction.  Game ends if user guessed
               // wrong or if the user has made three correct predictions.
         if (gameInProgress == false) {
               // If the game has ended, it was an error to click "Higher",
               // So set up an error message and abort processing.
            message = "Click \"New Game\" to start a new game!";
            repaint();
            return;
         }
         hand.addCard( deck.dealCard() );     // Deal a card to the hand.
         int cardCt = hand.getCardCount();
         Card thisCard = hand.getCard( cardCt - 1 );  // Card just dealt.
         Card prevCard = hand.getCard( cardCt - 2 );  // The previous card.
         if ( thisCard.getValue() < prevCard.getValue() ) {
            gameInProgress = false;
            message = "Too bad! You lose.";
         }
         else if ( thisCard.getValue() == prevCard.getValue() ) {
            gameInProgress = false;
            message = "Too bad!  You lose on ties.";
         }
         else if ( cardCt == 4) {
            gameInProgress = false;
            message = "You win!  You made three correct guesses.";
         }
         else {
            message = "Got it right!  Try for " + cardCt + ".";
         }
         repaint();
      } // end doHigher()


      void doLower() {
               // Called by actionPerformmed() when user clicks "Lower" button.
               // Check the user's prediction.  Game ends if user guessed
               // wrong or if the user has made three correct predictions.
         if (gameInProgress == false) {
               // If the game has ended, it was an error to click "Lower",
               // So set up an error message and abort processing.
            message = "Click \"New Game\" to start a new game!";
            repaint();
            return;
         }
         hand.addCard( deck.dealCard() );     // Deal a card to the hand.
         int cardCt = hand.getCardCount();
         Card thisCard = hand.getCard( cardCt - 1 );  // Card just dealt.
         Card prevCard = hand.getCard( cardCt - 2 );  // The previous card.
         if ( thisCard.getValue() > prevCard.getValue() ) {
            gameInProgress = false;
            message = "Too bad! You lose.";
         }
         else if ( thisCard.getValue() == prevCard.getValue() ) {
            gameInProgress = false;
            message = "Too bad!  You lose on ties.";
         }
         else if ( cardCt == 4) {
            gameInProgress = false;
            message = "You win!  You made three correct guesses.";
         }
         else {
            message = "Got it right!  Try for " + cardCt + ".";
         }
         repaint();
      } // end doLower()


      void doNewGame() {
             // Called by the constructor, and called by actionPerformed() if
             // the use clicks the "New Game" button.  Start a new game.
         if (gameInProgress) {
                 // If the current game is not over, it is an error to try
                 // to start a new game.
            message = "You still have to finish this game!";
            repaint();
            return;
         }
         deck = new Deck();   // Create the deck and hand to use for this game.
         hand = new Hand();
         deck.shuffle();
         hand.addCard( deck.dealCard() );  // Deal the first card into the hand.
         message = "Is the next card higher or lower?";
         gameInProgress = true;
         repaint();
      } // end doNewGame()



      public void actionPerformed(ActionEvent evt) {
          String command = evt.getActionCommand();
          if (command.equals("Higher"))
             doHigher();
          else if (command.equals("Lower"))
             doLower();
          else if (command.equals("New Game"))
             doNewGame();
       } // end actionPerformed()

      void drawCard(Graphics g, Card card, int x, int y) {
              // Draws a card as a 80 by 100 rectangle with
              // upper left corner at (x,y).  The card is drawn
              // in the graphics context g.  If card is null, then
              // a face-down card is drawn.  (The cards are 
              // rather primitive.)
         if (card == null) {  
                // Draw a face-down card
            g.setColor(Color.blue);
            g.fillRect(x,y,80,100);
            g.setColor(Color.white);
            g.drawRect(x+3,y+3,73,93);
            g.drawRect(x+4,y+4,71,91);
         }
         else {
            g.setColor(Color.white);
            g.fillRect(x,y,80,100);
            g.setColor(Color.gray);
            g.drawRect(x,y,79,99);
            g.drawRect(x+1,y+1,77,97);
            if (card.getSuit() == Card.DIAMONDS || card.getSuit() == Card.HEARTS)
               g.setColor(Color.red);
            else
               g.setColor(Color.black);
            g.drawString(card.getValueAsString(), x + 10, y + 30);
            g.drawString("of", x+ 10, y + 50);
            g.drawString(card.getSuitAsString(), x + 10, y + 70);
         }
      } // end drawCard()
   } 
}