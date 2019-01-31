package core;

import java.util.Scanner;

public class Task2_12 {

	public static void main(String[] args) {
		// 12. циклически сдвинуть все элементы вправо на 2 позиции (1-й элемент станет
		// 3-м, 2-й станет 4-м и т.д.)

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

		int[] newArray = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			if (i + 2 >= array.length) {

				newArray[i + 2 - array.length] = array[i];
				continue;
			}
			newArray[i + 2] = array[i];

		}
		System.out.println("Your changed array:");
		for (int i = 0; i < array.length; i++) {
			System.out.println(newArray[i]);
		}

		input.close();
	}

}
