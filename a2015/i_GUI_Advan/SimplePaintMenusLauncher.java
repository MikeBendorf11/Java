package i_GUI_Advan;

/*
    The ShapeDrawLauncher applet displays just one button.  When the
    user clicks that button, a window belonging to the class 
    ShapeDrawFrame is opened.  The name of the button changes from
    "Launch ShapeDraw" to "Close ShapeDraw".  The name changes
    back when the window is closed.  If the window is still open
    when the applet is destroyed, then the window will be closed
    automatically.  This applet depends on the classes defined
    in the file ShapeDrawFrame.java.
    
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class SimplePaintMenusLauncher extends JApplet implements ActionListener {

	SimplePaintMenusFrame paintFrame;  // the ShapeDraw window;
                              // this is null if the window is not open

   JButton launchButton;   // a button for opening the window 
   

   public void init() {  // initialize the applet
        
      launchButton = new JButton("Launch Paint");
      getContentPane().add(launchButton);
      launchButton.addActionListener(this);
      
   } // end init();


   public void actionPerformed(ActionEvent evt) {
            // respond to a click on the button; if no window
            // is open, open one; if a window is open, close it
            // by calling its dispose() method.
       if (paintFrame == null) {
          paintFrame = new SimplePaintMenusFrame();
          launchButton.setText("Close ShapeDraw");
          paintFrame.addWindowListener(new FrameDrawListener());
              // This object will listen for the window
              // event that occurs when the window closes.
          paintFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
              // shapeDraw's default close operation is EXIT_ON_CLOSE,
              // which is not legal for a frame opened by an applet.
              // Change it to DISPOSE_ON_CLOSE, which will simply
              // destroy the window, without calling System.exit().
       }
       else {
          launchButton.setEnabled(false);  // disable button while waiting
                                           // for window to close
          paintFrame.dispose();
       }
   }  
   
   public void destroy() {
         // when the applet is destroyed, check if there is
         // a window open; if so, close it.
      if (paintFrame != null) {
          paintFrame.dispose();
          paintFrame = null;
       }
   }
   
   class FrameDrawListener extends WindowAdapter {
          // This nested class defines an object that
          // listens for the WindowEvent that is generated
          // when the window closes for any reason.
          // The button's name is changed back to "Launch ShapeDraw"
          // and the button is enabled (after possibly being disabled in the
          // actionPerformed() method, if that is what caused the
          // window to close).
      synchronized public void windowClosed(WindowEvent evt) {
         launchButton.setText("Launch ShapeDraw");
         launchButton.setEnabled(true);
         paintFrame = null;
      }
   }

}