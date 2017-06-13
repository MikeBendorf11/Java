package j_Arrays;
/*can implement an array of coincidence cases ex oneCoinc
 * an can use program on an app with an slider to see a graph
 * of random variation
 * GRAPH should be number of coincidences against number of hits*/
import java.util.Random;

public class birthdayGuessMod {

public static void main(String[]args){

	int scan=1;
	while(scan>0){
		System.out.println("\n---------------------------------------------\n");
		System.out.println("1. For SN between 200 to 250 " +
				"at least one three birthday coincidence\n"+
				"2. For a SN of DAY_YEAR you get from 100 to "+
				"a 150 birthdays with no coincidence\n"+
				"3. For an SN of more than 1750 there are coincidences "+
				"for all DAY_YEAR possibilities");
		System.out.println("\nChoose the number of people you " +
		"want to count birthdays from: ");
		int DAYS_YEAR = 365;
		scan = TextIO.getInt();
		final int N_PERSONS = scan;
		
		int []possibleBirthdays =new int[DAYS_YEAR];
		int[]nHits = new int[DAYS_YEAR]; // birthday hits
		int []sampling = new int[N_PERSONS]; // n of persons
		int[]nCoincidences = new int[DAYS_YEAR]; // theoretically
			
		int unAssigned=0, totalNoCoinc = 0, totalWithCoinc=0;
		
		for (int i=1;i<=DAYS_YEAR;i++){ 		// possible birthdays
			possibleBirthdays[i-1]=i;
		}
		
		// assign a birthday to every individual of the sampling
		for (int i=0;i<N_PERSONS;i++){		
			int randBirth = (int)((Math.random()*DAYS_YEAR)+1);
			sampling[i]= randBirth;
			//System.out.println("Birthday generated N"+i+"= "+ person[i]);
		}
		/*j would switch the possible birthDays and sampling*/
		for (int j=0;j<DAYS_YEAR;j++){ 	
			for(int k=0;k<N_PERSONS;k++){	// scanning the all records
				if (possibleBirthdays[j]==sampling[k]){
					nHits[j]++;
				}
			}
			if (nHits[j]>1){
				totalWithCoinc++;
			}
			if (nHits[j]==0){
				unAssigned++;		
			}
			if (nHits[j]==1){
				totalNoCoinc++;		
			}
			// loop for up to 365 theoretical number of Coincidences for 
			// every birthday hit1
			for(int m=1;m<=DAYS_YEAR;m++){
				if (nHits[j]==(m+1)){
					nCoincidences[m-1]++;
				}
			}		
		}
		System.out.println("\n---------------------------------------------\n");
		System.out.println("Sampling number: " + N_PERSONS);
		System.out.println(unAssigned +" days nobody was born" );
		System.out.println(totalNoCoinc +" birthdays with no coincidence" );
		System.out.println(totalWithCoinc +" birthdays with coincidence" );
		System.out.println("\nAND FROM THOSE WE HAVE:" );
		
		for(int p=0;p<DAYS_YEAR;p++){//scroll through number of coincidences per day
			if (nCoincidences[p]>0){
				System.out.println(nCoincidences[p] +" birthdays with "+ (p+1) 
						+" coincidence(s)" );
				
			}
		}	
	
	}
		
	System.exit(0);	
	}// end of main
}
/* from results we can see that SEVERAL birthdays can have 1 or 
 * more coincidences, whiting them you could find which birthday
 * */

