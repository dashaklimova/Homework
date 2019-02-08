package core;

public class Application {

	public static void main(String[] args) {

		Planet planet = new Planet(5, 258.45);

		Star star = new Star();
		star.setMagnitude(-54);
		star.setTemperature(50);
		System.out.println(star);

		Earth earth = new Earth("Blue Planet", 24);

		Mars mars = new Mars();
		Sun sun = new Sun();
		Sirius sirius = new Sirius();

		planet.sayHello();
		planet.sayBye();

		star.sayHello();
		star.sayBye();

		earth.sayHello();
		earth.sayBye();

		mars.sayHello();
		mars.sayBye();

		sun.sayHello();
		sun.sayBye();

		sirius.sayHello();
		sirius.sayBye();

		// additional task
		System.out.println("Additional task: .toString and .hashCode()");
		System.out.println(planet);
		System.out.println("Planet hascode: " + planet.hashCode());
		System.out.println(star);
		System.out.println("Star hashcode: " + star.hashCode());
		System.out.println(earth);
		System.out.println("Earth hashcode: " + earth.hashCode());
		System.out.println(mars);
		System.out.println("Mars hashcode: " + mars.hashCode());
		System.out.println(sun);
		System.out.println("Sun hashcode: " + sun.hashCode());
		System.out.println(sirius);
		System.out.println("Sirius hashcode: " + sirius.hashCode());
	}
}
