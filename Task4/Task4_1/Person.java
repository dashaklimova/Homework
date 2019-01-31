package core;

public class Person {
	private String name;
	private String surname;
	private int age;
	private String phone;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNumber() {
		return this.phone;
	}

	public void printAllInformation() {
		System.out.println("Name: " + name + " | Surname: " + surname + " | Age: " + age + " | Phone: " + phone);
	}

	public void printName() {
		System.out.println("Name: " + name + " | Surname: " + surname);
	}

	public boolean isAdult() {

		if (this.age >= 18) {
			return true;
		}
		return false;

	}
}
