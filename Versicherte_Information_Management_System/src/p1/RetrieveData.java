package p1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RetrieveData {

	public static List<Object[]> retrieveAllPersons() {
		List<Object[]> personList = new ArrayList<>();
		try (Connection connection = DatabaseConnection.getConnection();
				Statement stmt = connection.createStatement()) {

			String query = "SELECT * FROM insured_persons";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Object[] person = { rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("birth_date"), rs.getString("insurance_number") };
				personList.add(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personList;
	}
}
