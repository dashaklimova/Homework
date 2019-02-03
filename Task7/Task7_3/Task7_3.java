package core;

import java.util.ArrayList;

public class Task7_3 {

	public static void main(String[] args) {
		ArrayList<String> linesFromUser = ScannerHelper.readLines();
		double averageSize = getAverageLength(linesFromUser);
		String space = " ";
		ArrayList<String> lessThanAvgLength = getLinesWithLengthLessThanAvg(linesFromUser, averageSize);
		ArrayList<String> moreThanAvgLength = getLinesWithLengthMoreThanAvg(linesFromUser, averageSize);

		System.out.println(String.format("Average length is %s.", averageSize));

		System.out.println("Lines with length less than average");
		for (String line : lessThanAvgLength) {
			System.out.println(line + space + line.length());
		}

		System.out.println("Lines with length more than average");
		for (String line : moreThanAvgLength) {
			System.out.println(line + space + line.length());
		}
	}

	public static ArrayList<String> getLinesWithLengthMoreThanAvg(ArrayList<String> arrayList, double averageSize) {
		ArrayList<String> moreThanAvgLength = new ArrayList<String>();
		for (String line : arrayList) {
			if (line.length() > averageSize) {
				moreThanAvgLength.add(line);
			}
		}

		return moreThanAvgLength;
	}

	public static ArrayList<String> getLinesWithLengthLessThanAvg(ArrayList<String> arrayList, double averageSize) {
		ArrayList<String> lessThanAvgLength = new ArrayList<String>();
		for (String line : arrayList) {
			if (line.length() < averageSize) {
				lessThanAvgLength.add(line);
			}
		}

		return lessThanAvgLength;
	}

	public static double getAverageLength(ArrayList<String> list) {
		double commonSize = 0;
		for (String line : list) {
			commonSize += line.length();
		}
		double averageSize = commonSize / list.size();
		return averageSize;
	}

}
