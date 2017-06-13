package CstaticInstanceMethods;

public class CEmployeeDemo {
	public static void main(String[] args) {
		CEmployee e1 = new CEmployee("Lola","111111", 1900);
		CEmployee e2 = new CEmployee("Chars", "222222", 2);
		
		e2.setYearOfBirth(2016);
		//e2.ssn = "666"; // not possible: ssn final
				
		/* IMPORTANT: If set method wasn't static, the
		 * call here has to be e1 or e2. Then would be valid
		 * but misleading. e1.setBaseVacationDays(x)
		 * will modify values for e1 AND e2 because 
		 * baseVacationDays is STATIC.
		 * CONCLUSION: use STATIC method to set STATIC data*/ 
		CEmployee.setBaseVacationDays(15);
		
		/*ERROR: extraVacationDays is private*/
		//e1.baseVacationDays =100;
		
		e1.print();
		e2.print();
		
		/* OUTPUT
		Name: Lola
		SSN: 111111
		Year Of Birth: 1900
		Vacation Days: 15
		Name: Chars
		SSN: 222222
		Year Of Birth: 2016
		Vacation Days: 15
		*/
	}
}
