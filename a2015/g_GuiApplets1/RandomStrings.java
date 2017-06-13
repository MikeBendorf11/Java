package g_GuiApplets1;
import java.awt.*;
   import javax.swing.*;

   public class RandomStrings extends JApplet {

      String message;  // The message to be displayed.  This can be set in
                       // an applet param with name "message".  If no
                       // value is provided in the applet tag, then 
                       // the string "Java!" is used as the default.

      Font font1, font2, font3, font4, font5;  // The five fonts.

      Display drawingSurface;  // This is the component on which the
                               // drawing will actually be done.  It
                               // is defined by a nested class that
                               // can be found below.

      public void init() {
             // Called by the system to initialize the applet.

         message = getParameter("message");
         if (message == null)
            message = "Java!";

         font1 = new Font("Serif", Font.BOLD, 14);
         font2 = new Font("SansSerif", Font.BOLD + Font.ITALIC, 24);
         font3 = new Font("Monospaced", Font.PLAIN, 20);
         font4 = new Font("Dialog", Font.PLAIN, 30);
         font5 = new Font("Serif", Font.ITALIC, 36);

         drawingSurface = new Display();  // Create the drawing surface.
         drawingSurface.setBackground(Color.black);

         setContentPane(drawingSurface);  // Since drawingSurface will fill
                                          // the entire applet, we simply
                                          // replace 8•the applet's content 
                                          // pane with drawingSurface.
      } // end init()


      class Display extends JPanel {
           // This nested class defines a JPanel that is used
           // for displaying the content of the applet.  An
           // object of this class is used as the content pane
           // of the applet.  Note that since this is a nested
           // non-static class, it has access to the instance
           // variables of the main class such as message and font1.

         public void paintComponent(Graphics g) {

            super.paintComponent(g);  // Call the paintComponent method from
                                      // the superclass, JPanel.  This simply
                                      // fills the entire component with the
                                      // component's background color.

            int width = getSize().width;   // Get this component's width.
            int height = getSize().height; // Get this component's height.

            for (int i = 0; i < 25; i++) {

                // Draw one string.  First, set the font to be one of the five
                // available fonts, at random.  

                int fontNum = (int)(5*Math.random()) + 1;
                switch (fontNum) {
                   case 1:
                      g.setFont(font1);
                      break;
                   case 2:
                      g.setFont(font2);
                      break;
                   case 3:
                      g.setFont(font3);
                      break;
                   case 4:
                      g.setFont(font4);
                      break;
                   case 5:
                      g.setFont(font5);
                      break;
                } // end switch

                // Set the color to a bright, saturated color, with random hue.

                float hue = (float)Math.random();
                g.setColor( Color.getHSBColor(hue, 1.0F, 1.0F) );

                // Select the position of the string, at random.

                int x,y;
                x = -50 + (int)(Math.random()*(width+40));
                y = (int)(Math.random()*(height+20));

                // Draw the message.

                g.drawString(message,x,y);

            } // end for

         } // end paintComponent()

      }  // end nested class Display


   }  // end class RandomStrings
   