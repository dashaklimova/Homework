package core;

public class Task3_1 {

	public static void main(String[] args) {
		int multiplier = 100;

		double number1ForMin = (int) (Math.random() * multiplier);
		double number2ForMin = (int) (Math.random() * multiplier);
		System.out.println("Check what number is minimum: " + number1ForMin + " or " + number2ForMin);
		System.out.println("Min number is: " + getMinNumber(number1ForMin, number2ForMin));
		System.out.println();

		double numberForEven = (int) (Math.random() * multiplier);
		System.out.println("Check if " + numberForEven + " is even.");
		System.out.println("Number is even: " + isNumberEven(numberForEven));
		System.out.println();

		double numberForSquare = (int) (Math.random() * multiplier);
		System.out.println("Square " + numberForSquare);
		System.out.println("Square of your number is: " + getSquare(numberForSquare));
		System.out.println();

		double numberForCube = (int) (Math.random() * multiplier);
		System.out.println("Cube " + numberForCube);
		System.out.println("Cube of your number is:  " + getCube(numberForCube));
		System.out.println();
	}

	// - Get the minimum of two numbers.
	public static double getMinNumber(double number1, double number2) {
		if (number1 < number2) {
			return number1;
		} else {
			return number2;
		}
	}

	// - Check if number is even.
	public static boolean isNumberEven(double number) {
		if (number % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

	// - Square the number
	public static double getSquare(double number) {
		double result = number * number;
		return result;

	}

	// - Cube the number
	public static double getCube(double number) {
		double result = number * number * number;
		return result;
	}
}
