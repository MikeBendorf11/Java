package c_guiBasicMosaic;
public class snake{

static int rowN;
static int colN;
// arrays that keep track of the colored squares
static int []rowPrev=new int[20];
static int []colPrev=new int[20];
static int ranDir;
// counters for a longer or shorter queue
static int counter;
static int counterX;

public static void main(String[]args){
		Mosaic.open(20,20,20,20);
		while(Mosaic.isOpen()){
			// The animation will start every time at a different center
			rowN = (int) (Math.random()*20);
			colN =(int) (Math.random()*20);
			// Chooses a different direction from the 9 options 
			/* move down/right 		ranDir = 0
			 * move up/right		ranDir = 1
			 * just right			ranDir = 2
			 * move up/left			ranDir = 3
			 * move down/left		ranDir = 4
			 * just left			ranDir = 5
			 * just up				ranDir = 6
			 * just down			ranDir = 7 */
			ranDir = (int) (Math.random()*8);
			directions();
			counter=0; counterX=0; // this line was repeated on every if/for loop before
			}
		}
public static void rColor() { 
		int color1= (int) (Math.random()*255);
		int color2= (int) (Math.random()*255);
		int color3= (int) (Math.random()*255);
		
		Mosaic.delay(10);
		Mosaic.setColor(rowN,colN,color1,color2,color3);
		/* from here to the next section (directions) this section was included into every ranDir() loop
		 * I copied it here to have the code more organized but for that I needed to make counter and counterX
		 * static variables so they can be altered through the subroutines*/
		rowPrev[counter]=rowN; // populates the array with the actual rowN
		colPrev[counter]=colN; 
		counter++;
		/*This line will erase most of the tails, couldn't figure out a way to erase all of it*/
		if (counter>(int) (Math.random()*5)){
				Mosaic.setColor(rowPrev[counterX],colPrev[counterX],0,0,0);
				counterX++;
			}
		}
public static void directions(){	
		// down right
		if (ranDir==0){
			// here before  counter=0, counterX=0;
			for (;rowN<=19&&colN<=19;rowN++,colN++){
				rColor();
				}							
			}
		//up right
		else if (ranDir==1){
			for (;rowN>=0&&colN<=19;rowN--,colN++){
				rColor();
			}
		}
		// just right
		else if (ranDir==2){
			for (;colN<=19;colN++){
				rColor();
			}
		}
		// up left
		else if (ranDir==3){
			for (;rowN>=0&&colN>=0;rowN--,colN--){
				rColor();	
			}
		}
		// down left
		else if (ranDir==4){
			for (;rowN<=19&&colN>=0;rowN++,colN--){
				rColor();
			}
		}
		// just left
		else if (ranDir==5){
			for (;colN>=0;colN--){
				rColor();
			}
		}
		// just up
		else if (ranDir==6){
			for (;rowN>=0;rowN--){
				rColor();
			}
		}
		//just down
		else if (ranDir==7){
			for (;rowN<=19;rowN++){
				rColor();		
			}
		}
	}
}	