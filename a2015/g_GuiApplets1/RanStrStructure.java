package g_GuiApplets1;


import java.awt.*;

import javax.swing.*;


public class RanStrStructure extends JApplet{
	
	
	Display2 drawingSurface2;
	public void init(){ // its like a constructor
		drawingSurface2  = new Display2();
		 setContentPane(drawingSurface2);
		 drawingSurface2.setBackground(Color.black);
		 drawingSurface2.setSize(0, 0);
	}
	 class Display2 extends JPanel {
        
		 public void paintComponent(Graphics g) {
			 super.paintComponent(g);
			// random and string position coding here
       	}
	 }
}
