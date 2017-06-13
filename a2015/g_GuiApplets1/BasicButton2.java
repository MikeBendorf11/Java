package g_GuiApplets1;
  import javax.swing.*;    
   import java.awt.event.*; 
   public class BasicButton2 extends JApplet {
      public void init() {
         JButton bttn = new JButton("Click Me!");
         getContentPane().add(bttn);
         bttn.addActionListener(  new ActionListener() {      // subroutine whiting subroutine????
			 public void actionPerformed(ActionEvent evt) {    
				 String title = "Greetings"; 
				 String message = "Another hello from Swing.";
				 JOptionPane.showMessageDialog(null, message, title,JOptionPane.INFORMATION_MESSAGE);
			 	} 
			 });
 
        		 
      } 
   } 