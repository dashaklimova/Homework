package core;

import java.util.Scanner;

public class Task2_8 {

	public static void main(String[] args) {
		// 8. найти минимальный-максимальный элементы и вывести

		Scanner input = new Scanner(System.in);
		System.out.println("Enter array length:");
		int arrayLength = input.nextInt();
		int[] array = new int[arrayLength];
		int multiplier = 100;

		System.out.println("Your array: ");
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * multiplier);
			System.out.println(array[i]);
		}

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
		System.out.println("Minimal array element is: " + min);

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
		System.out.println("Maximum array element is: " + max);
		input.close();
	}
}
