package j_Arrays;
import java.awt.*;
   import javax.swing.*;
/*arrays were created to hold the values of the position of 
 * the text, now when the window is resized or minimized, the 
 * original positions of the text wont change*/
   public class RandomStringsMod extends JApplet {

      String message;  
      Font font1, font2, font3, font4, font5;  // The five fonts.
      Display drawingSurface;  
      graphData[] data;	// created bellow
      
      class graphData{		// declare the arrays that will contain the data
    	  int fontArray, xArray, yArray;
          float hueArray;
      }     
     		
      
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

         setContentPane(drawingSurface);
         
         int width = getSize().width;   
         int height = getSize().height; 
         
         data = new graphData[25];		// create 25 variables for each member of the 
         								// graphData class       
         for (int i = 0; i < 25; i++) { 					/////////LOOP

             int fontNum = (int)(5*Math.random()) + 1;
         
             float hue = (float)Math.random();
 
             int x,y;
             x = -50 + (int)(Math.random()*(width+40));
             y = (int)(Math.random()*(height+20));
       
             data[i].fontArray= fontNum;
             data[i].hueArray=hue;
             data[i].xArray=x;
             data[i].yArray=y;
         } // end for
      } // end init()

      class Display extends JPanel {
        
         public void paintComponent(Graphics g) {
        	 
            super.paintComponent(g);  
                    
            for (int i = 0; i < 25; i++) { 
            	 switch (data[i].fontArray) {
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
              }
                 g.setColor( Color.getHSBColor(data[1].hueArray, 1.0F, 1.0F) );
                 g.drawString(message,data[1].xArray,data[1].yArray);
            }
           
         } // end paintComponent()

      }  // end nested class Display

   }  // end class RandomStrings
   