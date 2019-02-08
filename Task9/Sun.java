package core;

public class Sun extends Star {
	private String coreColor;
	private double luminosity;

	public void printCoreColor() {
		System.out.println("Core color is " + coreColor);
	}

	public void PrintLuminosity() {
		System.out.println("Luminosity is equal " + luminosity);
	}

	@Override
	protected void sayHello() {
		System.out.println("Hello from Sun");
	}

	@Override
	protected void sayBye() {
		System.out.println("Bye from Sun");
	}

	@Override
	public String toString() {
		return "Sun [coreColor=" + coreColor + ", luminosity=" + luminosity + "]";
	}

	@Override
	public int hashCode() {
		return (int) (coreColor == null ? 0 : coreColor.hashCode() + 31 * luminosity);
	}
}
