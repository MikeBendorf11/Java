package i_GUI_Advan;

/*
   A RGBColorChooser shows three sliders that the user can manipulate
   to set the red, green, and blue, components of a color.  A color patch
   shows the selected color, and there are three labels that show the numerical
   values of all the components.  Values are in the range 0 to 255.
   The initial color is black.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class RGBColorChooser extends JApplet 
                       implements ChangeListener {
   
    JSlider redSlider, greenSlider, blueSlider;   
              // For setting the color.
   
    JLabel redLabel, greenLabel, blueLabel;  
              // For displaying RGB values.
                 
    JPanel colorPatch;  
              // Color patch for displaying the color.
                 

   public void init() {
   
       /* Create JSliders with possible values from 0 to 255. */
       
       redSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
       redSlider.addChangeListener(this);
       
       greenSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
       greenSlider.addChangeListener(this);
       
       blueSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
       blueSlider.addChangeListener(this);
       
       
       /* Create JLabels showing current RGB and HSB values. */
       
       
       
   
       
       /* Set the colors of the labels, and make them opaque */
       
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
       
       /* Set the applet to listen for changes to the JSliders' values */
       
     
       
       
       
       /* Create a JPanel whose background color will always be set to the
          currently selected color.  Otherwise, the panel is empty. */
       
       colorPatch = new JPanel();
       colorPatch.setBackground(Color.black);
       
       /* Create the applet layout, which consists of a row of
          three equal-sized regions holding the JSliders,
          the Labels, and the color patch.  The background color
          of the applet is gray, which will show around the edges
          and between components. */
       
      
       
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
       getContentPane().setBackground(Color.gray);
       getContentPane().setLayout(new GridLayout(1,3,3,3));
       getContentPane().add(scrolls);
       getContentPane().add(labels);
       getContentPane().add(colorPatch);
       
       /* Add the JSliders and the JLabels to their respective panels. */
       
       
       
       
   } // end init();
   

   public void stateChanged(ChangeEvent evt) {
           // This is called when the user has changed the value on
           // one of the sliders.  All the sliders are checked,
           // the labels are set to display the correct values,
           // and the color patch is set to correspond to the new color.
       int r = redSlider.getValue();
       int g = greenSlider.getValue();
       int b = blueSlider.getValue();
       redLabel.setText(" R = " + r);
       greenLabel.setText(" G = " + g);
       blueLabel.setText(" B = " + b);
       colorPatch.setBackground(new Color(r,g,b));
   } // end stateChanged

   
   public Insets getInsets() {
          // The system calls this method to find out how much space to
          // leave between the edges of the applet and the components that
          // it contains.  I want a 3-pixel border at each edge.
      return new Insets(3,3,3,3);
   }
   
}  // end class RGBColorChooser