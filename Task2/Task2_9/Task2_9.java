package core;

import java.util.Scanner;

public class Task2_9 {

	public static void main(String[] args) {
		// 9. найти номер минимального-максимального элементов и вывести

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
		System.out.println("Index of min element is:" + minIndex);

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
		System.out.println("Index of max element is:" + maxIndex);
		input.close();

	}

}
