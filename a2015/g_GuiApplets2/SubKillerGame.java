package g_GuiApplets2;

/*
   This is a simple arcard game in which the user tries to blow up
   a submarine (a black oval) by dropping depth charges from a
   ship (a blue roundrect).  The user moves the boat with the
   left- and right-arrow keys and drops the depth charge with the
   down-arrow key.
 
   The sub killer applet is based on KeyboardAnimationApplet2, which is
   a framework for applets that display animated action while allowing
   keyboard input from the user to affect the action.  See the file
   KeyboardAnimationApplet2.java for more information.
   
   (Note that the KeyboardAnimationApplet2 class already implements
   KeyListener, FocusListener, and MouseListener.)
*/


import java.awt.*;        // for access to GUI classes
import java.awt.event.*;  // for access to the KeyEvent class


public class SubKillerGame extends KeyboardAnimationApplet2 {


   protected void doInitialization(int width, int height) {
         // This routine will be called once, when the animation applet
         // is first created.  The three objects that appear in the
         // applet are initialized, by calling methods that are defined
         // later in this class.  The parameters width and height
         // give the width and height of the drawing area.
         
      initSubmarine(width, height);  
      initBoat(width, height); 
      initBomb(width,height);
      
   } // end doInitialization()


   synchronized public void drawFrame(Graphics g, int width, int height) {
          // This routine is called to draw the next frame of the animation.
          // The parameter, g, is a graphics context for drawing the frame.
          // The parameters width and height give the size of the frame.
          // Here, methods are called to process and draw each of the
          // three objects in the scene.
   
       // First, fill the whole drawing area with green
       
       g.setColor(Color.green);
       g.fillRect(0,0,width,height);
       Font font = new Font("Dialog", Font.PLAIN,11); 
       g.setFont(font);
       g.setColor(Color.BLACK);
       g.drawString("Missed Bombs: " + missedBombs + " Submarine Explosions: " + subExplosions 
    		   , 20, 20);
       
       // Now, draw the objects in the scene. These subroutines
       // are defined below.  They also change values of instance
       // variables so that the scene will change from one frame to
       // the next.
       
       doBoatFrame(g, width, height);
       doSubmarineFrame(g, width, height);
       doBombFrame(g, width, height);
       
   } // end drawFrame()
   
   
   synchronized public void keyPressed(KeyEvent evt) {
          // This routine is called each time the user presses
          // a key on the keyboard (while the applet has the keyboard
          // focus).  The value of evt.getKeyCode() tells which
          // key was pressed.  For this applet, only the three of the
          // arrow keys will have any effect.  The codes for the
          // four arrow keys are KeyEvent.VK_UP, KeyEvent.VK_DOWN,
          // KeyEvent.VK_LEFT, and KeyEvent.VK_RIGHT.

       int code = evt.getKeyCode();  // which key was pressed

       if (code == KeyEvent.VK_LEFT) {
               // Move the boat left.  (If this moves the boat out of the 
               // frame, its position will be adjusted in the doBoatFrame() method.)
          boatCenterX -= 15;
       }
       else if (code == KeyEvent.VK_RIGHT) {  
               // Move the boat right.  (If this moves the boat out of the 
               // frame, its position will be adjusted in the doBoatFrame() method.)
          boatCenterX += 15;
       }
       else if (code == KeyEvent.VK_DOWN) {
               // Start the bomb falling, it is is not already falling.
               // (The test is not really necessary, since if bombIsFalling
               // is already true, the assignment bombIsFalling = true has
               // no effect anyway.)
          if ( bombIsFalling == false )
             bombIsFalling = true;
       }
   
   } // end keyPressed()
   

   // -------------- Instance variables and method for the bomb -------------
   
   int bombCenterX;  // Horizontal coordinate of the center of the bomb.
   int bombCenterY;  // Vertical coordinate of the center of the bomb.

   boolean bombIsFalling;  // This is set to true when the boat releases the
                           //    bomb.  While it is false, the bomb is 
                           //    attached to the boat.  While it is true,
                           //    the vertical coordinate of the bomb increases
                           //    in each frame, so the bomb falls.
   int missedBombs=0;

   void initBomb(int width, int height) {
          // Initialize instance variables that pertain to the bomb.
       bombIsFalling = false;
       bombCenterY = 100;
   }
   
   void doBombFrame(Graphics g, int width, int height) {
          // If the bomb is NOT falling, just draw it under the center of the boat.
          // If it is falling, move it downwards and then check whether
          // it has either hit the sub or fallen off the applet.  In either
          // case, its state changes to not falling (and so it reappears
          // back under the boat in the next frame).
       if (bombIsFalling) {
          if (bombCenterY > height) {
                // Bomb has missed the submarine.  It is returned to its intial state.
                // It's not drawn in this frame, but it will appear in the next.
             initBomb(width, height);
             bombCenterX = boatCenterX;
             missedBombs++;
          }
          else if (Math.abs(bombCenterX - subCenterX) <= 36 &&
                      Math.abs(bombCenterY - subCenterY) <= 21) {
                // Bomb has hit the submarine.  It is not
                // drawn in this frame, but an explosion starts,
                // and the bomb is returned to its initial state.
             explosionFrameNumber = 1;
             initBomb(width, height);
             bombCenterX = boatCenterX;
          }
          else {
             bombCenterY += 10;
             g.setColor(Color.red);
             g.fillOval(bombCenterX - 8, bombCenterY - 8, 16, 16);
          }
       }
       else {
             // Bomb is not falling.  It is attached to the boat.
             // Use the boat's horizontal position for the bomb.
          bombCenterX = boatCenterX;
          g.setColor(Color.red);
          g.fillOval(bombCenterX - 8, bombCenterY - 8, 16, 16);
       }
   }



