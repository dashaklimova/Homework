package core;

public class Application {

	public static void main(String[] args) {

		Tester tester1 = new Tester("John", "Black", 5, "C1", 2000);
		// System.out.println(tester1.countDoubleSalary()); - cannot be accessed because it's a private method
		System.out.println("Experience in months: " + tester1.countExperienceInMonths());
		tester1.printNameAndSurname();
		tester1.printAllInformation();
	}
}
