package core;

public class Sirius extends Star {
	private String constellation;
	private String spectralType;

	public void printConstellation() {
		System.out.println("Sirius constellation is " + constellation);
	}

	public void printSpectralType() {
		System.out.println("Sirius spectral type is " + spectralType);
	}

	@Override
	protected void sayHello() {
		System.out.println("Hello from Sirius");
	}

	@Override
	protected void sayBye() {
		System.out.println("Bye from Sirius");
	}

	@Override
	public String toString() {
		return "Sirius [constellation=" + constellation + ", spectralType=" + spectralType + "]";
	}

	@Override
	public int hashCode() {
		return (int) (constellation == null ? 0 : constellation.hashCode() + spectralType == null ? 0 : spectralType.hashCode());
	}

}
