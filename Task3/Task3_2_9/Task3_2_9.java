package core;

import java.util.Arrays;
import java.util.Scanner;

//8. Find and print index of minimal and maximum elements
public class Task3_2_9 {

	public static void main(String[] args) {

		int arrayLength = getArrayLengthFromUser();
		int[] array = new int[arrayLength];
		array = fillInArray(array);
		System.out.println("Your array " + Arrays.toString(array));
		System.out.println("Index of min element is:" + getIndexOfMinElement(array));
		System.out.println("Index of max element is:" + getIndexOfMaxElement(array));

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

	public static int getIndexOfMinElement(int[] array) {
		int min = 0;
		int minIndex = 0;
		for (int i = 0; i < array.length; i++) {

			if (i == 0) {
				min = array[i];
				minIndex = i;
				continue;
			}
			if (array[i] < min) {
				min = array[i];
				minIndex = i;
			}

		}
		return minIndex;

	}

	public static int getIndexOfMaxElement(int[] array) {
		int max = 0;
		int maxIndex = 0;
		for (int i = 0; i < array.length; i++) {

			if (i == 0) {
				max = array[i];
				maxIndex = i;
				continue;
			}
			if (array[i] > max) {
				max = array[i];
				maxIndex = i;
			}
		}
		return maxIndex;

	}
}
