package core;

public abstract class StarSystem {

	private double radius;
	private double weight;
	private double age;

	protected double diameter() {
		return radius * 2;
	}

	protected void printWeightOfCosmicBody() {
		System.out.println("Weight of cosmic body is: " + age);
	}

	protected void printAgeOfCosmicBody() {
		System.out.println("Age of cosmic body is: " + weight);
	}

	protected abstract void sayHello();

	protected abstract void sayBye();

	@Override
	public String toString() {
		return "StarSystem [radius=" + radius + ", weight=" + weight + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		return (int) (radius * 31 + weight * 31 + age * 31);
	}
}
