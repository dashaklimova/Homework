package core;

import java.util.ArrayList;

public class Task7_6 {

	public static void main(String[] args) {
		String[] words = ScannerHelper.readWords();
		ArrayList<String> increasingWords = getIncreasingWords(words);

		System.out.println("First increasing word is: " + increasingWords.get(0));

	}

	public static ArrayList<String> getIncreasingWords(String[] words) {
		ArrayList<String> increasingWords = new ArrayList<String>();
		for (int i = 0; i < words.length; i++) {
			if (areCodesInWordIncreasing(words[i])) {
				increasingWords.add(words[i]);
			}
		}
		return increasingWords;
	}

	public static boolean areCodesInWordIncreasing(String word) {
		char[] letters = word.toCharArray();
		boolean result = false;
		for (int i = 0; i < letters.length - 1; i++) {
			if (letters[i] <= letters[i + 1]) {
				result = true;
				continue;
			} else {
				result = false;
				break;
			}
		}

		return result;

	}

}
