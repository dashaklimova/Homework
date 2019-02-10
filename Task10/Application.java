package core;

import java.util.ArrayList;

public class Application {

	public static void main(String[] args) {
		char newChar = '%';
		TextParser parser = new TextParser();
		String text = ScannerHelper.readLines();
		int limit = parser.findMinimumWordLength(text);
		int indexToReplace = ScannerHelper.readIndexOfCharToReplace(limit);

		ArrayList<Sentence> sentencesWithWords = parser.parseText(text);
		Paragraph sourceParagraph = new Paragraph(sentencesWithWords);
		ArrayList<Sentence> sentencesWithChangedWords = WordProcessor.replaceLettersInWords(sentencesWithWords,
				indexToReplace, newChar);
		Paragraph modifiedParagraph = new Paragraph(sentencesWithChangedWords);
		System.out.println("Before modification: " + sourceParagraph);
		System.out.println("After modification: " + modifiedParagraph);

	}
}
