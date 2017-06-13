package a_initial;

public class capitalized {
	static String sentence; 
	public static void main(String[]args){
		TextIO.put("Enter a sentence I will capitalize it: ");
		sentence = TextIO.getln();
		printCapitalized();
	}
	public static void printCapitalized(){
		int charPosition=0;
		char scan = sentence.charAt(charPosition);
		TextIO.put(Character.toUpperCase(scan));
		for (charPosition=1;charPosition<sentence.length();charPosition++)
		{
			scan = sentence.charAt(charPosition);
			if (scan==(' ')){
				TextIO.put(scan);
				charPosition ++;
				scan = sentence.charAt(charPosition);
				if (scan==(' ')){						// scans for additional space to ignore it
					charPosition ++;
					scan = sentence.charAt(charPosition);
					if (scan==(' ')){						// scans for additional space to ignore it
						charPosition ++;
						scan = sentence.charAt(charPosition);
						if (scan==(' ')){						// scans for additional space to ignore it
							charPosition ++;					// QUICK AND DIRTY
							scan = sentence.charAt(charPosition);
							}
						}
					}
				TextIO.put(Character.toUpperCase(scan)); // changes to uppercase after finding first space
				}	
			else {
				TextIO.put(scan);
				}
				
				
			}
		}
	}
