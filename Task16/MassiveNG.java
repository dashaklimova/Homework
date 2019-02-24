package core;

public class MassiveNG {

	private String name;
	private int[] array;

	public void setName(String name) {
		this.name = name;
	}

	public void setArray(int[] array) {
		this.array = array;
	}

	public int[] writeElementToArrayByIndex(int index, int value) {
		try {
			array[index] = value;
		} catch (IndexOutOfBoundsException ex) {
			System.out.println("Your index is out of bound. Your element is not added to the array");
			throw ex;
		}

		return array;
	}

	public int multiplyArrayElements() {
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			if (i == 0) {
				result = array[i];
				continue;
			}

			result = result * array[i];
		}

		return result;
	}

	public int[] getArrayCycleToTheRight() {
		int[] newArray = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			if (i + 2 >= array.length) {

				newArray[i + 2 - array.length] = array[i];
				continue;
			}
			newArray[i + 2] = array[i];
		}

		return newArray;
	}

	public int getMinElement() {
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
		return min;

	}

	public int getMaxElement() {
		int max = 0;
		for (int i = 0; i < array.length; i++) {

			if (i == 0) {
				max = array[i];
				continue;
			}
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;

	}

	public int getFirstArrayElement() {
		for (int i = 0; i < array.length; i++) {
		}

		return array[0];
	}

	public int getLastArrayElement() {
		for (int i = 0; i < array.length; i++) {
		}

		return array[array.length - 1];
	}

	public int[] writeArrayInReverseOrder() {
		int[] reversedArray = new int[array.length];
		for (int i = array.length - 1, k = 0; i >= 0; i--, k++) {
			reversedArray[k] = array[i];
		}

		return reversedArray;
	}

	public int getSum() {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum = sum + array[i];
		}
		return sum;
	}

	public int[] getDoubleArray() {
		int[] doubleArray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			doubleArray[i] = array[i] * 2;
		}

		return doubleArray;
	}
}
