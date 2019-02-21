package core;

import java.util.Arrays;

public class Massive {

	private String name;
	private int[] array;

	public Massive() {
	}

	public Massive(String name, int[] array) {
		this.name = name;
		this.array = array;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}

	@Override
	public String toString() {

		return String.format("| Name: %s | Array: %s |", name, Arrays.toString(array));
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

}
