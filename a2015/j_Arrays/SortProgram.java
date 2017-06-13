package j_Arrays;

public class SortProgram {
	
	public static void main(String[]args){
		
		SortClass SortClassObj = new SortClass();
		SortClassObj.array1= new int []{23,15,5,21,0,5,22,10,3,7,8,9,12,11};
		SortClassObj.array2 = new int[]{5,4,3,7,6,11,12,19,21,18,8,9,0,15};
		while(true){
			
			// Print array values
			 System.out.print("-------------------------------------------------\n");
			 System.out.print("array1 = {");
			 for(int i =0; i<SortClassObj.array1.length;i++){
				 if (i<(SortClassObj.array1.length-1))
				 System.out.print(SortClassObj.array1[i]+",");
				 else System.out.print(SortClassObj.array1[i]);
			 }
			 System.out.println("}");
			 System.out.print("array2 = {");
			 for(int i =0; i<SortClassObj.array2.length;i++){
				 if (i<(SortClassObj.array2.length-1))
				 System.out.print(SortClassObj.array2[i]+",");
				 else System.out.print(SortClassObj.array2[i]);
			 }	
			 System.out.println("}\n");						 
			 System.out.println("Select the task:\n" +
			 		" (1)Insert	(2)Delete	(3)Find		(4) Sort" );
			 int input1 = TextIO.getInt();
			
			
			 // INSERT
			if (input1==1){
				 System.out.println("Which Array (1 or 2)?" );
				 int array = TextIO.getInt();
				 System.out.println("Number to insert?" );
				 int number = TextIO.getInt();
				 System.out.println("Place to insert?" );
				 int place = TextIO.getInt();
				 SortClassObj.insert(array, number, place);		
			}
			 // DELETE
			else if (input1==2){
				 System.out.println("Which Array (1 or 2)?" );
				 int array = TextIO.getInt();
				 System.out.println("Position to delete?" );
				 int position = TextIO.getInt();
				 SortClassObj.delete(array, position);	
			}
			
			// FIND
			else if (input1==3){ 
				System.out.println("Number to search?" );
			 	int number = TextIO.getInt();
			 	System.out.println("Which Array (1 or 2)?" );
			 	int array = TextIO.getInt();
			 	System.out.println("Found: " + (SortClassObj.find(array,number)) );	
			}
			// SORT
			else if (input1==4){
				System.out.println("Which direction (asc, dsc, rnd)?" );
				 String direction = TextIO.getlnWord();
				System.out.println("Which Array (1 or 2)?" );
				 int array = TextIO.getInt();
				 SortClassObj.sort(array, direction);	
			}
		}				
	 }
}
