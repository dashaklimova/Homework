package core;

import java.util.Scanner;

public class Task2_7 {

	public static void main(String[] args) {
		// 7. пройти по массиву и поменять местами первый и последний, второй и
		// предпоследний и т.д.

		Scanner input = new Scanner(System.in);
		System.out.println("Enter array lenght:");
		int arrayLength = input.nextInt();
		int[] array = new int[arrayLength];
		int multiplier = 100;

		System.out.println("Your array: ");
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * multiplier);
			System.out.println(array[i]);
		}

		for (int i = 0; i < array.length / 2; i++) {
			int indexFromEnd = (array.length - 1) - i;
			int temp = array[i];
			array[i] = array[indexFromEnd];
			array[indexFromEnd] = temp;
		}

		System.out.println("Your changed array:");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		input.close();
	}
}
