package core;

import java.util.Arrays;
import java.util.Scanner;

//		create a two-dimensional array, fill it with random numbers
//		output all elements in direct and reverse order
//		find the minimum and maximum elements
public class Task3_2_add_1 {

	public static void main(String[] args) {

		int[] arraySize = getArraySizeFromUser();

		// create and fill in
		int[][] array = createArrayAndFillIn(arraySize[0], arraySize[1]);

		// direct order
		System.out.println("Your array in direct order:");
		for (int i = 0; i < array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}

		// reverse order
		System.out.println("Your array in reverse order:");
		displayReversedArray(array);

		// minimum element
		System.out.println("Your minimum element is: " + getMinElement(array));

		// maximum element
		System.out.println("Your maximum element is: " + getMaxElement(array));

	}

	public static int[] getArraySizeFromUser() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter rows count:");
		int rows = input.nextInt();
		System.out.println("Enter column count:");
		int columns = input.nextInt();
		int[] size = { rows, columns };
		input.close();
		return size;
	}

	public static int[][] createArrayAndFillIn(int rows, int columns) {
		int[][] array = new int[rows][columns];
		int multiplier = 100;
		for (int i = 0; i < rows; i++) {
			for (int k = 0; k < columns; k++) {
				array[i][k] = (int) (Math.random() * multiplier);
			}
		}
		return array;
	}

	public static void displayReversedArray(int[][] array) {

		int rows = array.length;
		int columns = array[0].length;

		for (int i = rows - 1; i >= 0; i--) {
			String row = "";
			for (int k = columns - 1; k >= 0; k--) {

				row += array[i][k] + " ";
			}

			System.out.println("[" + row + "]");
		}
	}

	public static int getMinElement(int[][] array) {

		int min = 0;
		int rows = array.length;
		int columns = array[0].length;
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
		return min;
	}

	public static int getMaxElement(int[][] array) {
		int rows = array.length;
		int columns = array[0].length;
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

		return max;
	}

}