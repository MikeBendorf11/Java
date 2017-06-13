package g_GuiApplets1;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class CursorTracker extends JApplet implements MouseMotionListener{
	int x,y;
	XYZ xyz;
	public void init(){
		xyz = new XYZ();
		setContentPane(xyz);
		xyz.setBackground(Color.white);
		xyz.addMouseMotionListener(this);	
	}
	public class XYZ extends JPanel {
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.setColor(Color.black);
			g.drawString("("+x+","+y+")",x,y);		
		}	
	}
	public void mouseDragged(MouseEvent e) {	}
	public void mouseMoved(MouseEvent e) {
		 x = e.getX();
		 y = e.getY();
		 repaint();
	}
}
