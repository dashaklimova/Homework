package core;

public class Task2_point7_fromClasswork {

	// 7.�������� ������� ������ � ��������� ��������

	public static void main(String[] args) {
		int multiplier = 100;
		int size = 5;
		int[] array = new int[size];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * multiplier);
			System.out.println(array[i]);
		}

		int firstNumber = array[0];
		int lastNumber = array[array.length - 1];
		System.out.println("������ ����� ������� �� ���������: " + firstNumber);
		System.out.println("��������� ����� ������� �� ���������: " + lastNumber);

		int reserveNumber = firstNumber;
		firstNumber = lastNumber;
		lastNumber = reserveNumber;
		System.out.println("������ ����� ������� ����� ���������: " + firstNumber);
		System.out.println("��������� ����� ������� ����� ���������: " + lastNumber);
	}
}
