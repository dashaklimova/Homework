package core;

import java.util.Scanner;

public class ScannerHelper {
	private static Scanner input = new Scanner(System.in);

	public static String readLines() {
		System.out.println("Enter some text. Press Enter to submit.");
		String line = input.nextLine();
		return line;
	}

	public static int readIndexOfCharToReplace(int limit) {
		System.out.println(String.format("Your shortest word is %s characters long. Enter an integer from 1 to %s: ",
				limit, limit));
		int number = input.nextInt();
		while ((number < 1) || (number > limit)) {
			System.out.println(
					String.format("Your number is not from the range from 1 to %s. Please, try again: ", limit));
			number = input.nextInt();
		}

		return number;
	}
}
