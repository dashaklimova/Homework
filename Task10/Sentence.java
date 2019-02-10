package core;

import java.util.ArrayList;

public class Sentence {

	private ArrayList<Word> words;

	public Sentence() {

	}

	public Sentence(ArrayList<Word> words) {
		this.words = words;
	}

	public ArrayList<Word> getWords() {
		return words;
	}

	public void setWords(ArrayList<Word> words) {
		this.words = words;
	}

	@Override
	public String toString() {
		return words.toString();
	}
}
