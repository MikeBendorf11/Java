package g_GuiApplets2;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class structureOnly extends JApplet {
	public void init(){
		Canvas2 canvas2 = new Canvas2();
		setContentPane(canvas2);
		addMouseListener(canvas2); // if here then canvas2
	}
	
	class Canvas2 extends JPanel implements MouseListener, KeyListener{
		Canvas2(){
			setBackground(Color.black);
			
			addKeyListener(this); // if here then this
			 JButton higher = new JButton( "Higher" );
		      addMouseListener(this);
			// graphics methods here
		}
		// events are programmed 
		// within the JPanel canvas 2 object
		public void keyPressed(KeyEvent e) {	}
		public void keyReleased(KeyEvent e) {	}
		public void keyTyped(KeyEvent e) {		}
		public void mouseClicked(MouseEvent e) {	}
		public void mouseEntered(MouseEvent e) {	}
		public void mouseExited(MouseEvent e) {		}
		public void mousePressed(MouseEvent e) {	}
		public void mouseReleased(MouseEvent e) {	}
	}
}
