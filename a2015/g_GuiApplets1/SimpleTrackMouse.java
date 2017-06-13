package g_GuiApplets1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleTrackMouse extends JApplet 
                      implements MouseListener, MouseMotionListener {

   Display display;             // Drawing surface, defined by nested class Display.
   int mouse_x, mouse_y;        // Position of mouse.
   String modifierKeys = "";    // If non-null, gives special keys that are held down.
   String eventType = null;     // If non-null, gives the type of the most recent mouse event.
   
   public class Display extends JPanel {
        // A nested class that defines the drawing surface of the
        // applet.  This simply displays the information contained
        // in the main class instance variables mouse_x, mouse_y,
        // modifierKeys, and eventType.
      public void paintComponent(Graphics g) {
            // Draw the panel, showing information about mouse events.
         super.paintComponent(g);  // Fills panel with background color.
         g.setColor(Color.blue);
         g.drawRect(0 ,0, getSize().width - 1 ,getSize().height - 1);  
         g.drawRect(1 ,1, getSize().width - 3 ,getSize().height - 3);  
         g.setColor(Color.red);
         if (eventType == null) {
                // If eventType is null, no mouse event has yet occurred 
                // on the panel, so don't display any information.
             return;
         }
         g.drawString("Mouse event type:  " + eventType, 6, 18);
         if (modifierKeys.length() > 0)
            g.drawString("Modifier keys:     " + modifierKeys, 6, 34);
         g.setColor(Color.black);
         g.drawString("(" + mouse_x + "," + mouse_y + ")",
              mouse_x, mouse_y);
      }  // end of paintComponent()
   } // end nested class Display
   
   public void init() { 
         // Set background color and arrange for the applet to listen for mouse events.
      display = new Display();
      setContentPane(display);
      display.setBackground(Color.white);
      display.addMouseListener(this);
      display.addMouseMotionListener(this);
   }
   
   void setInfo(MouseEvent evt) {
         // set up the information about event for display
      mouse_x = evt.getX();
      mouse_y = evt.getY();
      modifierKeys = "";
      if (evt.isShiftDown())
         modifierKeys += "Shift  ";
      if (evt.isControlDown())
         modifierKeys += "Control  ";
      if (evt.isMetaDown())
         modifierKeys += "Meta  ";
      if (evt.isAltDown())
         modifierKeys += "Alt";
      display.repaint();
   }
   
   // Implement all the events of the MouseListener and MouseMotionListener
   // interfaces.  Each method sets eventType to record the type of event and
   // calls the setInfo method to extract other information from the event
   // for display.
   
   public void mousePressed(MouseEvent evt) {
      eventType = "mousePressed";
      setInfo(evt);
   }
      
   public void mouseReleased(MouseEvent evt) {
      eventType = "mouseReleased";
      setInfo(evt);
   }
      
   public void mouseClicked(MouseEvent evt) {
      eventType = "mouseClicked";
      setInfo(evt);
   }
      
   public void mouseEntered(MouseEvent evt) {
      eventType = "mouseEntered";
      setInfo(evt);
   }
      
   public void mouseExited(MouseEvent evt) {
      eventType = "mouseExited";
      setInfo(evt);
   }
      
   public void mouseMoved(MouseEvent evt) {
      eventType = "mouseMoved";
      setInfo(evt);
   }
      
   public void mouseDragged(MouseEvent evt) {
      eventType = "mouseDragged";
      setInfo(evt);
   }
      
}  // end of class SimpleMouseTracker