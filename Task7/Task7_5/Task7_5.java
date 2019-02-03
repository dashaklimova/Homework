package core;

import java.util.ArrayList;

public class Task7_5 {

	public static void main(String[] args) {

		String[] wordsFromUser = ScannerHelper.readWords();
		ArrayList<String> wordsOnlyWithLetters = filterWordsWithOnlyLetters(wordsFromUser);

		ArrayList<String> wordsWithEqualVowAndConsCount = filterWordsWithEqualCountOfVowAndCon(wordsOnlyWithLetters);

		System.out.println("Word(s) with equal counts of vowels and consonant: ");
		for (String word : wordsWithEqualVowAndConsCount) {
			System.out.println(word);
		}

	}

	public static int countVowels(String word) {
		String vowels = "aeiouAEIOU";
		char[] letters = word.toCharArray();
		int vowelsCount = 0;
		for (int i = 0; i < letters.length; i++) {
			if (vowels.indexOf(letters[i]) != -1) {
				vowelsCount++;
			}
		}

		return vowelsCount;
	}

	public static int countConsonant(String word) {
		String consonants = "bcdfghjklmnpqrstvwxyz";
		char[] letters = word.toCharArray();
		int consonantCount = 0;
		for (int i = 0; i < letters.length; i++) {
			if (consonants.indexOf(Character.toLowerCase(letters[i])) != -1) {
				consonantCount++;
			}
		}

		return consonantCount;
	}

	public static ArrayList<String> filterWordsWithOnlyLetters(String[] arrayList) {
		ArrayList<String> wordsOnlyWithLetters = new ArrayList<String>();
		for (int i = 0; i < arrayList.length; i++) {
			String pattern = "[a-zA-Z]+";
			if (arrayList[i].matches(pattern)) {
				wordsOnlyWithLetters.add(arrayList[i]);
			}
		}

		return wordsOnlyWithLetters;
	}

	public static ArrayList<String> filterWordsWithEqualCountOfVowAndCon(ArrayList<String> arrayList) {
		ArrayList<String> wordsWithEqualVowAndConsCount = new ArrayList<String>();
		for (String word : arrayList) {
			if (countVowels(word) == countConsonant(word)) {
				wordsWithEqualVowAndConsCount.add(word);
			}
		}
		return wordsWithEqualVowAndConsCount;
	}
}
