package core;

public class Mars extends Planet {
	private String color;
	private double distanceToTheSun;

	public double countHalfDistanceToTheSun() {
		double coef = 0.5;
		return distanceToTheSun * coef;
	}

	public void printColorOfMars() {
		System.out.println("Color of Mars is " + color);
	}

	@Override
	protected void sayHello() {
		System.out.println("Hello from Mars");
	}

	@Override
	protected void sayBye() {
		System.out.println("Bye from Mars");
	}

	@Override
	public String toString() {
		return "Mars [color=" + color + ", distanceToTheSun=" + distanceToTheSun + "]";
	}

	@Override
	public int hashCode() {
		return (int) (color == null ? 0 : color.hashCode() + 31 * distanceToTheSun);
	}

}
