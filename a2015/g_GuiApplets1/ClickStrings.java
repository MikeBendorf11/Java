package g_GuiApplets1;
import java.awt.event.*;

   public class ClickStrings extends RandomStrings 
                                           implements MouseListener {

      public void init() {
         
         super.init();
         drawingSurface.addMouseListener(this);
             }
      public void mousePressed(MouseEvent evt) {
      drawingSurface.repaint();
   }
   public void mouseEntered(MouseEvent evt) { }
   public void mouseExited(MouseEvent evt) { }
   public void mouseClicked(MouseEvent evt) { }
   public void mouseReleased(MouseEvent evt) { }

      }


     