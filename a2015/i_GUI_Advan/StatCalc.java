package i_GUI_Advan;
/** 
 * An object of class StatCalc can be used to compute several simple statistics
 * for a set of numbers.  Numbers are entered into the dataset using
 * the enter(double) method.  Methods are provided to return the following
 * statistics for the set of numbers that have been entered: The number
 * of items, the sum of the items, the average, and the standard deviation
 */

public class StatCalc {

     int count;   // Number of numbers that have been entered.
     double sum;  // The sum of all the items that have been entered.
     double squareSum;  // The sum of the squares of all the items.
     double max;
     double min;
    /**
     * Add a number to the dataset.  The statistics will be computed for all
     * the numbers that have been added to the dataset using this method.
     */
    public void enter(double num) {
        count++;
        sum += num;
        squareSum += num*num;
        
        double sofar=num;	// this var will store the last value entered by user
        if (sofar>max){		
        	max=num;		// stores the max val entered so far
        }
        if (count==1){		// executes one time because count will be 1 only one time
        	min=sofar;		// uses this excuse to asing the first value entered to the min so far var
        }
        if (sofar<min&&sofar!=0){ 
        	min=sofar;	  	// store the min val entered so far
        }
    }

    /**
     * Return the number of items that have been entered into the dataset.
     */
    public int getCount() {
        return count;
    }

    /**
     * Return the sum of all the numbers that have been entered.
     */
    public double getSum() {
        return sum;
    }

    /**
     * Return the average of all the items that have been entered.
     * The return value is Double.NaN if no numbers have been entered.
     */
    public double getMean() {
        return sum / count;  
    }
    public double getMax(){
    	return max; 
    }
    public double getMin(){
    	return min; 
    }
    /**
     * Return the standard deviation of all the items that have been entered.
     * The return value is Double.NaN if no numbers have been entered.
     */
    public double getStandardDeviation() {  
        double mean = getMean();
        return Math.sqrt( squareSum/count - mean*mean );
    }

}  // end class StatCalc