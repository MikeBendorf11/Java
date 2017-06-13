package j_Arrays;
/*
   This program demonstates using a "dynamic array class" by reading
   in any number positive integers from the user and printing them in
   reverse order.  Input ends when the user enters a non-positive integer.
*/

public class AdynArrayTTest {

   public static void main(String[] args) {
  
      ADynamicArrayOfInt dynArrObj;  // To hold the input numbers.
                                  //   This dynamic array can expand
                                  //   to any size.
                                  
      int numCt;  // The number of numbers stored in the array.

      int num;    // One of the numbers input by the user.
    
      dynArrObj = new ADynamicArrayOfInt();

      numCt = 0;
    
      TextIO.putln("Enter some positive integers; Enter 0 to end");
    
      while (true) {  // Get numbers and put them in the dyamic array.
         TextIO.put("? ");
         num = TextIO.getlnInt();
         if (num <= 0)
            break;
         dynArrObj.put(numCt, num);  // Store num in the array.
         numCt++;
      }
    
      TextIO.putln("\nYour numbers in reverse order are:\n");
    
      for (int i = numCt - 1; i >= 0; i--) {
          TextIO.putln( dynArrObj.get(i) );  // Get i-th number from array.
      }
    
   } // end main();
  
}  // end class ReverseWithDynamicArray