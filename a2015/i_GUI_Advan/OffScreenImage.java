package i_GUI_Advan;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;


public class OffScreenImage extends JPanel{
	  /* Some variables used for double-buffering. */
	   
	   Image OSI;  // The off-screen image (created in paintComponent()).	   
	   int widthOfOSI, heightOfOSI; 
	    void checkOffScreenImage() {
	      
	      if (OSI == null || widthOfOSI != getSize().width 
	                                || heightOfOSI != getSize().height) {
	       
	          OSI = null;  // If OSI already exists, this frees up the memory.
	          widthOfOSI = getSize().width;
	          heightOfOSI = getSize().height;
	          OSI = createImage(widthOfOSI, heightOfOSI);
	          Graphics OSGr = OSI.getGraphics();
	          OSGr.setColor(getBackground()); 			// is this copying to OSR what it has been
	          												//already drawn
	         OSGr.fillRect(0, 0, widthOfOSI, heightOfOSI);
	         OSGr.dispose();  // Free operating system resources.
	       }
	    }

	    public void paintComponent(Graphics g) {
	        
	      checkOffScreenImage();
	      g.drawImage(OSI, 0, 0, null);  // Copy OSI onto the screen.

	         
	   }

}
