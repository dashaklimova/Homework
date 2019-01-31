package core;

public class Main {

	public static void main(String[] args) {

		// Task 4_1
		System.out.println("Task4_1");
		Person person = new Person();
		person.setName("John");
		person.setSurname("Smith");
		person.setAge(35);
		person.setPhone("+375 29 777 88 99");
		person.printAllInformation();
		person.printName();
		System.out.println("Person is adult: " + person.isAdult());

		// Task4_2
		System.out.println();
		System.out.println("Task4_2");
		int size = 9;
		int[] array = createArray(size);
		Massive massive = new Massive();

		System.out.println("Array in direct order: ");
		massive.printMassiveAsLine(array);

		System.out.println();
		System.out.println("Array in reverse order: ");
		massive.printReverseMassiveAsLine(array);

		System.out.println();
		System.out.println("The sum of array evements is: " + massive.getSumOfElements(array));

		int[] newArray = massive.multiptyBy3(array);
		System.out.println();
		System.out.println("Multiplied by 3 array in direct order: ");
		massive.printMassiveAsLine(newArray);
		System.out.println();
		System.out.println("Multiplied by 3 array in reverse order: ");
		massive.printReverseMassiveAsLine(newArray);

	}

	public static int[] createArray(int size) {
		int[] array = new int[size];
		int multiplier = 100;
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * multiplier);
		}
		return array;
	}
}
