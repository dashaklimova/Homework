package core;

public class Button {

	private String name;
	private String action;

	public Button() {
	}

	public Button(String name, String action) {
		this.name = name;
		this.action = action;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return String.format("|Name: %s Action: %s|", name, action);
	}
}
