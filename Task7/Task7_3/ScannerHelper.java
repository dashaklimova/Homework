package core;

import java.util.ArrayList;
import java.util.Scanner;

public class ScannerHelper {
	private static Scanner input = new Scanner(System.in);

	public static ArrayList<String> readLines() {

		System.out.println("Enter several lines. Submit each line pressing Enter. Press q to quit.");
		ArrayList<String> lines = new ArrayList<String>();
		String line = input.nextLine();
		while (!line.equals("q")) {
			lines.add(line);
			line = input.nextLine();
		}

		return lines;
	}

	public static String[] readWords() {
		System.out.println("Enter several words divided by space. Press enter.");
		String line = input.nextLine();
		String[] words = line.split(" ");
		return words;
	}
}
