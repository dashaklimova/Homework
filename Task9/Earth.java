package core;

public class Earth extends Planet {

	private String otherName;
	private double dayLenghtInHours;

	public Earth() {

	}

	public Earth(String otherName) {
		this.otherName = otherName;
	}

	public Earth(String otherName, double dayLenght) {
		this.otherName = otherName;
		this.dayLenghtInHours = dayLenght;
	}

	public double countDayLengthInMinutes() {
		int minutes = 60;
		return dayLenghtInHours * minutes;
	}

	public void printOtherNameOfEarth() {
		System.out.println("Another name for Earth is " + otherName);
	}

	@Override
	protected void sayHello() {
		System.out.println("Hello from Earth");
	}

	@Override
	protected void sayBye() {
		System.out.println("Bye from Earth");
	}

	@Override
	public String toString() {
		return "Earth [otherName=" + otherName + ", dayLenghtInHours=" + dayLenghtInHours + "]";
	}

	@Override
	public int hashCode() {
		return (int) (otherName == null ? 0 : otherName.hashCode() + 31 * dayLenghtInHours);
	}
}
