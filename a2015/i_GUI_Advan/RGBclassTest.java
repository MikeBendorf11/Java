package i_GUI_Advan;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;


public class RGBclassTest extends JApplet implements ActionListener {
	RGBcomponent rgb;
	  public void init() {
          rgb = new RGBcomponent();
          getContentPane().add(rgb, BorderLayout.CENTER);
          JButton button = new JButton("Set Random Color");
          button.addActionListener(this);
          getContentPane().add(button, BorderLayout.SOUTH);
       }
       
       public void actionPerformed(ActionEvent evt) {
          int r = (int)(Math.random()*256) + 1;
          int g = (int)(Math.random()*256) + 1;
          int b = (int)(Math.random()*256) + 1;
          rgb.setColor(r,g,b);
       }

	
    
}
