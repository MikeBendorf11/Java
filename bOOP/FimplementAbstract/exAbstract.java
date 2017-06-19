package FimplementAbstract;

public abstract class exAbstract {
	static int baseVacationDays = 10;

	abstract void setExtraVacationDays(int days);

	void printH(String header) {
		if (header != null) {
			System.out.println(header);
		}
	}

}
