package core;

import java.util.Scanner;

public class Task2_1 {

	// 1. пройти по массиву, вывести все элементы в пр€мом и в обратном пор€дке.

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("¬ведите число: ");

		int userNumber = input.nextInt();
		int[] array = new int[userNumber];

		int multiplier = 100;

		// filling in the array with Math.random():
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * multiplier);
		}

		// output in direct order
		System.out.println("Your array in direct order.");
		int i = 0;
		while (i < array.length) {
			System.out.println(array[i]);
			i++;
		}

		// output in reverse order
		System.out.println("Your array in reverse order.");
		for (int k = array.length - 1; k >= 0; k--) {
			System.out.println(array[k]);
		}
		input.close();

	}

}
