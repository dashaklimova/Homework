package core;

import java.util.ArrayList;

public class WordProcessor {

	public static ArrayList<Sentence> replaceLettersInWords(ArrayList<Sentence> sentencesWithWords, int indexToReplace,
			char newChar) {

		ArrayList<Sentence> sentencesWithChangedWords = new ArrayList<Sentence>();
		for (Sentence sentence : sentencesWithWords) {
			ArrayList<Word> words = new ArrayList<Word>();
			for (Word word : sentence.getWords()) {
				String replacedWord = replaceLetterByIndex(word.getValue(), indexToReplace, newChar);
				words.add(new Word(replacedWord));
			}

			sentencesWithChangedWords.add(new Sentence(words));
		}

		return sentencesWithChangedWords;
	}

	private static String replaceLetterByIndex(String stringWord, int indexToReplace, char newChar) {
		char[] letters = stringWord.toCharArray();
		for (int i = 0; i < letters.length; i++) {
			if (i == indexToReplace - 1) {
				letters[i] = newChar;
			}
		}

		return new String(letters);
	}
}
