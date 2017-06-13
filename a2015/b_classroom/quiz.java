package b_classroom;

public class quiz {

	public static void main(String[]args){
		AdditionQuestion [] preguntas = new AdditionQuestion[10];
		int []answers = new int [10];
		for (int i=0;i<10;i++){
			preguntas[i]= new AdditionQuestion();
		}
		Boolean itsOn = true;
		int count = 0;
		int correct = 0;
		int incorrect = 0;
		while(itsOn){
			TextIO.putln((count+1)+". "+preguntas[count].getQuestion());
			answers [count] = TextIO.getInt();
			if (preguntas[count].getCorrectAnswer()==answers [count]){
				correct++;
			}
			else{
				incorrect++;
			}
			count++;
			if (count==10){
				itsOn=false;
			}
		}
		TextIO.putln("Correct: "+correct + " Incorrect: " + incorrect); 
		count=0;
		for (count=0;count<10;count++){
			
			if (preguntas[count].getCorrectAnswer()==answers [count]){
				TextIO.putln((count+1)+". "+"Correct");
			}
			else{
				TextIO.putln((count+1)+". "+"Incorrect");
			}
		}
	}
}
