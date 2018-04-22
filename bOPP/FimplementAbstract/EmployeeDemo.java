package FimplementAbstract;

public class EmployeeDemo {

	public static void main(String[] args) {
		Employee e = new Employee(123 , "Catota");
		e.setExtraVacationDays(1);
		e.print("EMPLOYEE INFO: ");
		e = e.fireEmployee(e);
		if(e instanceof Employee) e.print("EMPLOYEE INFO: ");
		else System.out.println("FIRED!!!");
		
	}

}
