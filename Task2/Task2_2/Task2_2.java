package core;

import java.util.Scanner;

public class Task2_2 {
	// 2. ����� ������������ ���� ��������� �������, �������

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("������� ����� �������:");
		int arrayLength = input.nextInt();
		int[] array = new int[arrayLength];
		Scanner inputNumber = new Scanner(System.in);

		// ���������� ������� �������������:
		for (int i = 0; i < array.length; i++) {
			System.out.println("������� ����� ����� ��� �������:");
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

		System.out.println("������������ ���� ��������� �������: " + result);
		input.close();
		inputNumber.close();
	}

}
