package core;

import java.util.Scanner;

public class Task2_2 {
	// 2. найти произведения всех элементов массива, вывести

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Введите длину массива:");
		int arrayLength = input.nextInt();
		int[] array = new int[arrayLength];
		Scanner inputNumber = new Scanner(System.in);

		// заполнение массива пользователем:
		for (int i = 0; i < array.length; i++) {
			System.out.println("Введите целое число для массива:");
			int userNumber = inputNumber.nextInt();
			array[i] = userNumber;
		}

		int result = 0;
		for (int i = 0; i < array.length; i++) {
			if (i == 0) {
				result = array[i];
			}
			result = result * array[i];
		}

		System.out.println("Произведение всех элементов массива: " + result);
		input.close();
		inputNumber.close();
	}

}
