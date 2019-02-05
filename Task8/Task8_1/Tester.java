package core;

public class Tester {
	public String name;
	public String surname;
	protected double experienceInYears;
	String englishLevel;
	private double salary;

	private Tester(String name) {
		this.name = name;
	}

	Tester(String name, String surname, double experienceInYears, String englishLevel) {
		this(name);
		this.surname = surname;
		this.experienceInYears = experienceInYears;
		this.englishLevel = englishLevel;
	}

	public Tester(String name, String surname, double experienceInYears, String englishLevel, double salary) {
		this(name, surname, experienceInYears, englishLevel);
		this.salary = salary;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	String getSurname() {
		return surname;
	}

	void setSurname(String surname) {
		this.surname = surname;
	}

	double getExperienceInYears() {
		return experienceInYears;
	}

	void setExperienceInYears(double experienceInYears) {
		this.experienceInYears = experienceInYears;
	}

	String getEnglishLevel() {
		return englishLevel;
	}

	void setEnglishLevel(String englishLevel) {
		this.englishLevel = englishLevel;
	}

	double getSalary() {
		return salary;
	}

	void setSalary(double salary) {
		this.salary = salary;
	}

	private double countDoubleSalary() {
		return this.salary * 2;
	}

	double countExperienceInMonths() {
		int countOfMonths = 12;
		return this.experienceInYears * countOfMonths;
	}

	protected void printNameAndSurname() {
		System.out.println(String.format("Name: %s | Surname: %s ", this.name, this.surname));
	}

	public void printAllInformation() {
		System.out.println(
				String.format("Name: %s | Surname: %s | Experience in years: %s | English level: %s | Salary: %s",
						this.name, this.surname, this.experienceInYears, this.englishLevel, this.salary));

	}

}
