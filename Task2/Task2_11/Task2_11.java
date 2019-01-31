package core;

import java.util.Scanner;

public class Task2_11 {

	public static void main(String[] args) {
		// 11. заменить все элементы массива на полусумму соседних элементов

		Scanner input = new Scanner(System.in);
		System.out.println("Enter array length:");
		int arrayLength = input.nextInt();
		int[] array = new int[arrayLength];
		double[] semiSumArray = new double[arrayLength];
		int multiplier = 100;

		System.out.println("Your array: ");
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * multiplier);
			System.out.println(array[i]);
		}

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

		System.out.println("Your changed array:");
		for (int i = 0; i < array.length; i++) {
			System.out.println(semiSumArray[i]);
		}
		input.close();
	}
}
