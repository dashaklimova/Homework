package core;

import java.util.Arrays;
import java.util.Scanner;

//	5.Find the index of zero elements, display the number. if no zero
// 	elements - display a message that they are not.
public class Task3_2_5 {

	public static void main(String[] args) {

		int arrayLength = getArrayLengthFromUser();
		int[] array = new int[arrayLength];
		array = fillInArray(array);
		System.out.println("Your array " + Arrays.toString(array));
		checkForZeroIndex(array);

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

	// checking for zero index
	public static void checkForZeroIndex(int[] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0) {
				count++;
				System.out.println("Index of zero element: " + i);
			}

		}
		if (count == 0) {
			System.out.println("There are no zero elements");

		}

	}
}
