package anotherCore;

import core.Tester;

public class ApplicationFromAnotherPackage {
	public static void main(String[] args) {

		Tester tester1 = new Tester("John", "Black", 5, "C1", 2000);
		// System.out.println(tester1.countDoubleSalary()); - cannot be accessed because it's a private method
		// System.out.println("Experience in months: " + tester1.countExperienceInMonths()); - cannot be accessed because it's a friendly method
		// tester1.printNameAndSurname(); - cannot be accessed because it's a protected method
		tester1.printAllInformation();
	}

}
