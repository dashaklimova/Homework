package core;

import java.util.Scanner;

public class Task2_10 {

	public static void main(String[] args) {
		// 10. проверить, является ли массив возрастающей последовательностью (каждое
		// следующее число больше предыдущего)

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
		input.close();
	}
}
