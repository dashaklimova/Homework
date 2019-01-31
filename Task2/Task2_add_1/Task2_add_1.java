package core;

import java.util.Scanner;

public class Task2_add_1 {

	public static void main(String[] args) {

//		По аналогии создать двумерный массив, заполнить его случайными числами или вручную. для этого массива:
//		вывести все элементы в прямом и обратном порядке
//		найти минимальный и максимальный элементы

		Scanner input = new Scanner(System.in);

		System.out.println("Enter rows count:");
		int rows = input.nextInt();
		System.out.println("Enter column count:");
		int columns = input.nextInt();

		int multiplier = 100;
		int[][] array = new int[rows][columns];

		// filling in
		for (int i = 0; i < rows; i++) {
			for (int k = 0; k < columns; k++) {
				array[i][k] = (int) (Math.random() * multiplier);
			}
		}

		// direct order
		System.out.println("Your array in direct order:");
		for (int i = 0; i < rows; i++) {
			String row = "";
			for (int k = 0; k < columns; k++) {

				row += array[i][k] + " ";
			}

			System.out.println(row);
		}

		// reverse order
		System.out.println("Your array in reverse order:");
		for (int i = rows - 1; i >= 0; i--) {
			String row = "";
			for (int k = columns - 1; k >= 0; k--) {

				row += array[i][k] + " ";
			}

			System.out.println(row);
		}

		// minimum element
		int min = 0;
		for (int i = 0; i < rows; i++) {
			for (int k = 0; k < columns; k++) {
				if (i == 0 && k == 0) {
					min = array[i][k];
				}
				if (array[i][k] < min) {
					min = array[i][k];
				}
			}

		}
		System.out.println("Your minimum element is: " + min);

		// maximum element
		int max = 0;
		for (int i = 0; i < rows; i++) {
			for (int k = 0; k < columns; k++) {
				if (i == 0 && k == 0) {
					max = array[i][k];
				}
				if (array[i][k] > max) {
					max = array[i][k];
				}
			}

		}
		System.out.println("Your maximum element is: " + max);
		input.close();
	}
}
