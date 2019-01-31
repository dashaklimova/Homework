package core;

import java.util.Arrays;
import java.util.Scanner;

// 8. Find and print minimal and maximum elements
public class Task3_2_8 {

	public static void main(String[] args) {

		int arrayLength = getArrayLengthFromUser();
		int[] array = new int[arrayLength];
		array = fillInArray(array);
		System.out.println("Your array " + Arrays.toString(array));
		System.out.println("Minimal array element is: " + getMinElement(array));
		System.out.println("Maximum array element is: " + getMaxElement(array));

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

	public static int getMinElement(int[] array) {
		int min = 0;
		for (int i = 0; i < array.length; i++) {

			if (i == 0) {
				min = array[i];
				continue;
			}
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;

	}

	public static int getMaxElement(int[] array) {
		int max = 0;
		for (int i = 0; i < array.length; i++) {

			if (i == 0) {
				max = array[i];
				continue;
			}
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}
}
