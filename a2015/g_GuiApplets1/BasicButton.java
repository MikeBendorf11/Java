package g_GuiApplets1;
 import javax.swing.*;    // Swing GUI classes are defined here.
   import java.awt.event.*; // Event handling class are defined here.

   public class BasicButton extends JApplet implements ActionListener {
public void init() {
         JButton bttn = new JButton("Click Me!");
         getContentPane().add(bttn);
         bttn.addActionListener(this);
      } 
      public void actionPerformed(ActionEvent evt) {    
         String title = "Greetings"; 
         String message = "Hello from the Swing User Interface Library.";
         JOptionPane.showMessageDialog(null, message, title,JOptionPane.INFORMATION_MESSAGE);
      }
   } 