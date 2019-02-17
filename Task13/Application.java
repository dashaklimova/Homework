package core;

public class Application {

	public static void main(String[] args) {
		Massive massive = new Massive("Array", 5, 10);
		Massive massive2 = new Massive();

		// initiate ArrayIndexOutOfBound
		massive.writeElementToArrayByIndex(5, 10);

		// initiate ArithmeticException
		massive.divideArrayElement(2, 0);

		// initiate ArrayIndexOutOfBound
		massive.writeDividedElementByIndexMulti(5, 12);

		// initiate NullPointerException
		massive2.printMassiveName();

		// same method without an exception
		massive.printMassiveName();

		// additional task 1
		massive.setSizeFromUser();

		// additional task 2
		massive.putDividedValueIntoArray(5, 2, 0);

		// additional task 3
		massive.finallyWillNotBeExecuted();
	}

}
