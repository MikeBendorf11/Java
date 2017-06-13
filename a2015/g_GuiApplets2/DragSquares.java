package g_GuiApplets2;
import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

public class DragSquares extends JApplet 
implements MouseListener, MouseMotionListener{
	Display surface;
	int x=20; int y=20; // fixed red square parameters
	int x2,y2,x3,y3;	// red square variables
	
	int a=60; int b=20; // fixed blue square parameters
	
	Boolean isRselected = false;
	Boolean isBselected = false;
	
	public void init(){
		surface=new Display();
		setContentPane(surface);
		surface.addMouseListener(this);
		surface.addMouseMotionListener(this);
	}
	public class Display extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);	
			setBackground(Color.getHSBColor(0.5f,0.3f,0.6f));
			g.setColor(Color.RED);
			g.fillRect(x,y,30,30);
			g.setColor(Color.BLUE);
			g.fillRect(a, b, 30, 30);
		}			
	}
	public void mouseClicked(MouseEvent e) {	}
	public void mouseEntered(MouseEvent e) {	}
	public void mouseExited(MouseEvent e) {		}
	public void mousePressed(MouseEvent e) {
		x2=e.getX();
		y2=e.getY();
			
		if (e.getX()>=x && e.getX()<=x+30
				&& e.getY()>y && e.getY()<=y+30){
			isRselected=true;	
			isBselected=false;
		}	
		if (e.getX()>=a && e.getX()<=a+30
				&& e.getY()>b && e.getY()<=b+30){
			isBselected=true;	
			isRselected=false;
		}	
	}
	public void mouseReleased(MouseEvent e) {	
		isRselected = false;
		isBselected = false;
	}
	public void mouseDragged(MouseEvent e) {
		
		if(isRselected){
			x3 = e.getX();
			y3 = e.getY();
			x=x+x3-x2;
			y=y+y3-y2;
			repaint();
			x2 = e.getX();
			y2 = e.getY();
		}
		if(isBselected){
			x3 = e.getX();
			y3 = e.getY();
			a=a+x3-x2;
			b=b+y3-y2;
			repaint();
			x2 = e.getX();
			y2 = e.getY();
		}
		
		
		
		
		
	}
	public void mouseMoved(MouseEvent e) {		}	
}
