package core;

import java.util.ArrayList;
import java.util.Collections;

public class Task7_2 {

	public static void main(String[] args) {
		ArrayList<String> linesFromUser = ScannerHelper.readLines();

		Collections.sort(linesFromUser, (a, b) -> Integer.compare(a.length(), b.length()));
		System.out.println("ArrayList in direct order: ");
		for (String line : linesFromUser) {
			System.out.println(line);
		}

		Collections.reverse(linesFromUser);
		System.out.println("ArrayList in reverse order: ");
		for (String line : linesFromUser) {
			System.out.println(line);
		}

	}

}
