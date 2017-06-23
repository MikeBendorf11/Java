package k_console;

public class SortProgram extends ConsoleApplet{
	
	protected String getTitle() {
	      return "Sample program \"Array Organizer\"";
	   }

	   protected void program() {
		Boolean proceed = true;
		SortClass SortClassObj = new SortClass();
		SortClassObj.array1= new int []{23,15,5,21,0,5,22,10,3,7,8,9,12,11};
		SortClassObj.array2 = new int[]{5,4,3,7,6,11,12,19,21,18,8,9,0,15};
		while(proceed){
			
			// Print array values
			 console.put("-------------------------------------------------\n");
			 console.put("array1 = {");
			 for(int i =0; i<SortClassObj.array1.length;i++){
				 if (i<(SortClassObj.array1.length-1))
					 console.put(SortClassObj.array1[i]+",");
				 else console.put(SortClassObj.array1[i]);
			 }
			 console.putln("}");
			 console.put("array2 = {");
			 for(int i =0; i<SortClassObj.array2.length;i++){
				 if (i<(SortClassObj.array2.length-1))
					 console.put(SortClassObj.array2[i]+",");
				 else console.put(SortClassObj.array2[i]);
			 }	
			 console.put("}\n");						 
			 console.putln("Select the task:\n" +
			 		" \n(1)Insert\n(2)Delete\n(3)Find\n(4)Sort" );
			 int input1 = console.getInt();
			
			
			 // INSERT
			if (input1==1){
				console.putln("Which Array (1 or 2)?" );
				 int array = console.getInt();
				 console.putln("Number to insert?" );
				 int number = console.getInt();
				 console.putln("Place to insert?" );
				 int place = console.getInt();
				 SortClassObj.insert(array, number, place);		
			}
			 // DELETE
			else if (input1==2){
				console.putln("Which Array (1 or 2)?" );
				 int array = console.getInt();
				 console.putln("Position to delete?" );
				 int position = console.getInt();
				 SortClassObj.delete(array, position);	
			}
			
			// FIND
			else if (input1==3){ 
				console.putln("Number to search?" );
			 	int number = console.getInt();
			 	console.putln("Which Array (1 or 2)?" );
			 	int array = console.getInt();
			 	console.putln("Found: " + (SortClassObj.find(array,number)) );	
			}
			// SORT
			else if (input1==4){
				console.putln("Which direction (asc, dsc, rnd)?" );
				 String direction = console.getlnWord();
				 console.putln("Which Array (1 or 2)?" );
				 int array = console.getInt();
				 SortClassObj.sort(array, direction);	
			}
		}				
	 }
}
