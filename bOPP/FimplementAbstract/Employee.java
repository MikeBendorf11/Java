package FimplementAbstract;

public class Employee  extends exAbstract 
implements companyInterface 
{
	private final int sin;
	private String name;
	Employee(int sin, String name ){
		this.sin = sin;
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public int getSin(){
		return sin;
	}
	public Employee fireEmployee(Employee e) {
		//force implementation from companyInterface
		e = null;
		return e;
	}
	void print(String header){
		//inherited from abstract
		printH(header);
		System.out.println(sin + " " + name);
		System.out.println("Base: "+baseVacationDays);
	}
	
	void setExtraVacationDays(int days) {
		baseVacationDays += days;
	}
	

}
