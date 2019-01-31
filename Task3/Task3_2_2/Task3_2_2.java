package core;

import java.util.Scanner;

public class Task3_2_2 {
	// 2. find multiply of all elements of the array, output
	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);

		int length = getArrayLengthFromUser();

		int[] array = new int[length];

		array = getArrayFilledByUser(array);

		System.out.println("multiply of all elements of the array " + multiplyArrayElements(array));
		input.close();
	}

	public static int getArrayLengthFromUser() {
		System.out.println("Enter array length: ");
		int arrayLength = input.nextInt();
		return arrayLength;
	}

	// filling array by user
	public static int[] getArrayFilledByUser(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println("Enter array element: ");
			int userNumber = input.nextInt();
			array[i] = userNumber;
		}

		return array;
	}

	public static int multiplyArrayElements(int[] array) {
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			if (i == 0) {
				result = array[i];
				continue;
			}
			result = result * array[i];
		}
		return result;

	}
}
