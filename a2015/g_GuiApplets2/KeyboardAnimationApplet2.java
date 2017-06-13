package g_GuiApplets2;

/*
    The KeyboardAnimation2 applet provides a generic framework for applets
    both display an animation and respond to keyboard events.  The animation
    runs only when the applet has the keyboard focus and can respond to 
    key presses.  The appearance of the applet changes, depending on whether
    it has the keyboard focus.  Note that each time a new frame of the 
    animation is to be displayed, it is drawn completely from scratch.
    When the applet has the keyboard focus, a cyan border is drawn around
    it.  When it does not have the keyboard focus, the border is in
    the applet's background color and a message "Click to activate" is
    displayed in the applet's foreground color and font.

    This class would be appropriate, for example, as a basis for a typical
    arcade game, such as Space Invaders.  (Except that the performance
    might not be good on a slow machine.)
    
    To use this framework, define a subclass of KeyboardAnimationApplet2 and
    override the drawFrame() method.  This method is responsible for drawing
    one frame of the animation.  If you need to some initialization at the
    time the applet is created, override the doInitialization() method.
    This method is called once when the applet is created.  You should
    not override the standard applet methods init(), start(), and stop()
    unless you call the inherited versions from this class.
    
    In this class, the applet is already set up to "listen" for keyboard
    events.  To make your applet respond to keyboard events, you should
    override one or more of the methods keyPressed(), keyReleased(),
    and keyTyped().  The applet also listens for MouseEvents, and you
    can override the mouse handling events if you want.  But if you do
    override mousePressed(), be sure to call super.mousePressed() which
    will request the input focus.
    
    To respond to key presses, you should have some instance variables
    that affect the image drawn.  Change these variables in the keyPressed,
    keyReleased, or keyTyped methods.
    
    (Alternatively, instead of defining a subclass, you could copy this
    file, change its name and the name of the class, and edit it.)
    
    When this file is compiled, two class files are produced:
    KeyboardAnimationApplet2.class and KeyboardAnimationApplet2$1.class.
    Both class files are necessary to use the applet.
        
    David Eck
    Department of Mathematics and Computer Science
    Hobart and William Smith Colleges
    Geneva, NY 14456
    eck@hws.edu
    
    May 20, 2002
    
    NOTE:  This program requires Java 1.2 or higher.  It is based on an older 
    program, KeyboardAnimationApplet.java, which has essentially the same 
    functionality but which worked with Java 1.1.

*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyboardAnimationApplet2 extends JApplet 
                 implements ActionListener, KeyListener, FocusListener, MouseListener {

   // This rest of this file is private stuff that you don't have to know about
   // when you write subclasses of this class.

   private int frameNumber = 0;            // Current frame number.
   private int frameCount = -1;            // If > 0, frame number loops from
                                           //   frameNumber-1 back to 0.
   private int millisecondsPerFrame = 40;  // Approximate time between frames.
   
   private long startTime;       // Time since animation was started or restarted.
   private long oldElapsedTime;  // Holds time the animation had been running before
                                 //    it was most recently restarted.
   private long elapsedTime;     // Time animation has been running.  This is set
                                 //    just before each frame is drawn.

   private Timer timer;   // The timer that drives the animation.
   
   private JPanel frame;  // Where the frames are drawn.  This panel fills the applet.
   
   private boolean focussed = false;  // set to true when the applet has the keyboard focus
   
   Color focusBorderColor = Color.cyan;  // Color of border when applet has the focus.
   
   public KeyboardAnimationApplet2() {  // Constructor
      frame = new JPanel() { // Anonymous Class
            public void paintComponent(Graphics g) {
               int width = getSize().width;
               int height = getSize().height;
               drawFrame(g,width,height);
               if (focussed)                     // Draw a 3-pixel border.  If the applet has the
                  g.setColor(focusBorderColor);  //   focus, draw it in focusBorderColor; otherwise,
               else                              //   draw it in the background color.
                  g.setColor(KeyboardAnimationApplet2.this.getBackground());
               g.drawRect(0,0,width-1,height-1);
               g.drawRect(1,1,width-3,height-3);
               g.drawRect(2,2,width-5,height-5);
               if (!focussed) { // If the applet does not have the focus, 
                                // print a message for the user.
                  g.setColor(KeyboardAnimationApplet2.this.getForeground());
                  g.drawString("Try to Click the Square ",10,height-12);
               }
            }
         };
      setContentPane(frame);
      setBackground(Color.gray); // Color used for border when applet doesn't have focus.
      setForeground(Color.red);
      frame.setFont(new Font("SanSerif",Font.BOLD,14));
      frame.addFocusListener(this);
      frame.addKeyListener(this);
      addMouseListener(this);
   }
   
   public void init() {
        // Just call do initialization.  (This is in init() instead of in
        // the constructor since the size of the applet is not known in the
        // constructor.)
      doInitialization(getSize().width, getSize().height);
   }
   
   public void actionPerformed(ActionEvent evt) {
         // Called by the timer when it's time to draw a new frame.
      frameNumber++;
      if (frameCount > 0 && frameNumber >= frameCount)
         frameNumber = 0;
      elapsedTime = oldElapsedTime + (System.currentTimeMillis() - startTime);
      frame.repaint();
   }
      
   private void startAnimation() {
         // Start or restart the animation, but only if the applet has focus.
      if (focussed) {
          if (timer == null) {
             timer = new Timer(millisecondsPerFrame, this);
             timer.start();
          }
          else
             timer.restart();
         startTime = System.currentTimeMillis();
      }
   }
   
   private void stopAnimation() {
         // Start the animation, if it's running, i.e. if the applet has focus.
      if (focussed) {
         oldElapsedTime += (System.currentTimeMillis() - startTime);
         elapsedTime = oldElapsedTime;
         frame.repaint();
         timer.stop();
      }
   }

   public void start() {
           // Called by the system when the applet is first started 
           // or restarted after being stopped.  (Probably this has
           // no effect, since we shouldn't get forcus events before
           // the applet is started.)
      startAnimation();
   }
   
   public void stop() {
           // Called by the system to suspend the applet. 
      stopAnimation();
   }
   
   public void focusGained(FocusEvent evt) {
         // The applet now has the input focus. Set focussed = true
         // start the animation.
      focussed = true;
      startAnimation();
   }
   
    public void focusLost(FocusEvent evt) {
         // The applet has lost the input focus. Set focussed = false
         // and stop the animation.
      stopAnimation();
      focussed = false;
   }
   
   public void mousePressed(MouseEvent evt) {
        // Request the input focus when the user clicks on
        // the applet.
      frame.requestFocus();
   }
   
   public void mouseEntered(MouseEvent evt) { }  // Required by the
   public void mouseExited(MouseEvent evt) { }   //    MouseListener
   public void mouseReleased(MouseEvent evt) { } //       interface.
   public void mouseClicked(MouseEvent evt) { }

   protected void doInitialization(int width, int height) {
       // This routine is called once when the applet is first created.
       // You can override it to do initialization of your instance
       // variables.  It's also a good place to call setFrameCount()
       // and setMillisecondsPerFrame(), if you want to customize these
       // values.  The parameters tell the size of the drawing area
       // at the time the applet is created.
 }

 protected void drawFrame(Graphics g, int width, int height) {
       // This routine should be overridden in any subclass of KeyboardAnimationApplet.
       // It is responsible for drawing one frame of the animation.  The frame
       // is drawn to the graphics context g.  The parameters width and height
       // give the size of the drawing area.  drawFrame() should begin by
       // filling the drawing area with a background color (as is done in this
       // version of drawFrame).  It should then draw the contents of the
       // frame.  The routine can call getFrameNumber() to determine which frame
       // it is supposed to draw.  It can call getElapsedTime() to find out
       // how long the animation has been running, in milliseconds.
       // Note that this routine should not take a long time to execute!
       // As an example, the elapsed number of seconds and the frame number
       // are output.  
    g.setColor(Color.lightGray);
    g.fillRect(0,0,width,height);
    g.setColor(Color.black);
    g.drawString("Elapsed Time:  " + (getElapsedTime()/1000),10,20);
    g.drawString("Frame Number:  " + (getFrameNumber()),10,35);
 }
 
 public void keyTyped(KeyEvent evt) { 
       // Method to respond when the user types a character.  Use
       // char key = evt.getKeyChar() to find out which character
       // was typed.  Note that this method is part of the
       // KeyListener interface.
 }
 
 public void keyPressed(KeyEvent evt) { 
       // Method to respond to key presses.  Use int code = evt.getKeyCode() to
       // get a code number for the key pressed.  The value of this code
       // is given by constants in the KeyEvent class such as KeyEvent.VK_LEFT
       // for the left arrow key and KeyEvent.VK_X for the "X" key.  Override this
       // method if you want to respond when the user presses special keys like 
       // the arrow keys.  Note that this routine is part of the KeyListener
       // interface
 }
 
 public void keyReleased(KeyEvent evt) { 
       // Method to respond when the user releases a key. Use evt.getKeyCode()
       // to get the code number of the key that was released.  Override this
       // method if you want to respond when the user releases a key.  This method
       // is part of the KeyListener interface.
 }
 
 public int getFrameNumber() {
       // Get the current frame number.  The frame number will be incremented
       // each time a new frame is to be drawn.  The first frame number is 0.
       // (If frameCount is greater than zero, and if frameNumber is greater than
       // or equal to frameCount, then frameNumber returns to 0.)  For a keyboard
       // applet, you are not too likely to need frame numbers, actually.
    return frameNumber;
 }
 

 public void setFrameNumber(int frameNumber) {
         // Set the current frame number.  This is the value returned by getFrameNumber().
    if (frameNumber < 0)
       this.frameNumber = 0;
    else
       this.frameNumber = frameNumber;      
 }
 

 public long getElapsedTime() {
         // return the total number of milliseconds that the animation has been
         // running (not including the time when the applet is suspended by
         // the system or when the applet does not have the keyboard focus).
    return elapsedTime;
 }
 

 public void setFrameCount(int max) {
         // If you want your animation to loop through a set of frames over
         // and over, you should call this routine to set the frameCount to 
         // the number of frames in the animation.  Frames will be numbered
         // from 0 to frameCount - 1.  If you specify a value <= 0, the
         // frameNumber will increase indefinitely without ever returning
         // to zero.  The default value of frameCount is -1, meaning that
         // by default frameNumber does NOT loop.
    if (max <= 0)
       this.frameCount = -1;
    else 
       frameCount = max;
 }
 

 public void setMillisecondsPerFrame(int time) {
         // Set the approximate number of milliseconds to be used for each frame.
         // For example, set time = 1000 if you want each frame to be displayed for
         // about a second.  The time is only approximate, and the actual display
         // time will probably be a bit longer.  The default value of 40 is
         // probably OK for a game.
    millisecondsPerFrame = time;
    if (timer != null)
       timer.setDelay(millisecondsPerFrame);
 }
 

 public void setFocusBorderColor(Color c) {
          // Set the color of the three-pixel border that surrounds the applet
          // when the applet has the keyboard focus. The default color is cyan.
          // Note:  The color of the frame when the applet does NOT have the
          // focus is taken from the background color of the applet, which
          // is gray by default.  The color of the message "Click to activate",
          // which is displayed when the applet does not have focus, is taken
          // from the foreground color of the applet, and is red by default.
    focusBorderColor = c;
 }
 
} // end class KeyboardAnimationApplet2