package g_GuiApplets2;
import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

public class structureOnly2 extends JApplet 
implements MouseListener, FocusListener, KeyListener{
	Display display2;
	public void init(){
		display2=new Display();
		setContentPane(display2);
		display2.addMouseListener(this);
		display2.addFocusListener(this);
		display2.addKeyListener(this);
	}
	public class Display extends JPanel{
		Display(){
			
		}
		public void paintComponent(Graphics g){
			super.paintComponent(g);	
			setBackground(Color.getHSBColor(0.5f,0.3f,0.6f));
			// graphics methods here
		}			
	}
	public void mouseClicked(MouseEvent e) {	
	//  repaint(); HERE
	}
	public void mouseEntered(MouseEvent e) {	}
	public void mouseExited(MouseEvent e) {		}
	public void mousePressed(MouseEvent e) { 	}
	public void mouseReleased(MouseEvent e) {	}
	public void focusGained(FocusEvent f) {		}
	public void focusLost(FocusEvent f) {	}
	public void keyPressed(KeyEvent arg0) {		}
	public void keyReleased(KeyEvent arg0) {	}
	public void keyTyped(KeyEvent arg0) {	}
}
