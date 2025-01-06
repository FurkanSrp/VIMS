package p1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListData {
	public static void listAllPersons() {
		try (Connection conn = DatabaseConnection.getConnection(); Statement stmt = conn.createStatement()) {

			String selectQuery = "SELECT * FROM insured_persons";
			ResultSet rs = stmt.executeQuery(selectQuery);

			System.out.println("ID | Vorname | Nachname | Geburtsdatum | Versischerte Nummer");
			System.out.println("---------------------------------------------------");
			while (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String birthDate = rs.getString("birth_date");
				String insuranceNumber = rs.getString("insurance_number");

				System.out.printf("%d | %s | %s | %s | %s\n", id, firstName, lastName, birthDate, insuranceNumber);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
