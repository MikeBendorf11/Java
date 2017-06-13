package a_ExceptionsCopy;
public class LengthConverter3 {

   /* 
      This program will convert measurements expressed in inches,
      feet, yards, or miles into each of the possible units of
      measure.  The measurement is input by the user, followed by
      the unit of measure.  For example:  "17 feet", "1 inch",
      "2.73 mi".  Several measurements can be combined on
      one line of input.  For example:  "2 miles 5 yards 1 inch".
      In this case, the measurements are combined into one total.
      Abbreviations in, ft, yd, and mi are accepted.  Negative 
      measurements are not allowed.
      
      The program will continue to read and convert measurements
      until the user enters an empty line.
      
      This version of the program uses exception handling.
   */
  



   public static void main(String[] args) {
   
      
      double measurement;  // Numerical measurement, input by user.
      String units;        // The unit of measure for the input, also
                           //    specified by the user.
      
      double inches, feet, yards, miles;  // Measurement expressed in each
                                          //   possible unit of measure.
      
      TextIO.putln("Enter measurements in inches, feet, yards, or miles.");
      TextIO.putln("For example:  1 inch    17 feet    2.73 miles");
      TextIO.putln("You can use abbreviations:   in   ft  yd   mi");
      TextIO.putln("I will convert your input into the other units of measure.");
      
      while (true) {
         
         /* Get the user's input, and convert it to inches. */
         
         TextIO.putln();
         TextIO.putln();
         TextIO.putln("Enter your measurement, or press return to end:");
         
         ParseError.skipBlanks();  
         
         if (TextIO.peek() == '\n')  // End if there is nothing on the line.
            break;
         
         try {
            inches = ParseError.readMeasurement();
         }
         catch (ParseError e) {
            TextIO.putln( "Error:  " + e.getMessage() );
            TextIO.getln();  // Discard the rest of the input line.
            continue;  // jump back to the start of the while loop
         }
         
         /* If we get to this point, we know that the user's input
            was legal and that the value of inches is valid. */
            
         /* Convert the measurement in inches to feet, yards, and miles. */
      
         feet = inches / 12;
         yards = inches / 36;
         miles = inches / (12*5280);
       
         /* Output the measurement in terms of each unit of measure. */
      
         TextIO.putln();
         TextIO.putln("That's equivalent to:");
         TextIO.put(inches, 15);
         TextIO.putln(" inches");
         TextIO.put(feet, 15);
         TextIO.putln(" feet");
         TextIO.put(yards, 15);
         TextIO.putln(" yards");
         TextIO.put(miles, 15);
         TextIO.putln(" miles");
            
         TextIO.getln();  // Discard the end-of-line character.
      
      } // end while
      
      TextIO.putln();
      TextIO.putln("OK!  Bye for now.");
      
   } // end main()
   
   

   
   
   
   

} // end class LengthConverter