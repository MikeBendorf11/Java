package CstaticInstanceMethods;

public class CEmployee {
	String name;
    final String ssn;
    /*each employee has its own copy*/
    int yearOfBirth;
    /* IMPORTANT
     * Variable shared among all employees*/
    private static int baseVacationDays = 10;
    
    /*Default constructor: If you create an employee
     * you have to enter this data: name, ssn*/
    CEmployee(String name, String ssn, int yearOfBirth) { 
        this.name = name;
        this.ssn = ssn;
        this.yearOfBirth = yearOfBirth;
    }
    /* IMPORTANT
     * STATIC methods can ONLY access static data or methods
     * if baseVacationDays not static then ERROR*/
    static void setBaseVacationDays(int days) {
        baseVacationDays = days < 10? 10 : days;
    }
    
    static int getBaseVacationDays() {
        return baseVacationDays;
    }
    /* INSTANCE method has access
     * to both static and INSTANCE data and methods*/
    void setYearOfBirth(int year) {
        yearOfBirth = year;
    }

    void print() {
        System.out.println("Name: " + name);
        System.out.println("SSN: " + ssn);
        System.out.println("Year Of Birth: " + yearOfBirth);
        System.out.println("Vacation Days: " + getBaseVacationDays());
    }

}
