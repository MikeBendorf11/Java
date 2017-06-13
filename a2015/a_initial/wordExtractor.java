package a_initial;
import java.util.Scanner; 

public class wordExtractor{
     public static void main(String []args)
{

     String[]word = new String[100];
                Scanner scan = new Scanner(System.in);
                System.out.println("Enter a sentence: ");
                String sentence = scan.nextLine();
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
            System.out.println("Word " + space + " = " + word[space]);
            position = 0;
            }
            
     }
space++;
word[space]= sentence;

 System.out.println("Word " + space + " = " + word[space]);    
}
}
