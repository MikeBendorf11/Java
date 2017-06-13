package g_GuiApplets2;
import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

/*I mistakenly used the Keyboard animation Applet as extender instead of
 * the SimpleAnimationApplet. I didn't now I had to implement mouseListener 
 * despite the Parent Class had it already.*/
public class JumpingSquare extends KeyboardAnimationApplet2 implements MouseListener {

	 public void init(){
		 x=getSize().width/2;y=getSize().height/2;
		 switchHor=false; // booleans had to be initialized to false else crash
		 switchVer=false;
		 addMouseListener(this);
	 }
	 /*This method is part of the paintComponent of the parent class
	  * so here is considered to be overridden*/
	public void drawFrame(Graphics g, int width, int height) {
		
		 g.setColor(Color.getHSBColor(20, 30, 50));
	     g.fillRect(0,0,width,height);
	     g.setColor(Color.black);
	     //super.drawFrame(g,width,height);  // added to have the time counter from parent
	     Font font = new Font("Arial", Font.PLAIN, 14);
		 g.setFont(font);
		 g.drawString("Points: "+ busted, 20, 20);  
	     g.drawString("Level: "+ speed, 20, 40); 
	     doSquareFrame(g,width,height);
	        
	       if (busted>2)speed=2; // speed determines the amount we will add to the values 
	       if (busted>4)speed=3;	// of location x or y
	       if (busted>6)speed=4;
	       if (busted>8)speed=5;
	       if (busted>10)speed=6;
	       if (busted>12){
	    	   speed=0;
	    	   Font font2 = new Font("Arial", Font.BOLD, 14);
	 		   g.setFont(font2);
	    	   g.drawString("YOU WIN!!!", 75, 75);  
	       }
	 }
	 public void colorSwitch(){
		Color colorY= Color.yellow;
		Color colorR= Color.red;
		Color colorG= Color.green;
		Color colorB= Color.blue;
		int swCo = (int)(Math.random()*4);
			
		switch(swCo){
		case 0:
			changeable=colorR;return; // had to add return else it didn't work
		case 1:
			changeable=colorY;return;
		case 2:
			changeable=colorG;return;
		case 3:
			changeable=colorB;return;		
		}		
	 }
	 /*Had to use this instead of MousePressed because it was used by parent 
	  * class already SO I WAS OVERRIDING IT, and window activation didn't work 
	  * . Disadvantage it marks two events every time you click, so 
	  * I transformed the points collector variable busted into a double VAR so it will
	  * be able to count to one every two events. Mouse clicked was two slow*/
	 public void mouseReleased(MouseEvent e) {
		 //super.mousePressed(e); But if I do this It fixed it
		 int locX = e.getX();
		 int locY = e.getY();
		if (locX>x&&locX<x+25){
			if(locY>y&&locY<y+25){
				busted+=0.5;
				colorSwitch();
			}
		}
	 }
	int x,y;
	double busted;
	Boolean switchHor, switchVer;
	int speed = 1;
	Color changeable;
	 
	/*There was a problem with the square going off the canvas. The barrier region had to be
	 * increased. width-30 and height-30 represent a big frame where the random Switch
	 * direction wouldnt take effect. . Also*/
	 void doSquareFrame(Graphics g, int width, int height){
		if (Math.random()<0.05 && x>10 && x<width-30 && y>10 && y<height-30){
			switchHor=!switchHor;
		}
		if (Math.random()<0.05 && x>10 && x<width-100 && y>30 && y<height-30){
			switchVer=!switchVer;
		}	
		/*This where the initial non-randomic bouncing parameters. They have some 
		 * precautionary measures to avoid the square going out of the applet. 
		 * Equal to or less than X will not happen because direction will switch*/
		if (!switchHor){	//right
			x+=speed;
			if (x>=width-25){
				switchHor=true;		
			}
		}
		if(switchHor){		//left
			x-=speed;
			if (x<=0){
				switchHor=false;	
			}
		}
		if (!switchVer){	//up
			y+=speed;
			if (y>=height-25){
				switchVer=true;		
			}
		}
		if(switchVer){		//down
			y-=speed;
			if (y<=0){
				switchVer=false;	
			}
		}
		 g.setColor(changeable);		
		 g.fillRect(x,y,25,25);
		 g.setColor(Color.black); 
		 g.drawRect(x-2,y-2,28,28);	  
	 }
	
}
