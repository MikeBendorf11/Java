package a_thisSuper;
// super.<variable_name> to invoke Parent class variable


class Parentclass4
{
	int num=100;
}
//Child class or subclass
class Subclass4 extends Parentclass4
{
    /* I am declaring the same variable 
     * num in child class too.
     */
    int num=110;
    void printNumber(){
 	System.out.println(num); // if changed to super.num then will print superclass num variable value
    }
    public static void main(String args[]){
       Subclass4 obj4= new Subclass4();
       obj4.printNumber();	
    }
}


/*Under normal conditions will print
 * 110
 * until we specify super.num on the print number method
 * 
 */