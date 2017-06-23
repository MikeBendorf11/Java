package k_console;
import java.util.Scanner; 

public class wordExtractor extends ConsoleApplet{
	 protected String getTitle() {
	      return "Sample program \"Word Extractor\"";
	   }

	   protected void program() {
		   while(true){
			     String[]word = new String[100];
	                
	                console.putln("Enter a sentence: ");
	                String sentence = console.getln();
	                   char ch = '?';
	                   int space = 0;
	     for (int position=0;position<sentence.length();position++)
	     {
	            ch = sentence.charAt(position);
	            if (ch == ' ')
	            {
	            space++;
	            word[space] = sentence.substring(0,position);
	            sentence = sentence.substring((position+1),sentence.length());
	           console.putln("Word " + space + " = " + word[space]);
	            position = 0;
	            }
	            
	     }
	space++;
	word[space]= sentence;

	 console.putln("Word " + space + " = " + word[space]+"\n");   
	 
		   }
 
}
}
