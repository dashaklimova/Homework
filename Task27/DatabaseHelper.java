package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseHelper {
	private String url = "jdbc:mysql://localhost:3306/sys?useSSL=false&serverTimezone=UTC";
	private String user = "root";
	private String password = "pass";

	public ArrayList<ArrayList<String>> getCredentials() {
		ArrayList<ArrayList<String>> credentials = new ArrayList<ArrayList<String>>();
		String query = "select * from test_data.credentials";
		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			while (result.next()) {
				ArrayList<String> credentialPair = new ArrayList<String>();
				credentialPair.add(result.getString(1));
				credentialPair.add(result.getString(2));
				credentials.add(credentialPair);
			}

			result.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return credentials;
	}

	public ArrayList<String> getEmails() {
		ArrayList<String> emails = new ArrayList<String>();
		String query = "select * from test_data.emails";
		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			while (result.next()) {
				emails.add(result.getString(2));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return emails;
	}
}
