package core;

import java.util.Arrays;
import java.util.Scanner;

public class Task3_2_4 {

//	4. Find the number of zero elements, display the number. if no zero
// 	elements - display a message that they are not.
	public static void main(String[] args) {

		int arrayLength = getArrayLengthFromUser();
		int[] array = new int[arrayLength];
		array = fillInArray(array);
		System.out.println("Your array " + Arrays.toString(array));
		checkForZeroElements(array);

	}

	public static int getArrayLengthFromUser() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter array length: ");
		int arrayLength = input.nextInt();
		input.close();
		return arrayLength;
	}

	// filling in the array with Math.random()
	public static int[] fillInArray(int[] passedArray) {
		int multiplier = 100;
		for (int i = 0; i < passedArray.length; i++) {
			passedArray[i] = (int) (Math.random() * multiplier);
		}
		return passedArray;
	}

	// checking for zero elements
	public static void checkForZeroElements(int[] array) {
		for (int i = 0; i < array.length; i++) {

		}

		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0) {
				count++;
			}
		}

		if (count == 0) {
			System.out.println("There are no zero elements");
		} else {
			System.out.println("There are " + count + " zero elements");
		}

	}
}
