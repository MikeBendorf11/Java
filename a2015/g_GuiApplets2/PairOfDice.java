package g_GuiApplets2;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class PairOfDice extends JApplet 
implements MouseListener, FocusListener, KeyListener, ActionListener{
	Display display;
	Boolean focussed=false;
	int oldDie1, oldDie2;
	Boolean reprintOldVals = false;
	
	public void init(){
		display=new Display();
		
		JPanel container = new JPanel();
		container.add(display);
		JButton bttn = new JButton("Roll");
		container.add(bttn);
		display.addMouseListener(this);
		display.addFocusListener(this);
		display.addKeyListener(this);
		bttn.addActionListener(this);
		getContentPane().add(display, BorderLayout.CENTER);
		getContentPane().add(bttn, BorderLayout.SOUTH);
	}
	public class Display extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);	
			setBackground(Color.getHSBColor(0.5f,0.3f,0.6f));
			
			if(focussed){
				g.setColor(Color.blue);
				g.drawRect(0,0,100,100);
			}
			int die1Val = (int)(Math.random()*6)+1;
			int die2Val = (int)(Math.random()*6)+1;
			if (!reprintOldVals){
				drawDie(g,die1Val,false);
				drawDie(g,die2Val,true);
				oldDie1=die1Val;
				oldDie2=die2Val;
			}
			else{
				drawDie(g,oldDie1,false);
				drawDie(g,oldDie2,true);
			}	
		}	
		void drawDie(Graphics g,int number, Boolean paintSecond){
						
			int dotDiameter = 7;
			int DistanceFromFirst = 0;
			int diceSize = 35;
			if (paintSecond)DistanceFromFirst = 40;
			
			g.setColor(Color.white);
			g.fillRoundRect(10+DistanceFromFirst, 10+DistanceFromFirst, diceSize, diceSize, 5, 5);
			g.setColor(Color.DARK_GRAY);
			
			switch (number){
			case 1:
				g.fillOval(23+DistanceFromFirst, 23+DistanceFromFirst, dotDiameter,dotDiameter);
				break;
			case 2:
				g.fillOval(31+DistanceFromFirst, 17+DistanceFromFirst, dotDiameter,dotDiameter); 
				g.fillOval(17+DistanceFromFirst, 31+DistanceFromFirst, dotDiameter,dotDiameter);
				break;
			case 3:
				g.fillOval(14+DistanceFromFirst, 14+DistanceFromFirst, dotDiameter,dotDiameter);
				g.fillOval(23+DistanceFromFirst, 23+DistanceFromFirst, dotDiameter,dotDiameter);
				g.fillOval(32+DistanceFromFirst, 32+DistanceFromFirst, dotDiameter,dotDiameter);
				break;
			case 4:
				g.fillOval(17+DistanceFromFirst, 17+DistanceFromFirst, dotDiameter,dotDiameter); 
				g.fillOval(31+DistanceFromFirst, 17+DistanceFromFirst, dotDiameter,dotDiameter); 
				g.fillOval(17+DistanceFromFirst, 31+DistanceFromFirst, dotDiameter,dotDiameter);
				g.fillOval(31+DistanceFromFirst, 31+DistanceFromFirst, dotDiameter,dotDiameter);
				break;
			case 5:
				g.fillOval(14+DistanceFromFirst, 14+DistanceFromFirst, dotDiameter,dotDiameter);
				g.fillOval(32+DistanceFromFirst, 14+DistanceFromFirst, dotDiameter,dotDiameter);
				g.fillOval(23+DistanceFromFirst, 23+DistanceFromFirst, dotDiameter,dotDiameter);
				g.fillOval(32+DistanceFromFirst, 32+DistanceFromFirst, dotDiameter,dotDiameter);
				g.fillOval(14+DistanceFromFirst, 32+DistanceFromFirst, dotDiameter,dotDiameter);
				break;
			default :
				g.fillOval(14+DistanceFromFirst, 17+DistanceFromFirst, dotDiameter,dotDiameter); 
				g.fillOval(24+DistanceFromFirst, 17+DistanceFromFirst, dotDiameter,dotDiameter); 
				g.fillOval(14+DistanceFromFirst, 31+DistanceFromFirst, dotDiameter,dotDiameter);
				g.fillOval(24+DistanceFromFirst, 31+DistanceFromFirst, dotDiameter,dotDiameter);
				g.fillOval(34+DistanceFromFirst, 17+DistanceFromFirst, dotDiameter,dotDiameter);
				g.fillOval(34+DistanceFromFirst, 31+DistanceFromFirst, dotDiameter,dotDiameter);
				break;
			}	
		}
	}
	public void mouseClicked(MouseEvent e) {	}
	public void mouseEntered(MouseEvent e) {	}
	public void mouseExited(MouseEvent e) {	}
	public void mousePressed(MouseEvent e) { 
		display.requestFocus();
		display.repaint();	
		}
	public void mouseReleased(MouseEvent e) {	}
	public void focusGained(FocusEvent f) {
		focussed = true;
		reprintOldVals=false;
		display.repaint();
	}
	public void focusLost(FocusEvent f) {
		focussed = false;
		reprintOldVals=true;
		display.repaint();
	}
	public void keyPressed(KeyEvent k) {
		display.repaint();
	}
	public void keyReleased(KeyEvent k) {
	}
	public void keyTyped(KeyEvent k) {
	}
	public void actionPerformed(ActionEvent evt) { 
		display.requestFocus();
		focussed = true;
		display.repaint();	}// button action
	
}
