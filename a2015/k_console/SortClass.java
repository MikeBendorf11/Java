package k_console;

class SortClass {
	int [] array1;
	int [] array2 ;
	int temp[];
	
	void loadArray(int array){ // array choice method
		if (array==1){
			 temp = array1;
		}else temp = array2;
	}
	
	void changeArray(int array){ // array replacement choice method
		 if (array==1){
			 array1=temp;
		}else array2=temp;	
	}
	
	// find a num on the specified array
	int find(int array, int number) {
		loadArray(array);	
	
	int b = -1; 
	for (int i = 0;i<temp.length;i++){
		if (temp[i]==number)return number;		
		}
		return b;		
		}
	
	
	// insert a num on specified position and array
	 void insert (int array, int num, int position ){
	
		loadArray(array);	
		int[] temp2 = new int[temp.length+1];
		 System.arraycopy(temp, 0, temp2, 0, position-1);
		 temp2[position-1]=num;
		 System.arraycopy(temp, position-1, temp2, 
				 position, (temp.length-position+1));
		 temp=temp2;
		 changeArray(array);
		
	 }
	 //DELETE
	 void delete(int array, int position ){
	loadArray(array);
			
		int[] temp2 = new int[temp.length-1];
		System.arraycopy(temp,0,temp2,0,position-1);
		System.arraycopy(temp,position,temp2,position-1,(temp2.length-position+1));
		temp=temp2;

		
		changeArray(array);
	 }
	 
	 // asc, dsc, rnd
	 void sort (int array, String direction){ 
		 loadArray(array);	
		 if (direction.equals("dsc")){
			 /*1.1, 1.2, 1.3; 2.1, 2.2, 2.3*/
			for(int posicionEje=0;posicionEje<temp.length;posicionEje++){
				for(int rotativa=0;rotativa<temp.length;rotativa++){
					if (temp[rotativa]<temp[posicionEje]){
						int m = temp[rotativa];
						temp[rotativa]=temp[posicionEje];
						temp[posicionEje]=m;
						posicionEje--;
						break;
					}
				}
			}			
		 }
		 else if(direction.equals("asc")){
			 for(int ps=0;ps<temp.length;ps++){
				 for(int sw=0;sw<temp.length;sw++){
						if (temp[sw]>temp[ps]){
							int m = temp[sw];
							temp[sw]=temp[ps];
							temp[ps]=m;
							ps--;
							break;
						}
					}		
				}
		 	}
		 else if(direction.equals("rnd")){ // random order
			 int[]rndArray= new int[(temp.length)]; // array of random positions
			 int[]temp2=new int[temp.length];
			 
			 for (int i=0; i<temp.length;i++){
				 /*each array position on rndArray will be assigned a 
				  * random number */
				 rndArray[i]=(int)(Math.random()*(temp.length));
				 for (int j=0;j<i;j++){ // evaluate positions created so far
				  /* if the guessed number repeats var i will go one
				   * step back and repeat the previous process*/
					 if (rndArray[i]==rndArray[j]){
						 i--;
						 break;						
					 }
				 }// ends evaluating all combinations
			 }// ends creating rands
			 
			 for(int i=0;i<temp.length;i++){ 
				 /*the organized values of temp 1 are going to 
				  * be assigned to random locations of temp2 based
				  * on the random positions of rndArray*/
				 temp2[rndArray[i]]=temp[i];
			 }
			 temp=temp2;
		 }
		changeArray(array);
	 }
}
