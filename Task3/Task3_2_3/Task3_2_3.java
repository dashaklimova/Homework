package core;

import java.util.Arrays;
import java.util.Scanner;

public class Task3_2_3 {
	// 3. every 3rd element multiplied by 2 (2 ways)

	static public void main(String[] args) {

		int arrayLength = getArrayLengthFromUser();
		int[] array = new int[arrayLength];
		// filling in the array with Math.random():
		array = fillInArray(array);
		System.out.println("Your array " + Arrays.toString(array));
		multiplyEvery3dElementBy2Way1(array);
		dmultiplyEvery3dElementBy2Way2(array);

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

	public static void multiplyEvery3dElementBy2Way1(int[] array) {
		System.out.println("Array with every 3rd element multiplied by 2, first way:");
		for (int i = 0; i < array.length; i++) {
			if ((i + 1) % 3 == 0) {
				System.out.println(array[i] * 2);
			} else {
				System.out.println(array[i]);
			}
		}

	}

	public static void dmultiplyEvery3dElementBy2Way2(int[] array) {
		System.out.println("Array with every 3rd element multiplied by 2, second way:");
		int i = 0;
		while (i < array.length) {
			if ((i + 1) % 3 == 0) {
				System.out.println(array[i] * 2);
			} else {
				System.out.println(array[i]);
			}
			i++;
		}

	}
}
