package core;

public class Task2_point6_fromClasswork {

	// 6.Найти минимальный элемент

	public static void main(String[] args) {
		int size = 5;
		int multiplier = 100;
		int[] array = new int[size];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * multiplier);
			System.out.println(array[i]);
		}
		int min = 0;
		for (int i = 0; i < array.length; i++) {

			if (i == 0) {
				min = array[i];
				continue;
			}
			if (array[i] < min) {
				min = array[i];
			}
		}
		System.out.println("Минимальный элемент: " + min);
	}

}
