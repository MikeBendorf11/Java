package g_GuiApplets1;
 import javax.swing.*;    // Swing GUI classes are defined here.
   import java.awt.event.*; // Event handling class are defined here.

   public class HelloSwing extends JApplet implements ActionListener {

      public void init() {
            // This method is called by the system before the applet
            // appears.  It is used here to create the button and add
            // it to the "content pane" of the JApplet.  The applet
            // is also registered as an ActionListener for the button.

         JButton bttn = new JButton("Click Me!");
         bttn.addActionListener(this);
         getContentPane().add(bttn);

      } // end init()

      public void actionPerformed(ActionEvent evt) {
            // This method is called when an action event occurs.
            // In this case, the only possible source of the event
            // is the button.  So, when this method is called, we know
            // that the button has been clicked.  Respond by showing
            // an informational dialog box.  The dialog box will
            // contain an "OK" button which the user must click to
            // dismiss the dialog box.

         String title = "Greetings";  // Shown in title bar of dialog box.
         String message = "Hello from the Swing User Interface Library.";
         JOptionPane.showMessageDialog(null, message, title,
                                        JOptionPane.INFORMATION_MESSAGE);
      } // end actionPerformed()

   } // end class HelloSwing
   