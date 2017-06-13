package GressourceSample;

public class EEmployee {
	private String name;
	private final String ssn;
    String emailAddress;
    int yearOfBirth;
    int extraVacationDays = 0;
    static int baseVacationDays = 10;

    EEmployee(String name, String ssn) {
        this.name = name;
        this.ssn = ssn;
    }
    public void setName(String name) {
        if (name != null && name.length() > 0) {
            this.name = name;
        }
    }

    public String getName() {
        return this.name;
    }

    public String getSsn() {
        return this.ssn;
    }


    static void setBaseVacationDays(int days) {
        baseVacationDays = days < 10? 10 : days;
    }

    static int getBaseVacationDays() {
        return baseVacationDays;
    }

    void setExtraVacationDays(int days) {
        extraVacationDays = days < 0? 0 : days;
    }

    int getExtraVacationDays() {
        return extraVacationDays;
    }

    void setYearOfBirth(int year) {
        yearOfBirth = year;
    }

    int getVacationDays() {
        return baseVacationDays + extraVacationDays;
    }

    public void print(String header, String footer) {
        if (header != null) {
            System.out.println(header);
        }
        System.out.println("Name: " + name);
        System.out.println("SSN: " + ssn);
        System.out.println("Email Address: " + emailAddress);
        System.out.println("Year Of Birth: " + yearOfBirth);
        System.out.println("Vacation Days: " + getVacationDays());
        if (footer != null) {
            System.out.println(footer);
        }
    }

    public void print(String header) {
        print(header, null);
    }

    public void print() {
        print(null);
    }


}
