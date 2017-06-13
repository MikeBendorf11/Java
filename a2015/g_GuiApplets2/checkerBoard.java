package g_GuiApplets2;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class checkerBoard extends JApplet {
	Board board; 
	public void init(){
		board = new Board();
		setContentPane(board);
		addMouseListener(board); // if here then canvas2
	}
	class Board extends JPanel implements MouseListener{
		int x,y;
		Board(){
			setBackground(Color.black);
		      addMouseListener(this);
			// graphics methods here
		}
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			// draw colored checker board
			g.setColor(Color.RED);
			for (y=0;y<=140;y+=20){
				for (x=0;x<=120;x+=40){
					g.fillRect(x,y,20,20);
				}
				y+=20;
				for (x=20;x<=140;x+=40){
					g.fillRect(x,y,20,20);
				}
			}		
		}	
		public void mouseClicked(MouseEvent e) {	}
		public void mouseEntered(MouseEvent e) {	}
		public void mouseExited(MouseEvent e) {		}
		public void mousePressed(MouseEvent e) {
			board.repaint();	}
		public void mouseReleased(MouseEvent e) {			
			Graphics g = getGraphics();
			int corX = e.getX();
			int corY = e.getY();
			
			for (int locY=0;locY<=140;locY+=20){
				for (int locX=0;locX<=140;locX+=20){
					if (corX>locX && corX<locX+20 && corY>locY && corY<locY+20){
						g.setColor(Color.WHITE);
						g.drawRect(locX, locY, 20, 20);
						g.drawRect(locX-1, locY-1, 22, 22); // to make it look thicker
					}
				}
			}
		}		
	}// end of JPanel
}// end of JApplet
