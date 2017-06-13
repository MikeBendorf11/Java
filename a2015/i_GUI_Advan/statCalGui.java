package i_GUI_Advan;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class statCalGui extends JApplet implements ActionListener{
	StatCalc calc1 = new StatCalc();
	double userInput;
	JTextField dataField;
	JLabel entries, maxVal, minVal, deviation;
	JButton enterN, clearD;
	
	public void init(){
		Container contenido = getContentPane();
		setBackground(Color.gray);
		contenido.setBackground(Color.gray);
		
		enterN = new JButton("Enter");
		enterN.addActionListener(this);
	    rootPane.setDefaultButton(enterN);
		clearD = new JButton("Clear");
		clearD.addActionListener(this);
		dataField = new JTextField(30); 
		dataField.addActionListener(this);
		
		JPanel controlsContainer = new JPanel();
		controlsContainer.setLayout(new GridLayout(1,3,3,3));
		controlsContainer.add(dataField);
		controlsContainer.add(enterN);
		controlsContainer.add(clearD);
		
		JLabel title = new JLabel("Enter a number: ", JLabel.CENTER);
		title.setFont(new Font("SansSerif", Font.BOLD, 12));
		title.setForeground(Color.blue);
		title.setBackground(Color.lightGray);
		/*default transparent so the color of the Content Pane was
		 * passing through*/
		title.setOpaque(true); 
				
		JLabel entriesDescription = new JLabel("Number of Entries: ");		
		entriesDescription.setBackground(Color.black);
		entries = new JLabel("0");
		entries.setForeground(Color.black);
		
		JLabel maxValDescription = new JLabel("Maximun Value: ");		
		maxValDescription.setBackground(Color.black);
		maxVal = new JLabel("0.0");
		maxVal.setForeground(Color.black);
		
		JLabel minValDescription = new JLabel("Minimun Value: ");		
		minValDescription.setBackground(Color.black);
		minVal = new JLabel("0.0");
		minVal.setForeground(Color.black);
		
		JLabel deviatDescription = new JLabel("Standard deviation: ");		
		deviatDescription.setBackground(Color.black);
		deviation = new JLabel("0.0");
		deviation.setForeground(Color.black);
			
		JPanel dataContainer0 =  new JPanel();
		dataContainer0.setLayout(new GridLayout(1,2,3,3));
		dataContainer0.add(entriesDescription);
		dataContainer0.add(entries);
		
		JPanel dataContainer1 =  new JPanel();
		dataContainer1.setLayout(new GridLayout(1,2,3,3));
		dataContainer1.add(maxValDescription);
		dataContainer1.add(maxVal);
		
		JPanel dataContainer2 =  new JPanel();
		dataContainer2.setLayout(new GridLayout(1,2,3,3));
		dataContainer2.add(minValDescription);
		dataContainer2.add(minVal);
		
		JPanel dataContainer3 =  new JPanel();
		dataContainer3.setLayout(new GridLayout(1,2,3,3));
		dataContainer3.add(deviatDescription);
		dataContainer3.add(deviation);
		
		contenido.setLayout(new GridLayout(6,1,3,3));
		contenido.add(title);
		contenido.add(controlsContainer);
		contenido.add(dataContainer0);
		contenido.add(dataContainer1);
		contenido.add(dataContainer2);
		contenido.add(dataContainer3);
		
	}
	public void actionPerformed(ActionEvent evt) {
		String command = evt.getActionCommand();
		if (command.equals("Enter")){
			userInput = Double.parseDouble(dataField.getText());
			calc1.enter(userInput);
			entries.setText("" + calc1.getCount());
			maxVal.setText("" + calc1.getMax());
			minVal.setText("" + calc1.getMin());
			deviation.setText("" + calc1.getMean());
			
		}
		else if (command.equals("Clear")){
			entries.setText("0");
			maxVal.setText("0.0");
			minVal.setText("0.0");
			deviation.setText("0.0");
			calc1.count=0;
			calc1.max=0;
			calc1.min=0;
			calc1.sum=0;
			//resetear valores statCalc
			
		}
		else {
			/*Just by pressing the enter key while the textArea
			 * has gained focus an ActionEvent was generated*/
			userInput = Double.parseDouble(dataField.getText());
			calc1.enter(userInput);
			entries.setText("" + calc1.getCount());
			maxVal.setText("" + calc1.getMax());
			minVal.setText("" + calc1.getMin());
			deviation.setText("" + calc1.getMean());
		    dataField.selectAll();
		}
	}	
}
