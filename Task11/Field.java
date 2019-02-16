package core;

public class Field {

	private int id;
	private String value;

	public Field() {

	}

	public Field(int id, String value) {
		this.id = id;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return String.format("|ID: %s Value: %s", id, value);
	}

}
