package g_GuiApplets2;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class moveSquare extends JApplet 
                  implements KeyListener, FocusListener, MouseListener {
 DisplayPanel canvas;          
 int x,y;
   public void init() {          
      canvas = new DisplayPanel(); 
      setContentPane(canvas);     
      canvas.setBackground(Color.white);  
      canvas.addFocusListener(this);   
      canvas.addKeyListener(this);     
      canvas.addMouseListener(this);     
   }   
   class DisplayPanel extends JPanel {           
      public void paintComponent(Graphics g) {      
         super.paintComponent(g);      
         g.setColor(Color.RED);
			g.drawRect(x+100, y+100, 20, 20);
         }
      }             
   public void focusGained(FocusEvent evt) {      }
   public void focusLost(FocusEvent evt) {      }      
   public void keyTyped(KeyEvent k) {        }       
   public void keyPressed(KeyEvent k) {     
	   int key = k.getKeyCode(); // key code can be just one key at a time
		if (key==KeyEvent.VK_UP){
			y-=8;
			canvas.repaint();
		}
		if (key==KeyEvent.VK_DOWN){
			y+=8;
			canvas.repaint();
		}
		if (key==KeyEvent.VK_LEFT){
			x-=8;
			canvas.repaint();
		}
		if (key==KeyEvent.VK_RIGHT){
			x+=8;
			canvas.repaint();
		}
   }  
   public void keyReleased(KeyEvent evt) {     }  
   public void mousePressed(MouseEvent evt) {   
	   canvas.requestFocus();
   }   
   public void mouseEntered(MouseEvent evt) { }  
   public void mouseExited(MouseEvent evt) { } 
   public void mouseReleased(MouseEvent evt) { } 
   public void mouseClicked(MouseEvent evt) { }


}