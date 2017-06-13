package i_GUI_Advan;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AScrollingHelloWorld extends JApplet 
                          implements ActionListener {
   Timer timer; 
   String message = "Hello World (for absolutely the last time)!";  
   int messagePosition = -1;   
   int messageHeight;  // Data about size of message.
   int messageWidth;  
   int charWidth;  // The width of one character.

   public void init() {
 
      JPanel display = new JPanel() {
            public void paintComponent(Graphics g) {
               super.paintComponent(g);
               g.drawString(message, getWidth() - messagePosition, 
                                    getHeight()/2 + messageHeight/2);
            }
         };
      setContentPane(display);
      display.setBackground(Color.white);
      display.setForeground(Color.red);
      Font messageFont = new Font("Monospaced", Font.BOLD, 30);
      display.setFont(messageFont);
      FontMetrics fm = getFontMetrics(messageFont);
      messageWidth = fm.stringWidth(message);
      messageHeight = fm.getAscent();
      charWidth = fm.charWidth('H');
   }
   
   
   public void start() {
      if (timer == null) {
         timer = new Timer(300, this);
         timer.start();
      }
      else {
         timer.restart();
      }
   }
   
   
   public void stop() {
      timer.stop();
   }
   
   
   public void actionPerformed(ActionEvent evt) {
       messagePosition += charWidth;
       if (getSize().width - messagePosition + messageWidth < 0) {
            // message has moved off left edge
          messagePosition = 0;
       }
       repaint();
   }               
} // end class ScrollingHelloWorld

