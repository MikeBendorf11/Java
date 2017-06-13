package i_GUI_Advan;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JApplet;
import javax.swing.*;
	 

public class WordExtractGUI extends JApplet implements ActionListener {
	JTextArea textArea;
	JLabel nLines, nWords, nLetters;
	
	public void init(){
		Container contenido = getContentPane();
		textArea = new JTextArea(50,8);
		JScrollPane scroller = new JScrollPane(textArea);
	
		JPanel panel2 = new JPanel();		
		panel2.setLayout(new GridLayout(4,1,3,3));
		JButton process = new JButton("Process the Text");
		process.addActionListener(this);
		panel2.add(process);
		nLines = new JLabel("Number of Lines: 0");
		panel2.add(nLines);
		nWords = new JLabel("Number of Words: 0");
		panel2.add(nWords);
		nLetters = new JLabel("Number of Characters: 0");
		panel2.add(nLetters);
		//
		
		JMenuItem rect = new JMenuItem("Rectangle");
        rect.setAccelerator( KeyStroke.getKeyStroke("ctrl R") );
        
        //
		contenido.setLayout(new GridLayout(2,1,3,3));
		contenido.add(scroller);
		contenido.add(panel2);
		
	}
	public void actionPerformed(ActionEvent e) {
		// every letter that comes after a space is considered a word
		// have two variables one previous (starts at 0)and one next (starts at one)
		String command = e.getActionCommand();
			
		if (command.equals("Process the Text")){
			String toAnalize = textArea.getText();
			int prevPos, nextPos, wordCount, lineCount;
			char prevChar, nextChar;
			
			if (toAnalize.isEmpty()){
				nLines.setText("Number of Lines: 0" );
				nWords.setText("Number of Words: 0" );
				nLetters.setText("Number of Letters: 0");	
				return;
			}
			for (wordCount=0,prevPos=0,lineCount=1,nextPos=1; nextPos<toAnalize.length(); prevPos++,nextPos++){
				prevChar = toAnalize.charAt(prevPos);
				nextChar = toAnalize.charAt(nextPos);	
				
				/*check for the first letter, if so considers it a word*/
				if (prevPos==0){
					if (Character.isLetter(prevChar)){
						wordCount++;
					}
				}
				/* Any character preceded by a space or a \n is considered a word
				 * Boolean algebra rules needed the parenthesis 
				 * A and (B or C) = (A and B) or (A and C)
				 * A  *  (B  + C) = (A   * B)  + (A  *  C)*/
				else if (Character.isLetter(nextChar) && ( prevChar==' ' ||  prevChar=='\n' )){ 
					wordCount++;
				}	
				else if (nextChar=='\n'){
					lineCount++;
				}
			}
			nLines.setText("Number of Lines: " + lineCount );
			nWords.setText("Number of Words: " + wordCount );
			nLetters.setText("Number of Characters: " + (toAnalize.length()- lineCount));	
		}
	}
}
