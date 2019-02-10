package core;

import java.util.ArrayList;
import java.util.Arrays;

public class TextParser implements Parser {

	private static final String NON_ALPHA_NUMERIC = "[^a-zA-Z0-9 ]";
	private static final String space = " ";
	private static final String empty = "";

	@Override
	public ArrayList<Sentence> parseText(String text) {
		ArrayList<String> stringSentences = new ArrayList<String>(Arrays.asList(text.split("\\.")));
		ArrayList<Sentence> sentencesWithWords = new ArrayList<Sentence>();

		for (String stringSentence : stringSentences) {
			ArrayList<String> stringWords = new ArrayList<String>(
					Arrays.asList(stringSentence.trim().replaceAll(NON_ALPHA_NUMERIC, empty).split(space)));
			ArrayList<Word> wordsValue = new ArrayList<Word>();
			for (String word : stringWords) {
				Word wordValue = new Word(word);
				wordsValue.add(wordValue);
			}

			Sentence sentence = new Sentence(wordsValue);
			sentencesWithWords.add(sentence);
		}

		return sentencesWithWords;
	}

	public int findMinimumWordLength(String text) {
		int min = 0;
		String[] words = text.trim().replaceAll(NON_ALPHA_NUMERIC, empty).split(space);

		for (String word : words) {
			if (word == words[0]) {
				min = word.length();
			}

			if (word.length() < min) {
				min = word.length();
			}
		}

		return min;
	}
}
