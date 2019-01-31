package core;

import java.util.Scanner;

public class Task2_6 {

	public static void main(String[] args) {
		// 6. пройти по массиву и поменять местами каждые 2 соседних элемента

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

		for (int i = 0; i < array.length; i += 2) {
			if (i == array.length - 1) {
				break;
			}
			int temp = array[i];
			array[i] = array[i + 1];
			array[i + 1] = temp;

		}
		System.out.println("Your changed array:");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		input.close();
	}

}
