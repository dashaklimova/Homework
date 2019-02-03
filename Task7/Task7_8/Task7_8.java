package core;

import java.util.ArrayList;

public class Task7_8 {

	public static void main(String[] args) {

		String[] words = ScannerHelper.readWords();
		ArrayList<String> wordsOnlyWithNumbers = filterWordsWithOnlyNumbers(words);
		ArrayList<String> palindromes = getPalindromes(wordsOnlyWithNumbers);

		if (palindromes.size() >= 2) {
			System.out.println("Second palindrome is: " + palindromes.get(1));
		} else if (palindromes.size() == 1) {
			System.out.println("The only palindrome is: " + palindromes.get(0));
		} else {
			System.out.println("There are no palindromes.");
		}
	}

	private static ArrayList<String> getPalindromes(ArrayList<String> wordsOnlyWithNumbers) {
		ArrayList<String> palindromes = new ArrayList<String>();

		for (int i = 0; i < wordsOnlyWithNumbers.size(); i++) {
			if (reverseWord(wordsOnlyWithNumbers.get(i)).equals(wordsOnlyWithNumbers.get(i))) {
				palindromes.add(wordsOnlyWithNumbers.get(i));
			}
		}

		return palindromes;
	}

	public static ArrayList<String> filterWordsWithOnlyNumbers(String[] arrayList) {
		ArrayList<String> wordsOnlyWithNumbers = new ArrayList<String>();
		for (int i = 0; i < arrayList.length; i++) {
			String pattern = "[0-9]+";
			if (arrayList[i].matches(pattern)) {
				wordsOnlyWithNumbers.add(arrayList[i]);
			}
		}

		return wordsOnlyWithNumbers;
	}

	public static String reverseWord(String word) {
		StringBuilder newWord = new StringBuilder(word);
		return newWord.reverse().toString();
	}

}
