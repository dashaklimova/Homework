package core;

public class Planet extends StarSystem {

	private int countOfSputnics;
	private double population;
	private double square;

	public Planet() {

	}

	public Planet(int countOfSputnics) {
		this();
		this.countOfSputnics = countOfSputnics;
	}

	public Planet(int countOfSputnics, double population) {
		this(countOfSputnics);
		this.population = population;
	}

	public void printCountOfSputnics() {
		System.out.println("Count of planet sputnics is:  " + countOfSputnics);
	}

	public double populationDensity() {
		return population / square;
	}

	@Override
	protected void sayHello() {
		System.out.println("Hello from a Planet");
	}

	@Override
	protected void sayBye() {
		System.out.println("Bye from a Planet");
	}

	@Override
	public String toString() {
		return "Planet [countOfSputnics=" + countOfSputnics + ", population=" + population + ", square=" + square + "]";
	}

	@Override
	public int hashCode() {
		return (int) (countOfSputnics * 31 + 31 * population + 31 * square);
	}
}
