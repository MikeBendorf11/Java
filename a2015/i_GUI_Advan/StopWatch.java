package i_GUI_Advan;

/*
   A component that acts as a simple stop-watch.  When the user clicks
   on it, this componet starts timing.  When the user clicks again,
   it displays the time between the two clicks.  Clicking a third time
   starts another timer, etc.  While it is timing, the label just
   displays the message "Timing....".
*/

import java.awt.event.*;

import javax.swing.*;

public class StopWatch extends JLabel implements MouseListener, ActionListener {

   private long startTime;   // Start time of timer.
                             //   (Time is measured in milliseconds.)
   Timer timer;
   int elapsed;
   private boolean running;  // True when the timer is running.
   
   
   public StopWatch() {
         // Constructor.
      super("  Click to start timer.  ", JLabel.CENTER);
      addMouseListener(this);
    
   }
   public void start() {
	   elapsed=0;
      if (timer == null) {
         timer = new Timer(1000, this); /// CORRECTION MAYBE this
         timer.start();
	      }
   }
	      
   public void stop() {
	   if (timer !=null){
		   timer.stop();
		   timer=null;
		   }      
	   }
   public void actionPerformed(ActionEvent arg0) {
	  // discussion is whether we need to create a name for the action listener or
	   // we could just explain here what the timer is going to do
   		
	   elapsed++;
	   setText("Timing...." + elapsed); 
   }
   public void mousePressed(MouseEvent evt) {
          // React when user presses the mouse by
          // starting or stopping the timer.
      if (running == false) {
            // Record the time and start the timer.
         running = true;
         start();
         startTime = evt.getWhen();  // Time when mouse was clicked.
        
        
      }
      else {
            // Stop the timer.  Compute the elapsed time since the
            // timer was started and display it.
         running = false;
         stop();
         long endTime = evt.getWhen();
         double seconds = (endTime - startTime) / 1000.0;
         setText("Time: " + seconds + " sec.");
      }
   }
   
   public void mouseReleased(MouseEvent evt) { }
   public void mouseClicked(MouseEvent evt) { }
   public void mouseEntered(MouseEvent evt) { }
   public void mouseExited(MouseEvent evt) { }

}  // end StopWatch