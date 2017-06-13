package j_Arrays;
/*
   This applet lets the user place colored rectangles on a canvas
   by right-clicking the canvas.  The color of the rectangle is given
   by a color palette that lies along the bottom of the applet.
   Alt-clicking (or clicking with middle mouse button) on a rectangle
   will delete it.  Shift-clicking a rectangle will move it out in
   front of all the other rectangles.  With no modifier key,
   the user can left-click and drag to move the rectangles around.
   They are restricted so that they cannot be moved entirely off
   the canvas.
   
   The main point of this applet is to demonstrate the use of an
   ArrayList.
   
   This program depends on RainbowPalette.java.  When this file
   is compiled, it produces three class files.  You need all three
   class files plus RainbowPalette.class to use the program.
*/


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;


public class ASimpleDrawRects extends JApplet {

   ARainbowPalette rainbowObj;  // A palette of colors that appears
                               // at the bottom of the applet.  The
                               // RainbowPalette class is non-standard,
                               // and is defined externally to this file.

   public void init() {
         // Set up the applet with a drawing surface and palette.
      setBackground(Color.black); // shows along border
      display canvas = new display();
      rainbowObj = new ARainbowPalette();
      getContentPane().add(canvas, BorderLayout.CENTER);
      getContentPane().add(rainbowObj, BorderLayout.SOUTH);
   }
   
   public Insets getInsets() {
         // Leave space for a black border around the applet.
      return new Insets(2,2,2,2);
   }
   
   //-------------------------- Nested classes -------------------


   static class ColoredRect {
          // Represents the data for one colored rectangle.
      int x, y, width, height;   // Location and size of rect.
      Color color;               // Color of rect.
   }


   class display extends JPanel
                             implements MouseListener, MouseMotionListener {

           // This class is a canvas that shows some colored rectangles.
           // The user adds a rectangle by right-clicking on the canvas.
           // The user can delete a rectangle by Alt-clicking it, and can
           // move it out in front of the other rectangles by Shift-clicking
           // it.  The user can also click-and-drag rectangles to move them
           // around the canvas.

      private ArrayList rectArray;   // The colored rectangles are represented by objects
                                 // of type ColoredRect that are stored in this ArrayList.


      /* Variables for implementing dragging. */

      private boolean dragging;      // This is true when dragging is in progress.
      private ColoredRect dragRect;  // The rect that is being dragged (if dragging is true).
      private int offsetx, offsety;  // The distance from the upper left corner of the
                                     //   dragRect to the point where the user clicked
                                     //   the rect.  This offset is maintained as the
                                     //   rect is dragged.


      display() {
            // Constructor.  The canvas listens for mouse events, and an
            // ArrayList is created to hold the ColoredRects.
         setBackground(Color.white);
         addMouseListener(this);
         addMouseMotionListener(this);
         rectArray = new ArrayList();
      }

      ColoredRect findRect(int x, int y) {// ** needed when we click on rect
            // Find the topmost rect that contains the point (x,y).
            // Return null if no rect contains that point.
            // The rects in the ArrayList are considered in reverse order
            // so that if one lies on top of another, the one on top
            // is seen first and is returned.
          for (int i = rectArray.size() - 1;  i >= 0;  i--) {
             ColoredRect rect = (ColoredRect)rectArray.get(i);
             if ( x >= rect.x && x < rect.x + rect.width
                         && y >= rect.y && y < rect.y + rect.height )
                 return rect;  // (x,y) is inside this rect.
          }
          return null;
      }

      void bringToFront(ColoredRect rect) {
              // If rect != null, move it out in front of the other
              // rects by moving it to the last position in the ArrayList.
         if (rect != null) {
             rectArray.remove(rect);  // Remove rect from current position.
             rectArray.add(rect);     // Put rect in the ArrayList in last position.
             repaint();
         }
      }

      void deleteRect(ColoredRect rect) {
              // If rect != null, remove it from the ArrayList and from the screen.
         if (rect != null) {
            rectArray.remove(rect);
            repaint();
         }
      }

      public void paintComponent(Graphics g) {
            // Draw all the rects in the ArrayList.
         super.paintComponent(g);  // Fills with background color, white.
         for (int i = 0; i < rectArray.size(); i++) {
            ColoredRect rect = (ColoredRect)rectArray.get(i);
            g.setColor(rect.color);
            g.fillRect(rect.x, rect.y, rect.width, rect.height);
            g.setColor(Color.black);
            g.drawRect(rect.x, rect.y, rect.width - 1, rect.height - 1);
         }
      }

      public void mousePressed(MouseEvent evt) { 
               // The user clicked on the canvas.  This can have several effects...

         if (dragging)  // If dragging is already in progress, just return.
            return;

         if (evt.isMetaDown()) {
                  // User right-clicked or command clicked.  Make a new
                  // rectangle and add it to the canvas.  Every rectangle is
                  // 60 pixels wide and 30 pixels tall.  The point where the
                  // user clicked is at the center of the rectangle.  It's
                  // color is the selected color in the colorInput palette.
             ColoredRect rect = new ColoredRect();
             rect.x = evt.getX() - 30;
             rect.y = evt.getY() - 15;
             rect.width = 60;
             rect.height = 30;
             rect.color = rainbowObj.getSelectedColor();
             rectArray.add(rect);
             repaint();
         }
         else if (evt.isShiftDown()) {
                 // User shift-clicked.  More the rect that the user
                 // clicked (if any) to the front.  Note that findRect()
                 // might return null, but bringToFront() accounts for that.
            bringToFront( findRect( evt.getX(), evt.getY() ) );
         }
         else if (evt.isAltDown()) {
                 // User alt-clicked or middle-clicked.  Delete the rect
                 // that the user clicked.
            deleteRect( findRect( evt.getX(), evt.getY() ) );
         }
         else {
                  // This is a simple left-click.  Start dragging the
                  // rect that the user clicked (if any).
            dragRect = findRect( evt.getX(), evt.getY() );
            if (dragRect != null) {
               dragging = true;   // Begin a drag operation.
               offsetx = evt.getX() - dragRect.x;
               offsety = evt.getY() - dragRect.y;
            }

         }

      } // end mousePressed()

      public void mouseReleased(MouseEvent evt) { 
              // End the drag operation, if one is in progress.
         if (dragging == false)
            return;
         dragRect = null;
         dragging = false;
      }

      public void mouseDragged(MouseEvent evt) { 
              // Continue the drag operation if one is in progress.
              // Move the rect that is being dragged to the current
              // mouse position.  But clamp it so that it can't
              // be more than halfway off the screen.

         if (dragging == false)
            return;

         dragRect.x = evt.getX() - offsetx;  // Get new postion of rect.
         dragRect.y = evt.getY() - offsety;

         /* Clamp (x,y) to a permitted range, as described above. */

         if (dragRect.x < - dragRect.width / 2)
            dragRect.x = - dragRect.width / 2;
         else if (dragRect.x + dragRect.width/2 > getSize().width)
            dragRect.x = getSize().width - dragRect.width / 2;
         if (dragRect.y < - dragRect.height / 2)
            dragRect.y = - dragRect.height / 2;
         else if (dragRect.y + dragRect.height/2 > getSize().height)
            dragRect.y = getSize().height - dragRect.height / 2;

         /* Redraw the canvas, with the rect in its new position. */

         repaint();

      }  // end mouseDragged()

      public void mouseClicked(MouseEvent evt) { }
      public void mouseEntered(MouseEvent evt) { }
      public void mouseExited(MouseEvent evt) { }
      public void mouseMoved(MouseEvent evt) { }

   }  // end nested class Rects

   
}  // end class SimpleDrawRects
