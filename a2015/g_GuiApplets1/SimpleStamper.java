package g_GuiApplets1;
 import java.awt.*;
   import java.awt.event.*;
   import javax.swing.*;
   public class SimpleStamper extends JApplet {
      public void init() {
         Display display = new Display();
         setContentPane(display);
      }
      class Display extends JPanel implements MouseListener {
            Display() {
            setBackground(Color.black);
             addMouseListener(this);
         }
         public void mousePressed(MouseEvent evt) {
             if ( evt.isShiftDown() ) {
                repaint();
                return;
             }
             int x = evt.getX();  // x-coordinate where user clicked.
             int y = evt.getY();  // y-coordinate where user clicked.

             Graphics g = getGraphics();  // Graphics context for drawing
                                          // directly on this JPanel.
             if ( evt.isMetaDown() ) {
                 g.setColor(Color.blue);
                 g.fillOval( x - 30, y - 15, 60, 30 );
                 g.setColor(Color.black);
                 g.drawOval( x - 30, y - 15, 60, 30 );
             }
             else {
                 g.setColor(Color.red);
                 g.fillRect( x - 30, y - 15, 60, 30 );
                 g.setColor(Color.black);
                 g.drawRect( x - 30, y - 15, 60, 30 );
             }

             g.dispose();  // We are finished with the graphics context,
                           //   so dispose of it.
          }
         public void mouseEntered(MouseEvent evt) { }
         public void mouseExited(MouseEvent evt) { }
         public void mouseClicked(MouseEvent evt) { }
         public void mouseReleased(MouseEvent evt) { }

      }  // end nested class Display   
   } // end class SimpleStamper
