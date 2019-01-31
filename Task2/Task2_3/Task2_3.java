package core;

import java.util.Scanner;

public class Task2_3 {
	static public void main(String[] args) {

		// 3. каждый 3-й элемент умножить на 2 (2-мя способами)

		Scanner input = new Scanner(System.in);
		System.out.println("Введите длину массива:");
		int arrayLenght = input.nextInt();
		int[] array = new int[arrayLenght];
		int multiplier = 100;

		System.out.println("Ваш массив: ");
		for (int i = 0; i < array.length; i++) {

			array[i] = (int) (Math.random() * multiplier);
			System.out.println(array[i]);

		}

		System.out.println("Массив с каждым третьим элементом умноженным на 2. Способ 1:");
		for (int i = 0; i < array.length; i++) {
			if ((i + 1) % 3 == 0) {
				System.out.println(array[i] * 2);
			} else {
				System.out.println(array[i]);
			}
		}

		System.out.println("Массив с каждым третьим элементом умноженным на 2. Способ 2:");
		int i = 0;
		while (i < array.length) {
			if ((i + 1) % 3 == 0) {
				System.out.println(array[i] * 2);
			} else {
				System.out.println(array[i]);
			}
			i++;
		}
		input.close();
	}

}
