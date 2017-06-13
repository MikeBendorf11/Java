package a_initial;
import java.util.Random;

public class birthdayGuess {
public static void main(String[]args)
{
	Random generator = new Random();
	Boolean [] days = new Boolean[365];
	Boolean counting = true;
	int count = 0;
	int count2=0;
	int birthday;
	
	for (int i=0;i<365;i++){
		days[i]=false; 
	}
	while (counting){
		birthday = generator.nextInt(365);
		if (!days[birthday]){
			days [birthday] = true;
			count++;
			}
		else {
			System.out.println("We counted " + count + " people so far");
			System.out.println("People found with same birthday on day " + birthday + "\n");
			counting = false;
			}	
		}
	System.out.println("These are the random birthdays we simulated this time: ");
	for (int j=0;j<365;j++){
		if (days[j]){
			System.out.print("day " + j +" = " + days[j] + ", ");
			count2++;
			}
			
		if (count2 == 5){
			System.out.print("\n");
			count2 = 0;
			}
		}
	}
}

