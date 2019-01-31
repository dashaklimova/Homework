package core;

import java.util.Arrays;
import java.util.Scanner;

//	10. check if array is increasing sequence
public class Task3_2_10 {

	public static void main(String[] args) {

		int arrayLength = getArrayLengthFromUser();
		int[] array = new int[arrayLength];
		array = fillInArray(array);
		System.out.println("Your array " + Arrays.toString(array));
		checkForIncreasingSequence(array);

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

	public static void checkForIncreasingSequence(int[] array) {
		boolean isIncreasing = true;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] < array[i + 1]) {
				continue;
			} else {
				isIncreasing = false;
				break;
			}

		}

		if (isIncreasing) {
			System.out.println("Your array is increasing");
		} else {
			System.out.println("Your array is not increasing");
		}

	}

}
