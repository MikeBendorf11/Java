package i_GUI_Advan;
import java.awt.*;

import javax.swing.JApplet;
import javax.swing.JPanel;

public class StopWatchTest extends JApplet{
	StopWatch watch;
	public void init(){
		watch = new StopWatch();
		JPanel loco = new JPanel();
		loco.setBackground(Color.red);
		setContentPane(loco);
		/*Whatever the component the contentPane is
		 * set to, will become like a centered background
		 * so if add the watch here I would have been centered*/ 
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(watch);
		/*watch here appears on top since its on flowlayout*/

	}	
}
