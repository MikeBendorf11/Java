package i_GUI_Advan;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.event.*;


public class RGBcomponent extends JPanel implements ChangeListener {
	 JSlider redSlider, greenSlider, blueSlider;   
	 JLabel redLabel, greenLabel, blueLabel;  
	 JPanel colorPatch;  
	 int r,g,b;
	 public RGBcomponent(){
		  
	       redSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
	       redSlider.addChangeListener(this);
	       
	       greenSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
	       greenSlider.addChangeListener(this);
	       
	       blueSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
	       blueSlider.addChangeListener(this);
	       
	       redLabel = new JLabel(" R = 0");
	       redLabel.setBackground(Color.white);
	       redLabel.setForeground(Color.red);
	       redLabel.setOpaque(true);
	       
	       greenLabel = new JLabel(" G = 0");
	       greenLabel.setBackground(Color.white);
	       greenLabel.setForeground(new Color(0,150,0));
	       greenLabel.setOpaque(true);
	       
	       blueLabel = new JLabel(" B = 0");
	       blueLabel.setBackground(Color.white);
	       blueLabel.setForeground(Color.blue);
	       blueLabel.setOpaque(true);
	   
	       colorPatch = new JPanel();
	       colorPatch.setBackground(Color.black);
	       
	       JPanel scrolls = new JPanel();
	       scrolls.setLayout(new GridLayout(3,1,2,2));
	       scrolls.setBackground(Color.gray);
	       scrolls.add(redSlider);
	       scrolls.add(greenSlider);
	       scrolls.add(blueSlider);
	       
	       JPanel labels = new JPanel();
	       labels.setBackground(Color.gray);
	       labels.setLayout(new GridLayout(3,1,2,2));
	       labels.add(redLabel);
	       labels.add(greenLabel);
	       labels.add(blueLabel);
	       
	       setBackground(Color.gray);
           setBorder( BorderFactory.createEmptyBorder(3,3,3,3) );	       
	       setLayout(new GridLayout(1,3,3,3));
	       add(scrolls);
	       add(labels);
	       add(colorPatch);	       
	       setPreferredSize( new Dimension(280,80) );

	  }
	public void stateChanged(ChangeEvent e) {
		   r = redSlider.getValue();
	       g = greenSlider.getValue();
	       b = blueSlider.getValue();
	       redLabel.setText(" R = " + r);
	       greenLabel.setText(" G = " + g);
	       blueLabel.setText(" B = " + b);
	       colorPatch.setBackground(new Color(r,g,b));
	}
	 /*public int getRed(){ // this would be useful for geting the 
		  return r;
	 }
	 public int getGreen(){
		  return g;
	 }
	 public int getBlue(){
		  return b;
	 }*/
	public Color getColor(){
		Color c = new Color(r,g,b);
		return c;
		/*textbook proposal
		 *      return selectedColor;
		 * */
	}
	
	public void setColor(int r, int g, int b){
		redSlider.setValue(r);
		greenSlider.setValue(g);
		blueSlider.setValue(b);
		redLabel.setText(" R = " + r);
	    greenLabel.setText(" G = " + g);
	    blueLabel.setText(" B = " + b);
	    colorPatch.setBackground(new Color(r,g,b));
	    /*textbook proposal
	     * selectedColor = c;  Remember the selectedcolor
			my proposal says the value of variable rgb can be tracked on
			the next time the aplet is run
	     * */
	}
}
