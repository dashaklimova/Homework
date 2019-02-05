package additionalTask;

public class App {

	public static void main(String[] args) {
		// Tester tester = new Tester(); - cannot be accessed, because constructor is private.
		// We can use .getTester() method instead;
		Tester tester = Tester.getTester();
		tester.setName("John");
		tester.setSurname("White");
		tester.setExperienceInYears(7);
		tester.setEnglishLevel("B2");
		tester.setSalary(2500);
		// tester.countDoubleSalary(); - cannot be accessed because it's a private method
		System.out.println("Experience in months: " + tester.countExperienceInMonths());
		tester.printNameAndSurname();
		tester.printAllInformation();
	}
}
