package core;

import java.util.Arrays;
import java.util.Scanner;

//	11. replace all array elements with half the sum of neighboring elements
public class Task3_2_11 {

	public static void main(String[] args) {

		int arrayLength = getArrayLengthFromUser();
		int[] array = new int[arrayLength];
		array = fillInArray(array);
		System.out.println("Your array " + Arrays.toString(array));
		System.out.println("Your changed array: " + Arrays.toString(replaceElementsForHalfTheSum(array)));

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

	public static double[] replaceElementsForHalfTheSum(int[] array) {
		double[] semiSumArray = new double[array.length];
		for (int i = 0; i < array.length; i++) {
			if (i == 0) {
				semiSumArray[i] = array[i];
				continue;
			}

			if (i == array.length - 1) {
				semiSumArray[i] = array[i];
				break;
			}

			semiSumArray[i] = (double) (array[i - 1] + array[i + 1]) / 2;
		}

		return semiSumArray;
	}
}
