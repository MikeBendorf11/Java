package g_GuiApplets2;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Buttons extends JApplet 
implements MouseListener, FocusListener, KeyListener, ActionListener{
	Color color=Color.BLUE;;
	Display canvas, container;
	public void init(){
		canvas=new Display();
		getContentPane().add(canvas, BorderLayout.CENTER);
		
		container = new Display();
		getContentPane().add(container,BorderLayout.SOUTH);
		
		JButton redButton = new JButton("Red");
		container.add(redButton);
		redButton.addActionListener(this);
		
		JButton greenButton = new JButton("Green");
		container.add(greenButton);
		greenButton.addActionListener(this);
		
		JButton yellowButton = new JButton("Yellow");
		container.add(yellowButton);
		yellowButton.addActionListener(this);
		
		canvas.addMouseListener(this);
		canvas.addFocusListener(this);
		canvas.addKeyListener(this);
	}
	public class Display extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);	
			setBackground(Color.getHSBColor(0.7f,0.3f,0.6f));
			Font font = new Font("Serif",Font.BOLD,36);
			Font font2 = new Font("Verdana",Font.PLAIN,12);
			g.setFont(font);
			g.setColor(color);
			g.drawString("QuenTinPorta", 50, 100);
			g.setFont(font2);
			g.setColor(Color.BLACK);
			g.drawString("Click Here to Revert!!", 70,120);
		}			
	}
	public void mouseClicked(MouseEvent e) {	
	//  repaint(); HERE
	}
	public void mouseEntered(MouseEvent e) {	}
	public void mouseExited(MouseEvent e) {		}
	public void mousePressed(MouseEvent e) { 
		color = Color.BLUE;
		canvas.repaint();
		
	}
	public void mouseReleased(MouseEvent e) {	}
	public void focusGained(FocusEvent f) {		}
	public void focusLost(FocusEvent f) {	}
	public void keyPressed(KeyEvent k) {		}
	public void keyReleased(KeyEvent k) {	}
	public void keyTyped(KeyEvent k) {	}
	
	public void actionPerformed(ActionEvent a) {
		String command = a.getActionCommand();
		if (command.equals("Red"))color = Color.RED;
		if (command.equals("Green"))color = Color.GREEN;
		if (command.equals("Yellow"))color = Color.YELLOW;
		canvas.repaint();
		
	}
}
