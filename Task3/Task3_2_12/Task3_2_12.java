package core;

import java.util.Arrays;
import java.util.Scanner;

// 12. Cycle all elements to the right by 2 positions
public class Task3_2_12 {

	public static void main(String[] args) {

		int arrayLength = getArrayLengthFromUser();
		int[] array = new int[arrayLength];
		array = fillInArray(array);
		System.out.println("Your array " + Arrays.toString(array));
		System.out.println("Your changed array: " + Arrays.toString(getArrayCycleToTheRight(array)));
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

	public static int[] getArrayCycleToTheRight(int[] array) {
		int[] newArray = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			if (i + 2 >= array.length) {

				newArray[i + 2 - array.length] = array[i];
				continue;
			}
			newArray[i + 2] = array[i];
		}

		return newArray;
	}

}
