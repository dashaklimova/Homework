package core;

import java.util.ArrayList;

public class Task7_1 {

	public static void main(String[] args) {

		ArrayList<String> linesFromUser = ScannerHelper.readLines();
		String min = getShortestLineWithForEach(linesFromUser);
		String max = getLongesttLineWithForEach(linesFromUser);
		System.out.println(String.format("Minimum array element is: %s. Length is: %s", min, min.length()));
		System.out.println(String.format("Maximum array element is: %s. Length is: %s", max, max.length()));
	}

	// get minimum with for each
	public static String getShortestLineWithForEach(ArrayList<String> lines) {
		String min = "";
		for (String name : lines) {
			if (lines.indexOf(name) == 0) {
				min = name;
				continue;
			}
			if (name.length() < min.length()) {
				min = name;
			}
		}

		return min;
	}

	// get minimum with for
	public static String getShortestLineWithFor(ArrayList<String> lines) {

		String min = "";
		for (int i = 0; i < lines.size(); i++) {

			if (i == 0) {
				min = lines.get(i);
				continue;
			}
			if (lines.get(i).length() < min.length()) {
				min = lines.get(i);
			}
		}
		return min;
	}

	public static String getLongesttLineWithForEach(ArrayList<String> lines) {
		String max = "";
		for (String name : lines) {
			if (lines.indexOf(name) == 0) {
				max = name;
				continue;
			}
			if (name.length() > max.length()) {
				max = name;
			}
		}

		return max;
	}
}
