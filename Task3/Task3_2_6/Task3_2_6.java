package core;

import java.util.Arrays;
import java.util.Scanner;

//	go through the array and swap every 2 adjacent elements
public class Task3_2_6 {

	public static void main(String[] args) {

		int arrayLength = getArrayLengthFromUser();
		int[] array = new int[arrayLength];
		array = fillInArray(array);
		System.out.println("Your array " + Arrays.toString(array));
		swap2AdjacentElements(array);

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

	public static void swap2AdjacentElements(int[] array) {
		for (int i = 0; i < array.length; i += 2) {
			if (i == array.length - 1) {
				break;
			}
			int temp = array[i];
			array[i] = array[i + 1];
			array[i + 1] = temp;

		}
		System.out.println("Your changed array: " + Arrays.toString(array));
	}

}
