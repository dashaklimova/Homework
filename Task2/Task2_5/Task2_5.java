package core;

import java.util.Scanner;

public class Task2_5 {

	public static void main(String[] args) {
		// 5. найти и вывести номер нулевых элементов. если нулевых элементов нет -
		// вывести сообщение, что их нет

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

		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0) {
				count++;
				System.out.println("Index of zero element: " + i);
			}

		}
		if (count == 0) {
			System.out.println("There are no zero elements");

		}

		input.close();
	}

}
