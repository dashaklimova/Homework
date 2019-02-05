package additionalTask;

public class Tester {
	public String name;
	public String surname;
	protected double experienceInYears;
	String englishLevel;
	private double salary;
	
	// private constructor -> We can not create an object of class Tester outside the class. 
	private Tester() {
		
	}

	// public method. Responsible for creating the object of class Tester.
	public static Tester getTester() {
		return new Tester();
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
