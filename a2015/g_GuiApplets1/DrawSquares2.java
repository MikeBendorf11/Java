package g_GuiApplets1;
import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

public class DrawSquares2 extends JApplet implements MouseListener{
	int x,y;
	QWE qwe;
	public void init(){
		qwe = new QWE();
		setContentPane(qwe);
		qwe.setBackground(Color.green);
		qwe.addMouseListener(this);	
	}
	public class QWE extends JPanel {
		public void paintComponent(Graphics k){
			super.paintComponent(k);
		}	
	}                                        
	public void mouseClicked(MouseEvent e) {	}
	public void mouseEntered(MouseEvent e) {	}
	public void mouseExited(MouseEvent e) {	}
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		Graphics h = getGraphics();
		if (e.isMetaDown()){
			h.setColor(Color.red);
			h.fillRoundRect(x, y, 100, 100, 50, 50);
		}
		else{
			h.setColor(Color.orange);
			h.fillRect(x, y, 100, 100);
		}
		if (e.isShiftDown()){
			repaint();
		}
	}
	public void mouseReleased(MouseEvent e) {	}
}
