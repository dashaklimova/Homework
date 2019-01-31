package core;

public class Massive {

	public void printMassiveAsLine(int[] array) {
		String strArray = "";
		for (int i = 0; i < array.length; i++) {
			strArray = strArray + array[i] + " ";
		}

		System.out.println(strArray);
	}

	public void printReverseMassiveAsLine(int[] array) {
		String strArray = "";
		for (int i = array.length - 1; i >= 0; i--) {
			strArray = strArray + array[i] + " ";
		}

		System.out.println(strArray);
	}

	public int getSumOfElements(int[] array) {
		int sumOfElements = 0;
		for (int i = 0; i < array.length; i++) {
			sumOfElements = sumOfElements + array[i];
		}

		return sumOfElements;
	}

	public int[] multiptyBy3(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = array[i] * 3;
		}

		return array;
	}
}
