package GressourceSample;

public class EEmployeeDemo {
    public static void main(String[] args) {
    	EEmployee e1 = new EEmployee("John", "555-12-345");
    	e1.emailAddress = "john@company.com";

    	EEmployee e2 = new EEmployee("Chars", "222222");
        e1.emailAddress = "john@company.com";
        e2.setYearOfBirth(1974);
        e2.setName("Tom");

        Manager m1 = new Manager("Bob", "345-11-987", "Development");
        EEmployee.setBaseVacationDays(15);
        m1.setExtraVacationDays(10);
        
        e1.print("COOL EMPLOYEE");
        e2.print("START OF EMPLOYEE", "END OF EMPLOYEE");
        m1.print("BIG BOSS");
    }
}