package core;

import java.util.Scanner;

public class Task3_2_1 {

	// 1. iterate through the array, display all elements in direct and reverse
	// order.

	public static void main(String[] args) {

		int length = getArrayLengthFromUser();
		int[] array = new int[length];

		// filling in the array with Math.random():
		array = fillInArray(array);

		// output in direct order
		displayArray(array);

		// output in reverse order
		displayArrayInReverse(array);
	}

	public static int getArrayLengthFromUser() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter array length: ");
		int arrayLength = input.nextInt();
		input.close();
		return arrayLength;
	}

	// filling in the array with Math.random():
	public static int[] fillInArray(int[] passedArray) {
		int multiplier = 100;
		for (int i = 0; i < passedArray.length; i++) {
			passedArray[i] = (int) (Math.random() * multiplier);
		}
		return passedArray;
	}

	// output in direct order
	public static void displayArray(int[] array) {
		System.out.println("Your array in direct order.");
		int i = 0;
		while (i < array.length) {
			System.out.println(array[i]);
			i++;
		}
	}

	// output in reverse order
	public static void displayArrayInReverse(int[] array) {
		System.out.println("Your array in reverse order.");
		for (int k = array.length - 1; k >= 0; k--) {
			System.out.println(array[k]);
		}
	}

}
