package core;

public class Main {

	public static void main(String[] args) {
		Tester tester1 = new Tester("John", "Brown", 5, "B2", 500);
		tester1.printName();
		tester1.printName(true);
		System.out.println(tester1.calculateNetSalary());
		System.out.println(tester1.calculateNetSalary(35));
		tester1.printAllInformation();
		tester1.printAllInformation(true);		
		System.out.println(Tester.calculateSalary(tester1.getSalary(), 85));
		System.out.println(Tester.calculateSalary(8000, 500));

	}
}
