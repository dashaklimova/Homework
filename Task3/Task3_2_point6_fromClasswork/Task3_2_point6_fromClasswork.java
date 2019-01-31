package core;

import java.util.Arrays;

//	6. Find minimum element 
public class Task3_2_point6_fromClasswork {

	public static void main(String[] args) {
		int size = 5;
		int[] array = new int[size];
		array = fillInArray(array);
		System.out.println("Your array " + Arrays.toString(array));
		System.out.println("Minimum element is:  " + getMinElement(array));

	}

	public static int[] fillInArray(int[] passedArray) {
		int multiplier = 100;
		for (int i = 0; i < passedArray.length; i++) {
			passedArray[i] = (int) (Math.random() * multiplier);
		}
		return passedArray;
	}

	public static int getMinElement(int[] array) {
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

}
