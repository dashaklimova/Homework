package core;

import java.util.List;

public class Dropdown {

	private List<String> options;
	private boolean isSelected;
	private String name;

	public Dropdown() {

	}

	public Dropdown(List<String> options, boolean isSelected, String name) {
		this.options = options;
		this.isSelected = isSelected;
		this.name = name;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Options: %s  Is selected: %s  Name: %s ", options, isSelected, name);
	}

}
