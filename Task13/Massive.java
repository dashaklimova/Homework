package core;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Massive {

	private String name;
	private int size;
	private int multiplier;
	private int[] array;

	public Massive() {

	}

	public Massive(String name, int size, int multiplier) {
		this.name = name;
		this.size = size;
		this.multiplier = multiplier;
		this.array = new int[size];
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}

	public int getMultiplier() {
		return multiplier;
	}

	public void setMultiplier(int multiplier) {
		this.multiplier = multiplier;
	}

	@Override
	public String toString() {

		return String.format("| Name: %s | Size: %s | Multiplier: %s | Array: %s |", name, size, multiplier,
				Arrays.toString(array));
	}

	public void writeElementToArrayByIndex(int index, int value) {
		try {
			array[index] = value;
		} catch (IndexOutOfBoundsException ex) {
			System.out.println("Your index is out of bound. Your element is not added to the array");
		}
	}

	public void divideArrayElement(int index, int divider) {
		try {
			array[index] = array[index] / divider;
		} catch (IndexOutOfBoundsException ex) {
			System.out.println("Your index is out of bound. Your element is not added to the array");
		} catch (ArithmeticException ex) {
			System.out.println("Division by zero!");
		}
	}

	public void writeDividedElementByIndexMulti(int index, int divider) {
		try {
			array[index] = array[index] / divider;
		} catch (IndexOutOfBoundsException | ArithmeticException ex) {
			System.out.println("Please, check array index or divider.");
		}
	}

	public void printMassiveName() {
		try {
			System.out.println("THE NAME OF YOUR ARRAY IN UPPER CASE: " + name.toUpperCase());
		} catch (NullPointerException ex) {
			System.out.println("You did not give the object a name.");
		} finally {
			System.out.println("This line will be displayed anyway :)");
		}
	}

	// additional task
	// try with resources
	public void setSizeFromUser() {
		System.out.println("Enter a number.");
		try (Scanner scanner = new Scanner(System.in)) {
			size = scanner.nextInt();
		} catch (InputMismatchException ex) {
			System.out.println("You've entered not a number.");
		}
	}

	// try nested try
	public void putDividedValueIntoArray(int index, int value, int divider) {
		try {
			double result = value / divider;
			try {
				array[index] = (int) result;
			} catch (IndexOutOfBoundsException ex) {
				System.out.println("Your index is out of bound. Your element is not added to the array");
			}
		} catch (ArithmeticException ex) {
			System.out.println("Division by zero!");
		}
	}

	// finally will not be executed
	public void finallyWillNotBeExecuted() {
		try {
			System.exit(7);
		} finally {
			System.out.println("This will never be executed.");
		}
	}
}
