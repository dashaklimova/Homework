package core;

import java.util.Arrays;
import java.util.Scanner;

//7. go through the array and swap the first and last, second and the last but one, etc.
public class Task3_2_7 {

	public static void main(String[] args) {

		int arrayLength = getArrayLengthFromUser();
		int[] array = new int[arrayLength];
		array = fillInArray(array);
		System.out.println("Your array " + Arrays.toString(array));
		swapFirstAndLastElements(array);

	}

	public static int getArrayLengthFromUser() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter array length: ");
		int arrayLength = input.nextInt();
		input.close();
		return arrayLength;
	}

	public static int[] fillInArray(int[] passedArray) {
		int multiplier = 100;
		for (int i = 0; i < passedArray.length; i++) {
			passedArray[i] = (int) (Math.random() * multiplier);
		}
		return passedArray;
	}

	public static void swapFirstAndLastElements(int[] array) {
		for (int i = 0; i < array.length / 2; i++) {
			int indexFromEnd = (array.length - 1) - i;
			int temp = array[i];
			array[i] = array[indexFromEnd];
			array[indexFromEnd] = temp;
		}
		System.out.println("Your changed array: " + Arrays.toString(array));
	}

}
