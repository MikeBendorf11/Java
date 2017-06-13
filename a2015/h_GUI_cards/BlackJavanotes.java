package h_GUI_cards;
    /*
       In this applet, the user plays a game of Blackjack.  The
       computer acts as the dealer.  The user plays by clicking
       "Hit!" and "Stand!" buttons.
       
       The user can make bets on the game.  Initially, the user
       has $100.  If the user runs out of money, the user will
       get another $100.  Note that the bet amount cannot be
       edited when the game is in progress.

       The programming of this applet assumes that the applet is
       set up to be about 466 pixels wide and about 376 pixels high.
       That width is just big enough to show 2 rows of 5 cards.
       The height is probably a little bigger than necessary,
       to allow for variations in the size of buttons from one platform
       to another.
       
    */
    
    import java.awt.*;
    import java.awt.event.*;
    import javax.swing.*;
    
    public class BlackJavanotes extends JApplet {
    
       /* Declare the buttons that the user clicks to control the
          game.  These buttons are set up in the init() method and
          are used in the nested class BlackjackCanvas. */
        // A nested class that displays the card game and does all the work
        // of keeping track of the state and responding to user events.

     Deck deck;         // A deck of cards to be used in the game.

     BlackjackHand dealerHand;   // Hand containing the dealer's cards.
     BlackjackHand playerHand;   // Hand containing the user's cards.

     String message;  // A message drawn on the canvas, which changes
                      //    to reflect the state of the game.

     boolean gameInProgress;  // Set to true when a game begins and to false
                              //   when the game ends.

     Font bigFont;      // Font that will be used to display the message.
     Font smallFont;    // Font that will be used to draw the cards.

     int usersMoney;    // The amount of money the user has.
  
     int betAmount;     // The amount user has bet on the current game.
                      
       JButton hit, stand, newGame;
       
       JTextField betInput;  // A JTextField to hold the user's bet.

       public void init() {
       
             // The init() method creates components and lays out the applet.
             // A BlackjackCanvas occupies the CENTER position of the layout.
             // On the bottom is a panel that holds three buttons.  The
             // BlackjackCanvas object listens for events from the buttons
             // and does all the real work of the program.
             
          setBackground( new Color(130,50,40) );
          
          hit = new JButton( "Hit!" );
          stand = new JButton( "Stand!" );
          newGame = new JButton( "New Game" );
             
          betInput = new JTextField("10",5);

          BlackjackCanvas board = new BlackjackCanvas();
          getContentPane().add(board, BorderLayout.CENTER);
          
          JPanel buttonPanel = new JPanel();
          buttonPanel.setBackground( new Color(220,200,180) );
          getContentPane().add(buttonPanel, BorderLayout.SOUTH);
          
          hit.addActionListener(board);
          buttonPanel.add(hit);
          
          stand.addActionListener(board);
          buttonPanel.add(stand);
          
          newGame.addActionListener(board);
          buttonPanel.add(newGame);
          
          /* Add the bet input box to the panel along with a label. */
    
          buttonPanel.add( new JLabel( " Your bet:" ) );
          
          betInput.setBackground(Color.white);
          buttonPanel.add(betInput);

       }  // end init()
       

       public Insets getInsets() {
             // Specify how much space to leave between the edges of
             // the applet and the components it contains.  The background
             // color shows through in this border.
          return new Insets(3,3,3,3);
       }
       

       // --- The remainder of this class consists of a nested class ---

    
       class BlackjackCanvas extends JPanel implements ActionListener {

      // This amount is recorded at the start of game.


          BlackjackCanvas() {
                // Constructor.  Creates fonts and starts the first game.
             setBackground( new Color(0,120,0) );
             smallFont = new Font("SansSerif", Font.PLAIN, 12);
             bigFont = new Font("Serif", Font.BOLD, 14);
             usersMoney = 100;
             message = "Welcome to Blackjack!  You start with $100.";
             setGameInProgress(false);
          }


          public void actionPerformed(ActionEvent evt) {
                 // Respond when the user clicks on a button by calling
                 // the appropriate procedure.  Note that the canvas is
                 // registered as a listener in the BlackjackGUI class.
             String command = evt.getActionCommand();
             if (command.equals("Hit!"))
                doHit();
             else if (command.equals("Stand!"))
                doStand();
             else if (command.equals("New Game"))
                doNewGame();
          }


          public void setGameInProgress(boolean inProgress) {
                // This method should be called whenever the value of
                // the gameInProgress variable is changed.  It changes
                // the value of the variable and also enables/disables
                // the buttons to reflect the state of the game.
             gameInProgress = inProgress;
             if (gameInProgress) {
                hit.setEnabled(true);
                stand.setEnabled(true);
                newGame.setEnabled(false);
                betInput.setEditable(false);
             }
             else {
                hit.setEnabled(false);
                stand.setEnabled(false);
                newGame.setEnabled(true);
                betInput.setEditable(true);
             }
          }

          private void userWon(String str) {
               // Call this for convenience when the user wins.
               // Str is the message to display to the user.
             message = str;
             usersMoney += betAmount;
             setGameInProgress(false);
          }
          
          private void userLost(String str) {
               // Call this for convenience when the user loses.
               // Str is the message to display to the user.
             message = str;
             usersMoney -= betAmount;
             setGameInProgress(false);
          }

          void doHit() {
                 // This method is called when the user clicks the "Hit!" button.
                 // First check that a game is actually in progress.  If not, give
                 // an error message and exit.  Otherwise, give the user a card.
                 // The game can end at this point if the user goes over 21 or
                 // if the user has taken 5 cards without going over 21.
             if (gameInProgress == false) {
                    // This should be impossible, since the Hit button is disabled
                    // when the game is not is progress, but it doesn't hurt to check.
                message = "Click \"New Game\" to start a new game.";
                repaint();
                return;
             }
             playerHand.addCard( deck.dealCard() );
             if ( playerHand.getBlackjackValue() > 21 ) {
                userLost("You've busted!  Sorry, you lose.");
             }
             else if (playerHand.getCardCount() == 5) {
                userWon("You win by taking 5 cards without going over 21.");
             }
             else {
                message = "You have " + playerHand.getBlackjackValue() + ".  Hit or Stand?";
             }
             repaint();
          }


          void doStand() {
                  // This method is called when the user clicks the "Stand!" button.
                  // Check whether a game is actually in progress.  If it is,
                  // the game ends.  The dealer takes cards until either the
                  // dealer has 5 cards or more than 16 points.  Then the 
                  // winner of the game is determined.
             if (gameInProgress == false) {
                message = "Click \"New Game\" to start a new game.";
                repaint();
                return;
             }
             while (dealerHand.getBlackjackValue() <= 16 && dealerHand.getCardCount() < 5)
                dealerHand.addCard( deck.dealCard() );
             if (dealerHand.getBlackjackValue() > 21)
                 userWon("You win!  Dealer has busted with " + dealerHand.getBlackjackValue() + ".");
             else if (dealerHand.getCardCount() == 5)
                 userLost("Sorry, you lose.  Dealer took 5 cards without going over 21.");
             else if (dealerHand.getBlackjackValue() > playerHand.getBlackjackValue())
                 userLost("Sorry, you lose, " + dealerHand.getBlackjackValue()
                                                   + " to " + playerHand.getBlackjackValue() + ".");
             else if (dealerHand.getBlackjackValue() == playerHand.getBlackjackValue())
                 userLost( "Sorry, you lose.  Dealer wins on a tie.");
             else
                 userWon("You win, " + playerHand.getBlackjackValue()
                                                   + " to " + dealerHand.getBlackjackValue() + "!");
             repaint();
          }


          void doNewGame() {
                 // Called by the constructor, and called by actionPerformed() if
                 // the use clicks the "New Game" button.  Start a new game.
                 // Deal two cards to each player.  The game might end right then
                 // if one of the players had blackjack.  Otherwise, gameInProgress
                 // is set to true and the game begins.
                 
             if (gameInProgress) {
                     // This should not be possible.
                message = "You still have to finish this game!";
                repaint();
                return;
             }

             /* If user has run out of money, give the user a new $100 */
    
             if (usersMoney == 0)
                usersMoney = 100;
                
             /* Get the user's betAmount from the bet input box.  If an 
                error is discovered, set an error message and exit the
                doNewGame() routine. */
    
             try {
                betAmount = Integer.parseInt( betInput.getText() );
             }
             catch (NumberFormatException e) {
                message = "The bet you entered is not a legal number!";
                repaint();
                return;
             }
             if (betAmount < 1) {
                message = "You have to bet at least $1.";
                repaint();
                return;
             }
             if (betAmount > usersMoney) {
                message = "You don't have $" + betAmount + ".  Enter a smaller bet.";
                repaint();
                return;
             }

             deck = new Deck();   // Create the deck and hands to use for this game.
             dealerHand = new BlackjackHand();
             playerHand = new BlackjackHand();
             deck.shuffle();
             dealerHand.addCard( deck.dealCard() );  // Deal two cards to each player.
             dealerHand.addCard( deck.dealCard() );
             playerHand.addCard( deck.dealCard() );
             playerHand.addCard( deck.dealCard() );
             if (dealerHand.getBlackjackValue() == 21) {
                 userLost("Sorry, you lose.  Dealer has Blackjack.");
             }
             else if (playerHand.getBlackjackValue() == 21) {
                 userWon("You win!  You have Blackjack.");
             }
             else {
                 message = "You have " + playerHand.getBlackjackValue() + ".  Hit or stand?";
                 setGameInProgress(true);
             }
             repaint();

          }  // end newGame();


          public void paintComponent(Graphics g) {
                // The paint method shows the message at the bottom of the
                // canvas, and it draws all of the dealt cards spread out
                // across the canvas.

             super.paintComponent(g); // fill with background color.

             g.setFont(bigFont);

             // Tell the user how much money he/she has.
          
             g.setColor(Color.yellow);
             if (usersMoney == 0)
                g.drawString("You're out of money!  I'll give you another $100.", 10, getSize().height - 35);
             else
                g.drawString("You have $" + usersMoney, 10, getSize().height - 35);
                
             // Show the message at the bottom of the panel.

             g.setColor(Color.green);
             g.drawString(message, 10, getSize().height - 10);

             // Draw labels for the two sets of cards.

             g.drawString("Dealer's Cards:", 10, 23);
             g.drawString("Your Cards:", 10, 153);

             /* Before the first game starts, dealerHand is null.  We can't
                draw any cards if this is true, so draw 4 face-down cards 
                and exit from the paintComponent method. */
          
             if (dealerHand == null) {
                drawCard(g, null, 10, 30);
                drawCard(g, null, 120, 30);
                drawCard(g, null, 10, 160);
                drawCard(g, null, 120, 160);
                return;
             }

             // Draw dealer's cards.  Draw first card face down if
             // the game is still in progress,  It will be revealed
             // when the game ends.

             g.setFont(smallFont);
             if (gameInProgress)
                drawCard(g, null, 10, 30);
             else
                drawCard(g, dealerHand.getCard(0), 10, 30);
             for (int i = 1; i < dealerHand.getCardCount(); i++)
                drawCard(g, dealerHand.getCard(i), 10 + i * 90, 30);

             // Draw the user's cards.

             for (int i = 0; i < playerHand.getCardCount(); i++)
                drawCard(g, playerHand.getCard(i), 10 + i * 90, 160);

          }  // end paintComponent();


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
          }  // end drawCard()


       } // end nested class BlackjackCanvas


    } // end class HighLowGUI3
