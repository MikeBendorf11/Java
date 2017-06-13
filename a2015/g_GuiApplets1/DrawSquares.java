package g_GuiApplets1;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class DrawSquares extends JApplet{
	public void init(){
		ABC abc = new ABC();
		setContentPane(abc);
	}
	class ABC extends JPanel implements MouseListener{
		ABC(){
			setBackground(Color.black);
			addMouseListener(this);		}
		public void mouseClicked(MouseEvent e) {			}
		public void mouseEntered(MouseEvent e) {			}
		public void mouseExited(MouseEvent e) {				}
		public void mousePressed(MouseEvent e) {
			
			int x = e.getX();
			int y = e.getY();
			Graphics g = getGraphics();
			if (e.isMetaDown()){
				g.setColor(Color.red);
				g.fillRoundRect(x, y, 100, 100, 50, 50);
			}
			else{
				g.setColor(Color.orange);
				g.fillRect(x, y, 100, 100);
			}
			if (e.isShiftDown()){
				repaint();
			}
		}
		public void mouseReleased(MouseEvent e) {			}
	}
}
