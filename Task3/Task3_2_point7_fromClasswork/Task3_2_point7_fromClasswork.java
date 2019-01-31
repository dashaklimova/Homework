package core;

import java.util.Arrays;

//	7. Swap first and last elements
public class Task3_2_point7_fromClasswork {

	public static void main(String[] args) {
		int size = 5;
		int[] array = new int[size];
		array = fillInArray(array);
		System.out.println("Your array " + Arrays.toString(array));
		displaySwapNumbers(array);

	}

	public static int[] fillInArray(int[] passedArray) {
		int multiplier = 100;
		for (int i = 0; i < passedArray.length; i++) {
			passedArray[i] = (int) (Math.random() * multiplier);
		}
		return passedArray;
	}

	public static void displaySwapNumbers(int[] array) {
		int firstNumber = array[0];
		int lastNumber = array[array.length - 1];
		System.out.println("First number before changes: " + firstNumber);
		System.out.println("Last number before changes: " + lastNumber);

		int reserveNumber = firstNumber;
		firstNumber = lastNumber;
		lastNumber = reserveNumber;
		System.out.println("First number after changes: " + firstNumber);
		System.out.println("Last number after changes: " + lastNumber);

	}

}
