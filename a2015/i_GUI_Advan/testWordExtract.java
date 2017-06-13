package i_GUI_Advan;

public class testWordExtract {
	public static void main(String[]args){
		String toAnalize = "veamos que pasa ";
		int prevPos, nextPos, wordCount, lineCount;
		char prevChar, nextChar;
		
		for (wordCount=0,prevPos=0,lineCount=0,nextPos=1;nextPos<toAnalize.length();prevPos++,nextPos++){
			prevChar = toAnalize.charAt(prevPos);
			nextChar = toAnalize.charAt(nextPos);	
			
			if (prevChar==0){
				if (Character.isLetter(prevChar)){
					wordCount++;
				}
			}
			else if (prevChar==' '||prevChar=='\n'&&Character.isLetter(nextChar)){
				wordCount++;
			}	
			else if (nextChar=='\n'){
				lineCount++;
			}
		}
		System.out.println("Number of Lines: " + lineCount );
		System.out.println("Number of Words: " + wordCount );
		System.out.println("Number of Lines: " + toAnalize.length());
		System.exit(0);
	}
}
