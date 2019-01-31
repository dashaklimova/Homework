package core;

public class Tester {

	private String name;
	private String surname;
	private int experienceInYears;
	private String englishLevel;
	private double salary;
	private static final double TAX_RATE = 25;
	private String space = "  ";

	public Tester() {

	}

	public Tester(String name) {
		this();
		this.name = name;
	}

	public Tester(String name, String surname) {
		this(name);
		this.surname = surname;
	}

	public Tester(String name, String surname, int experienceInYears) {
		this(name, surname);
		this.experienceInYears = experienceInYears;
	}

	public Tester(String name, String surname, int experienceInYears, String englishLevel) {
		this(name, surname, experienceInYears);
		this.englishLevel = englishLevel;
	}

	public Tester(String name, String surname, int experienceInYears, String englishLevel, double salary) {
		this(name, surname, experienceInYears, englishLevel);
		this.salary = salary;
	}

	public double getSalary() {
		return this.salary;
	}

	// methods for printing name
	public void printName() {
		System.out.println(this.name);
	}

	public void printName(boolean nameGoesFirst) {
		String message = nameGoesFirst ? "Name: " + this.name + " | Surname: " + this.surname
				: "Surname: " + this.surname + " | Name: " + this.name;
		System.out.println(message);
	}

	// methods for printing info
	public void printAllInformation() {
		System.out
				.println(this.name + space + this.surname + space + this.experienceInYears + space + this.englishLevel);
	}

	public void printAllInformation(boolean includePrivateInfo) {
		if (includePrivateInfo) {
			System.out.println(this.name + space + this.surname + space + this.experienceInYears + space
					+ this.englishLevel + space + salary);
		} else {
			printAllInformation();
		}
	}

	// methods for calculating salary
	public static double calculateSalary(double salary, double bonus) {
		return salary + bonus - (salary * (TAX_RATE) / 100);
	}

	public double calculateNetSalary() {
		return calculateSalary(this.salary, 0);
	}

	public double calculateNetSalary(double bonus) {
		return calculateSalary(this.salary, bonus);
	}
}
