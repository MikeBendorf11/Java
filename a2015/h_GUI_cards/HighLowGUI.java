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

public class HighLowGUI extends JApplet {

   public void init() {
   
         // The init() method lays out the applet.
         // A HighLowCanvas occupies the CENTER position of the layout.
         // On the bottom is a panel that holds three buttons.  The
         // HighLowCanvas object listens for ActionEvents from the
         // buttons and does all the real work of the program.
         
      setBackground( new Color(130,50,40) );
      
      HighLowCanvas board = new HighLowCanvas();
      getContentPane().add(board, BorderLayout.CENTER);
      
      JPanel buttonPanel = new JPanel();
      buttonPanel.setBackground( new Color(220,200,180) );
      getContentPane().add(buttonPanel, BorderLayout.SOUTH);
      
      JButton higher = new JButton( "Higher" );
      higher.addActionListener(board);
      buttonPanel.add(higher);
      
      JButton lower = new JButton( "Lower" );
      lower.addActionListener(board);
      buttonPanel.add(lower);
      
      JButton newGame = new JButton( "New Game" );
      newGame.addActionListener(board);
      buttonPanel.add(newGame);
      
   }  // end init()
   
   public Insets getInsets() {
         // Specify how much space to leave between the edges of
         // the applet and the components it contains.  The background
         // color shows through in this border.
      return new Insets(3,3,3,3);
   }


   class HighLowCanvas extends JPanel implements ActionListener {

         // A nested class that displays the cards and does all the work
         // of keeping track of the state and responding to user events.

      Deck deck;       // A deck of cards to be used in the game.
      Hand hand;       // The cards that have been dealt.
      String message;  // A message drawn on the canvas, which changes
                       //    to reflect the state of the game.

      boolean gameInProgress;  // Set to true when a game begins and to false
                               //   when the game ends.

      Font bigFont;      // Font that will be used to display the message.
      Font smallFont;    // Font that will be used to draw the cards.


      HighLowCanvas() {
            // Constructor.  Creates fonts, sets the foreground and
            // background colors, and starts the first game.
         setBackground( new Color(0,120,0) );
         setForeground( Color.green );
         smallFont = new Font("SansSerif", Font.PLAIN, 12);
         bigFont = new Font("Serif", Font.BOLD, 14);
         doNewGame();
      } // end constructor


      public void actionPerformed(ActionEvent evt) {
             // Respond when the user clicks on a button by calling
             // the appropriate procedure.  Note that the canvas is
             // registered as a listener in applet's init() method.
         String command = evt.getActionCommand();
         if (command.equals("Higher"))
            doHigher();
         else if (command.equals("Lower"))
            doLower();
         else if (command.equals("New Game"))
            doNewGame();
      } // end actionPerformed()


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


      public void paintComponent(Graphics g) {
            // This method draws the message at the bottom of the
            // canvas, and it draws all of the dealt cards spread out
            // across the canvas.  If the game is in progress, an
            // extra card is dealt representing the card to be dealt next.
         super.paintComponent(g);
         g.setFont(bigFont);
         g.drawString(message,10,135);
         g.setFont(smallFont);
         int cardCt = hand.getCardCount();	// how many cards on the hand (lets say 4)
         for (int i = 0; i < cardCt; i++)	// draws all cards on the hand (every frame all cards)
            drawCard(g, hand.getCard(i), 10 + i * 90, 10);
         if (gameInProgress)
            drawCard(g, null, 10 + cardCt * 90, 10);
      } // end paintComponent()


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
   } // end nested class HighLowCanvas
} // end class HighLowGUI