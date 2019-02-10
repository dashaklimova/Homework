package core;

import java.util.ArrayList;

public class Paragraph {

	private ArrayList<Sentence> sentenses;

	public Paragraph() {

	}

	public Paragraph(ArrayList<Sentence> sentenses) {
		this.sentenses = sentenses;
	}

	public ArrayList<Sentence> getSentenses() {
		return sentenses;
	}

	public void setSentenses(ArrayList<Sentence> sentenses) {
		this.sentenses = sentenses;
	}
	
	@Override
	public String toString() {
		return sentenses.toString();
	}

}
