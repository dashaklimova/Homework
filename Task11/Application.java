package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Application {

	public static void main(String[] args) {

		Button loginButton = new Button("Login", "Opens home page");
		Button logoutButton = new Button("Logout", "Opens login page");
		Button registerButton = new Button("Register", "Opens register page");

		Field usernameField = new Field(1, "Username");
		Field passwordField = new Field(2, "Password");
		Field searchField = new Field(3, "Search...");

		Label userNameLabel = new Label("Username");
		Label passwordLabel = new Label("Password");
		Label searchLabel = new Label("Search");

		List<String> countries = new ArrayList<String>();
		countries.add("Spain");
		countries.add("Italy");
		countries.add("Canada");
		countries.add("USA");
		countries.add("Belarus");

		List<String> months = new ArrayList<String>();
		months.add("January");
		months.add("February");
		months.add("Mart");
		months.add("April");
		months.add("May");
		months.add("June");
		months.add("July");
		months.add("August");
		months.add("September");
		months.add("October");
		months.add("November");
		months.add("December");

		Dropdown countriesDropdown = new Dropdown(countries, true, "Countries");
		Dropdown monthsDropdown = new Dropdown(months, true, "Months");

		ArrayList<Button> buttons = new ArrayList<Button>();
		buttons.add(loginButton);
		buttons.add(logoutButton);

		LinkedList<Field> fields = new LinkedList<Field>();
		fields.add(passwordField);
		fields.add(usernameField);

		HashSet<Label> labels = new HashSet<Label>();
		labels.add(passwordLabel);
		labels.add(searchLabel);

		HashMap<Integer, Dropdown> dropdowns = new HashMap<Integer, Dropdown>();
		dropdowns.put(222, monthsDropdown);

		Page homePage = new Page(buttons, fields, labels, dropdowns, 1, "Home page");

		System.out.println("Buttons before changes");
		homePage.printButtons();
		System.out.println("Fields before changes");
		homePage.printFields();
		System.out.println("Labels before changes");
		homePage.printLabels();
		System.out.println("Drop-downss before changes");
		homePage.printDropdowns();

		homePage.addButton(registerButton);
		homePage.addField(searchField);
		homePage.addLabel(userNameLabel);
		homePage.addDropdown(111, countriesDropdown);

		homePage.deleteButton(registerButton);
		homePage.deleteField(searchField);
		homePage.deleteLabel(userNameLabel);
		homePage.deleteDropdown(1, countriesDropdown);

		homePage.replaceButton(1, registerButton);
		homePage.replaceField(1, searchField);
		homePage.replaceLabel(passwordLabel, userNameLabel);
		homePage.replaceDropdown(222, countriesDropdown);

		System.out.println("Buttons after changes");
		homePage.printButtons();
		System.out.println("Fields after changes");
		homePage.printFields();
		System.out.println("Labels after changes");
		homePage.printLabels();
		System.out.println("Drop-downss after changes");
		homePage.printDropdowns();
	}

}
