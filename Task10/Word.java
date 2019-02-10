package core;

public class Word extends AbstractWord {
	
	public Word() {
		
	}

	public Word(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public void printValue() {
		System.out.println(this.value);	
	}
	
	@Override
	public String toString() {
		return this.value;
	}
}