   // -------------- Instance variables and method for the boat -------------
   
   int boatCenterX;  // Horizontal coordinate of the center of the boat.
   int boatCenterY;  // Vertical coordinate of the center of the boat.

   void initBoat(int width, int height) {
          // Initialize instance variables that pertain to the boat.
      boatCenterX = width/2;
      boatCenterY = 80;
   }

   void doBoatFrame(Graphics g, int width, int height) {
          // Draw the boat.  Make sure that the boat's horizontal
          // position is within the range 0 to width.  This prevents
          // the user from moving the boat off the screen.
      if (boatCenterX < 0)
         boatCenterX = 0;
      else if (boatCenterX > width)
         boatCenterX = width;
      g.setColor(Color.blue);
      g.fillRoundRect(boatCenterX - 40, boatCenterY - 20, 80, 40, 20, 20);
   }


   // -------------- Instance variables and method for the submarine -------------
   
   int subCenterX;  // Horizontal coordinate of the center of the submarine.
   int subCenterY;  // Vertical coordinate of the center of the submarine.
   
   boolean subIsMovingLeft;  // Sub can be moving left or right; this variable tells which.
   	
   int explosionFrameNumber; // While the sub is exploding, this tells for how many
                             //    frames the exploding has been in progress.  When the
                             //    sub is not exploding, the value of this variable is 0.
                             //    when the bomb hits the sub, the value is set to 1 in
                             //    the doBombFrame method.  When explosiongFrameNumber
                             //    reaches 14, the explosion ends and a new sub is
                             //    created.
   int subExplosions=0;
   
 
   
   void initSubmarine(int width, int height) {
          // Initialize the instance variables that pertain to the submarine.
          // The sub is placed in a random horizontal position, 40 pixels from
          // the bottom of the drawing area.  Its direction of motion is
          // set randomly to either left or right.  At the beginning, the
          // sub is not exploding.
      subCenterX = (int)(width * Math.random());
      subCenterY = height - 40;
      explosionFrameNumber = 0;
      if (Math.random() < 0.5)
         subIsMovingLeft = true;
      else
         subIsMovingLeft = false;
   }
   
   void doSubmarineFrame(Graphics g, int width, int height) {
         // Draw the submarine and update the instance variables that
         // describe it.  The sub has two very different states,
         // depending on whether or not it is exploding.  Note that
         // at the end of an explosion, the bomb is reinitialized so
         // that it appears again under the boat.
	   
      if (explosionFrameNumber > 0) {
    	  
         if (explosionFrameNumber == 14) {  // In the 14-th frame...
        	 subExplosions++;
        	 initSubmarine(width,height);    //    ... create a new sub (also sets explosionFrameNumber to 0)
         }
            
         else if (explosionFrameNumber > 10) { // For frames 11, 12, and 13,
                                               //   there is no sub
             explosionFrameNumber++;  // Just go to next frame of explosion sequence
             
         }
         
         else {  // For frames 1 through 10, draw the sub under an expanding explosion
            g.setColor(Color.black);
            g.fillOval(subCenterX - 30, subCenterY - 15, 60, 30);
            g.setColor(Color.yellow);
            g.fillOval(subCenterX - 4*explosionFrameNumber,
                       subCenterY - 2*explosionFrameNumber,
                       8*explosionFrameNumber,
                       4*explosionFrameNumber);
            g.setColor(Color.red);
            g.fillOval(subCenterX - 2*explosionFrameNumber,
                       subCenterY - explosionFrameNumber/2,
                       4*explosionFrameNumber,
                       explosionFrameNumber);
            explosionFrameNumber++;  // Go on to next frame of explosion.     
         }     
      }
            
      else { // Sub is not exploding.  Move the sub and draw it in its new position
      
         if (Math.random() < 0.04)               // One time out of 25, on average...
            subIsMovingLeft = !subIsMovingLeft;  //   ...randomly reverse direction
            
         if (subIsMovingLeft) { 
            subCenterX -= 5;        // Move the sub left 5 pixels.
            if (subCenterX <= 0) {  // If sub has moved off left hand edge of applet...
               subCenterX = 0;      //       ...move it back to the left edge...
               subIsMovingLeft = false; //  ...and start it moving right.
            }
         }
         else {
            subCenterX += 5;           // Move the sub right 5 pixels.
            if (subCenterX > width) {  // If the sub has moved off the right edge...
               subCenterX = width;     //    ...move it back to the right edge...
               subIsMovingLeft = true; //    ...and start it moving left.
            }
         }
         g.setColor(Color.black);  // Draw the sub
         g.fillOval(subCenterX - 30, subCenterY - 15, 60, 30);
      }
   }  // end doSubmarineFrame 
} // end class SubKiller