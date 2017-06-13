package g_GuiApplets1;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Drawing extends JApplet implements MouseListener, MouseMotionListener{
	int prevX,prevY,newX,newY;
	ASD asd;
	Boolean isDragging = false;
	public void init(){
		asd = new ASD();
		setContentPane(asd);
		asd.addMouseMotionListener(this);
		asd.addMouseListener(this);
	}
	public class ASD extends JPanel {
		public void paintComponent(Graphics g){
			super.paintComponent(g);	
			setBackground(Color.black);	
		}	
	}
	public void mouseDragged(MouseEvent e) {	
		if (!isDragging)return;
		newX = e.getX();
		newY = e.getY();
		Graphics j = getGraphics();
		j.setColor(Color.yellow);
		j.drawLine(prevX, prevY, newX, newY);
		prevX = e.getX();
		prevY = e.getY();
	}
	public void mouseMoved(MouseEvent e) {	}
	public void mouseClicked(MouseEvent e) {	}
	public void mouseEntered(MouseEvent e) {	}
	public void mouseExited(MouseEvent e) {	}
	public void mousePressed(MouseEvent e) {
		isDragging=true;
		prevX=e.getX();
		prevY=e.getY();
		if (e.isMetaDown())
			repaint();
	}
	
	public void mouseReleased(MouseEvent e) {
	
	}
}
