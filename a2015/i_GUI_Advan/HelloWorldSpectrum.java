package i_GUI_Advan;


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class HelloWorldSpectrum extends JApplet implements ActionListener {

   Display display; 
   JButton startStopButton; 
   Timer timer;  
   int colorIndex; 
   public void init() {
       display = new Display();
       getContentPane().add(display, BorderLayout.CENTER);
       JPanel buttonBar = new JPanel();
       buttonBar.setBackground(Color.gray);
       getContentPane().add(buttonBar, BorderLayout.SOUTH); 
       startStopButton = new JButton("Start");
       buttonBar.add(startStopButton);
       startStopButton.addActionListener(this);
   }  // end init()
  
   public void actionPerformed(ActionEvent e) {
       if (timer == null)
          startAnimation();
       else
          stopAnimation();       
    }
   
   ActionListener timerListener = new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
             colorIndex++;  // A number between 0 and 100.
             if (colorIndex > 100)
                colorIndex = 0;
             float hue = colorIndex / 100.0F;  // Between 0.0F and 1.0F.
             display.setColor( Color.getHSBColor(hue,1,1) ); 
         }
      };
   

   void startAnimation() {

       if (timer == null) {
          timer = new Timer(50, timerListener);
          timer.start(); 
          startStopButton.setText("Stop");
       }
   }
   
   void stopAnimation() {

      if (timer != null) {
         timer.stop();   // Stop the timer.
         timer = null;   
         startStopButton.setText("Start");
      }
   }  
   public void stop() {
      stopAnimation();
   }
   class Display extends JPanel {
      Color color;     
      Font textFont;   
      
      Display() {
         setBackground(Color.black);
         color = Color.red; // Initial color of the message.
         textFont = new Font("Serif",Font.BOLD,36);
   }    
      void setColor(Color color) {
         this.color = color;
         repaint();
      }

      public void paintComponent(Graphics g){
         super.paintComponent(g);
         g.setColor(color);
         g.setFont(textFont);       // Set the font.
         g.drawString("Hello World!", 25,50);    // Draw the message.
      } // end paintComponent
   } // end nested class Display


}
 // end class HelloWorldJApplet
