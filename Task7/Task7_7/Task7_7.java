package core;

import java.util.ArrayList;

public class Task7_7 {

	public static void main(String[] args) {
		String[] words = ScannerHelper.readWords();
		ArrayList<String> wordsWithoutRepeatingLetters = getWordsWithoutRepeatingLetters(words);
		if (!wordsWithoutRepeatingLetters.isEmpty()) {
			System.out.println("First word without repeating letters: " + wordsWithoutRepeatingLetters.get(0));
		} else {
			System.out.println("There are no words without repeating letters. ");
		}
	}

	public static ArrayList<String> getWordsWithoutRepeatingLetters(String[] words) {
		ArrayList<String> wordsWithoutRepeatingLetters = new ArrayList<String>();
		for (int i = 0; i < words.length; i++) {
			if (words[i].length() == Task7_4.countUniqueChars(words[i])) {
				wordsWithoutRepeatingLetters.add(words[i]);
			}
		}
		return wordsWithoutRepeatingLetters;
	}

}
