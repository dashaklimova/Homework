package core;

public class Star extends StarSystem {

	private double temperature;
	private double magnitude;

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getMagnitude() {
		return magnitude;
	}

	public void setMagnitude(double magnitude) {
		this.magnitude = magnitude;
	}

	public double temperatureInFahrenheit() {
		double coef1 = 1.8;
		int coef2 = 32;
		return temperature * coef1 + coef2;
	}

	@Override
	protected void sayHello() {
		System.out.println("Hello from a Star");
	}

	@Override
	protected void sayBye() {
		System.out.println("Bye from a Star");
	}

	@Override
	public String toString() {
		return String.format("Temperature: %s | Magnitude: %s", temperature, magnitude);
	}

	@Override
	public int hashCode() {
		return (int) (temperature * 31 + magnitude * 31);
	}
}
