package g_GuiApplets2;

import java.awt.*;        // for access to GUI classes
import java.awt.event.*;  // for access to the KeyEvent class


public class SubKillerGame2 extends KeyboardAnimationApplet2 {


   protected void doInitialization(int width, int height) {
       
      initSubmarine(width, height);  
      
      
      
   } // end doInitialization()


   synchronized public void drawFrame(Graphics g, int width, int height) {
       g.setColor(Color.green);
       g.fillRect(0,0,width,height);
       Font font = new Font("Dialog", Font.PLAIN,11); 
       g.setFont(font);
       g.setColor(Color.BLACK);
       g.drawString("Missed Bombs: "  + " Submarine Explosions: " + subExplosions 
    		   , 20, 20);
  
       doSubmarineFrame(g, width, height);

       
   } // end drawFrame()
   
 

   // -------------- Instance variables and method for the bomb -------------
   


   // -------------- Instance variables and method for the submarine -------------
   
   int subCenterX; 
   int subCenterY;
   
   boolean subIsMovingLeft; 
   int explosionFrameNumber; 
   int subExplosions=0;
     
   void initSubmarine(int width, int height) {
      subCenterX = (int)(width * Math.random());
      subCenterY = height - 40;
      explosionFrameNumber = 0;
      if (Math.random() < 0.5)
         subIsMovingLeft = true;
      else
         subIsMovingLeft = false;
   }
   
   void doSubmarineFrame(Graphics g, int width, int height) {
     
            
    
      
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
      
   }  // end doSubmarineFrame 
} // end class SubKiller